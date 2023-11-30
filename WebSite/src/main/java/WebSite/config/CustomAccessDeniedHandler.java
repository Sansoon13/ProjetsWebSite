package WebSite.config;

import java.io.IOException;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);


	@Override
	  public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
	    log.error("Access denied error: {}", accessDeniedException.getMessage());
	    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	 
	    ErrorResponse body = new ErrorResponse();
	    body.setMessage(accessDeniedException.getMessage());
	    body.setError("Forbidden");
	    body.setPath(request.getServletPath());
	    body.setStatus(HttpServletResponse.SC_FORBIDDEN);
	    body.setTimestamp(Instant.now());
	    
	   
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.registerModule(new JavaTimeModule());
	    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
	    mapper.writeValue(response.getOutputStream(), body);
	 }


}
