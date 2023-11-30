package WebSite.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import WebSite.services.JwtUtil;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	private JwtUtil jwtSrv;
	private UserDetailsService userDSrv;
	
	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, 
									@NonNull HttpServletResponse response,
									@NonNull FilterChain filterChain)
									throws ServletException, IOException {
		
		String authHeader=request.getHeader("Authorization");
		if(authHeader==null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		String jwt=authHeader.substring(7); //après le Bearer ..
		String username=jwtSrv.extractUsername(jwt);
		if(StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userD=this.userDSrv.loadUserByUsername(username);
			if(jwtSrv.isTokenValid(jwt, userD)) {
				SecurityContext context= SecurityContextHolder.createEmptyContext();
				UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userD, null,userD.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				context.setAuthentication(authToken);
				SecurityContextHolder.setContext(context);
			}
		}
		filterChain.doFilter(request, response);
				
	}

}
