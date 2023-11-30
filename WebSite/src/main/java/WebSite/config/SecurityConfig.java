package WebSite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import WebSite.filter.JwtAuthenticationFilter;
import WebSite.repositories.UserRepository;
import WebSite.services.CustomUserDetailsService;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true) //par défaut
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "basicAuth", scheme = "basic")
public class SecurityConfig {
	@Autowired
	private UserRepository userRepo;
	
	private Http401UnauthorizedEntryPoint unauthorizedEntryPoint;
	
	private CustomAccessDeniedHandler acessDeniedHandler;
	@Autowired
	private JwtAuthenticationFilter jwtAuthFilter;
	private AuthenticationProvider authProvider;
	
	@Bean
	SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
		.exceptionHandling(exception->exception
							.authenticationEntryPoint(unauthorizedEntryPoint)
							.accessDeniedHandler(acessDeniedHandler)
							)

		.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/api/**").permitAll()				
			.requestMatchers("/api/v1/auth/**").permitAll()
					.requestMatchers("/swagger-ui/**", "/v3/**", "/swagger-ui.html", "/api/demo/post").permitAll()
					.requestMatchers("/api/user/{id}").permitAll();
					//.anyRequest().authenticated();

		})

		.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); 		
        return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> userRepo.findByUsername(username).orElseThrow(()->{
			throw new RuntimeException("User not found with the username "+username);
		});
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
}
