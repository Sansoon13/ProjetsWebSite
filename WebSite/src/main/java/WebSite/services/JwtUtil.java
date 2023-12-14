package WebSite.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
@PropertySource(value= {"classpath:application.yml"})
@Service
public class JwtUtil {
	@Value("")
	private String secret;
	@Value("#{new Long('${jwt.expiration}')}")
	private Long expiration;
	@Value("#{new Long('${jwt.refresh-token}')}")
	private Long refreshExpiration;
	
	
	
	public  String generateToken(UserDetails userD) {
		return generateToken(new HashMap<>(), userD);
	}
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
		
	}
	
	public boolean isTokenValid(String token,UserDetails userD) {
		final String userName=extractUsername(token);
		return (userName.equals(userD.getUsername())) && !isTokenExpired(token);
	}
	
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	private String generateToken(Map<String,Object> extraClaims,UserDetails userD) {
		return bluidToken(extraClaims,userD,expiration);
	}
	
	private String bluidToken(Map<String,Object> extraClaims, UserDetails userD,Long expiration) {
		return Jwts.builder().setClaims(extraClaims)
				.setSubject(userD.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(getSigningKey(),SignatureAlgorithm.HS512)
				.compact();
	}
	
	private <T> T extractClaim(String token,Function<Claims,T> claimsResolvers) {
		final Claims claims=extractAllClaims(token);
		return claimsResolvers.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	private Key getSigningKey() {
		byte[] keyBytes=Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	
	
	
	
}
 










