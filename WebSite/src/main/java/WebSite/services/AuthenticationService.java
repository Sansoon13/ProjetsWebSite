package WebSite.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import WebSite.entities.TokenType;
import WebSite.entities.User;
import WebSite.exceptions.UserException;
import WebSite.repositories.RefreshTokenRepository;
import WebSite.repositories.UserRepository;
import WebSite.request.AuthenticationRequest;
import WebSite.request.RegisterRequest;
import WebSite.request.UserRequest;
import WebSite.response.authentication.AuthenticationResponse;
import WebSite.response.user.UserResponse;
import WebSite.restController.UserRestController;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthenticationService {
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	@Autowired
	private  PasswordEncoder psEncoder;
	@Autowired
	private  JwtUtil jwtSrv;
	@Autowired
	private  UserRepository userRepo;
	@Autowired
	private  AuthenticationManager authManager;
	@Autowired
	private  RefreshTokenService refreshSrv;

	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		User user=userRepo.findByUsername(request.getUsername()).orElseThrow(()->{
			throw new UserException("user with the username : "+request.getUsername()+" is unknown");
		});
		var jwt=jwtSrv.generateToken(user);
		var refreshToken=refreshSrv.createRefreshToken(user.getId());
		
		AuthenticationResponse aR=new AuthenticationResponse();
		aR.setAccessToken(jwt);
		aR.setUsername(user.getUsername());
		aR.setId(user.getId());
		aR.setTokenType(TokenType.BEARER.name());
		aR.setRefreshToken(refreshToken.getToken());
		System.out.println(aR.getAccessToken()+ aR.getRefreshToken()+ aR.getUsername());
		return aR;
	}
	
	public AuthenticationResponse register(UserRequest user) {
		if(userRepo.findByUsername(user.getUsername()).isPresent()) {
			throw new RuntimeException("Username already taken");
		}
		if(userRepo.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Email already taken");
		}
		
		//user.setPassword(psEncoder.encode(user.getPassword()));
		
		User u=new User();
		u.setPassword(psEncoder.encode(user.getPassword()));
		u.setAdresse(user.getAdresse());
		u.setDateEntry(user.getDateEntry());
		u.setEmail(user.getEmail());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setUsername(user.getUsername());
		u.setRole(user.getRole());;
		
		
		userRepo.save(u);
		var jwt=jwtSrv.generateToken(u);
		var refreshToken=refreshSrv.createRefreshToken(u.getId());
		
		var roles=u.getRole().getAuthorities()
				.stream()
				.map(SimpleGrantedAuthority::getAuthority)
				.toList();
		
		var aR=new AuthenticationResponse();
		aR.setAccessToken(jwt);
		aR.setUsername(u.getUsername());
		aR.setRefreshToken(refreshToken.getToken());
		aR.setRoles(roles);
		aR.setId(u.getId());
		aR.setTokenType(TokenType.BEARER.name());
		
		return aR;
	}
	
	
	
	
	
}
