package WebSite.restController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import WebSite.request.AuthenticationRequest;
import WebSite.request.RefreshTokenRequest;
import WebSite.request.RegisterRequest;
import WebSite.request.UserRequest;
import WebSite.response.authentication.AuthenticationResponse;
import WebSite.response.authentication.RefreshTokenResponse;
import WebSite.services.AuthenticationService;
import WebSite.services.RefreshTokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.PostRemove;
import jakarta.validation.Valid;

@RequestMapping("/api/v1/auth")
@RestController
@CrossOrigin(origins = "*")
@SecurityRequirement(name="Bearer")
public class AuthenticationController {
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private AuthenticationService aSrv;
	@Autowired
	private RefreshTokenService rTSrv;
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/login")
	public AuthenticationResponse connect(@RequestBody AuthenticationRequest request) {
		System.out.println(request.getUsername()+ "......"+request.getPassword());
		return aSrv.authenticate(request);
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public AuthenticationResponse register(@RequestBody UserRequest request,BindingResult br) {
		log.info("username :"+request.getUsername()+request.getRole()); 
		if(br.hasErrors()) {
			log.info("ERREUR"+br);
			throw new RuntimeException(HttpStatus.BAD_REQUEST+"");
		}
		var u=request.toUserEntity();
		return aSrv.register(request);
	}
	
	@PostMapping("/refresh-token") 
	public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest request) {
		return rTSrv.generateNewToken(request);
	}
}
