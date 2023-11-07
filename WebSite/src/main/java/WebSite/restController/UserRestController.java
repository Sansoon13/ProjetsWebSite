package WebSite.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import WebSite.entities.User;
import WebSite.exceptions.UserException;
import WebSite.request.UserRequest;
import WebSite.response.user.UserResponse;
import WebSite.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
@SecurityRequirement(name="basicAuth")
public class UserRestController {
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserService userSrv;
	
	@GetMapping("/connect")
	@SecurityRequirement(name="basicAuth")
	public UserResponse connect(@AuthenticationPrincipal User userConnected) {
		return new UserResponse(userConnected);
	}
	
	@GetMapping("/{id}")
	public UserResponse getUserById(@PathVariable Long id) {
		User foundUser=userSrv.findById(id);
		if(foundUser==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return new UserResponse(foundUser);
	}
}
