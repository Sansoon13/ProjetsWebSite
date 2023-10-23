package WebSiteBack.webSiteBack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@SecurityScheme(type=SecuritySchemeType.HTTP,name="basicAuth",scheme="basic")
public class ConfigSecurity {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers("").hasAnyRole("USER","ADMIN")
			.requestMatchers("/swagger-ui/**","/v3/**","/swagger-ui.html","/api/demo/post").permitAll()
			.anyRequest().permitAll();
		}); 
		http.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
