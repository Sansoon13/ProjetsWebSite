package WebSite.services;

import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import WebSite.entities.RefreshToken;
import WebSite.entities.TokenType;
import WebSite.entities.User;
import WebSite.exceptions.UserException;
import WebSite.repositories.RefreshTokenRepository;
import WebSite.repositories.UserRepository;
import WebSite.request.RefreshTokenRequest;
import WebSite.response.authentication.RefreshTokenResponse;

@PropertySource(value= {"classpath:application.yml"})
@Service
public class RefreshTokenService {
	@Autowired
	private  UserRepository userRepo;
	@Autowired
	private  RefreshTokenRepository refreshTokenRepo;
	@Autowired
	private  JwtUtil jwt;
	
	@Value("${jwt.refresh-token}")
	private Long refreshExpiration;
	
	public RefreshToken createRefreshToken(Long userId) {
		User user=userRepo.findById(userId).orElseThrow(()->{
			throw new UserException(userId);
		});
		RefreshToken rT=new RefreshToken();
		rT.setRevoked(false);
		rT.setToken(Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes()));
		rT.setUser(user);
		rT.setExpiryDate(Instant.now().plusMillis(refreshExpiration));
		return refreshTokenRepo.save(rT);		
	}
	
	public RefreshToken verifyExpiration(RefreshToken token) {
		if(token==null) {
			throw new RuntimeException("Token is null");
		}
		if(token.getExpiryDate().compareTo(Instant.now())<0) {
			refreshTokenRepo.delete(token);
			throw new RuntimeException(token.getToken()+" Refresh Token was expired. Please make a new Authentication request");
		}
		return token;
	}
	
	public RefreshTokenResponse generateNewToken(RefreshTokenRequest request) {
		User user=refreshTokenRepo.findByToken(request.getRefreshToken())
				.map(this::verifyExpiration)
				.map(RefreshToken::getUser).orElseThrow(()->{
					throw new RuntimeException("Refresh token doesn't exist");
				});
		String token=jwt.generateToken(user);
		RefreshTokenResponse rTR=new RefreshTokenResponse();
		rTR.setAccessToken(token);
		rTR.setRefreshToken(request.getRefreshToken());
		rTR.setTokenType(TokenType.BEARER.name());
		return rTR;
	}
}
