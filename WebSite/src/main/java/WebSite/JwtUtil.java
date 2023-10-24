package WebSite;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	private static final String SECRET="clé-secrete";
	//private static final Long EXPIRATION_TIME = 864_000_000; //10 jours
	
//	public static String generateToken(String username) {
//		return Jwts.builder().setSubject(username)
//				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
//				.signWith(SignatureAlgorithm.ES512,SECRET).compact();
//	}
//	
//	public static String extractUsername(String token) {
//		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token)
//				.getBody().getSubject();
//	}
}
