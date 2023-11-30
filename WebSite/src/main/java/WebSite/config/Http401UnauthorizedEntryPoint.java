package WebSite.config;

import java.io.IOException;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import WebSite.exceptions.ErrorResponse;
import WebSite.restController.UserRestController;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint{
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	 @Override
	  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	      throws IOException, ServletException {
	    log.error("Unauthorized error: {}", authException.getMessage());
	    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	 
	    ErrorResponse body = new ErrorResponse();
	    body.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	    body.setError("Unauthorized");
	    body.setMessage(authException.getMessage());
	    body.setPath(request.getServletPath());
	    body.setTimestamp(Instant.now());
	       
	    ObjectMapper mapper = new ObjectMapper();
	    // register the JavaTimeModule, which enables Jackson to support Java 8 and higher date and time types
	    mapper.registerModule(new JavaTimeModule());
	    // ask Jackson to serialize dates as strings in the ISO 8601 format
	    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
	    mapper.writeValue(response.getOutputStream(), body);
	 }


}
