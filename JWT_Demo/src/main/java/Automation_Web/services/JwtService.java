package Automation_Web.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.lang.Function;
import lombok.Value;

@Service
public class JwtService {
	@Value("${security.jwt. secret-key}")
	private String secretKey;
	
	@Value("${security. jwt. expiration-time}")
	private long jwtExpiration;
	
	public String extractUsername(String token) {
	return extractClaim(token, Claims:: getSubject);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	final Claims claims = extractAllClaims(token);
	return claimsResolver.apply(claims);
	}
	
	public String generateToken (UserDetails userDetails) {
	return generateToken(new HashMap<>(), userDetails);
}
	
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
		return buildToken(extraClaims, userDetails, jwtExpiration);
	}
		public long getExpirationTime() {
		return jwtExpiration;
		}
		private String buildToken(
		Map<String, Object> extraClaims,
		UserDetails userDetails,
		long expiration
		) {
		return Jwts.builder()
		.claims (extraClaims)
		.subject(userDetails.getUsername())
		.issuedAt(new Date(System.currentTimeMillis()))
		// the token will be expired in 30 hours
		.expiration(new Date(System.currentTimeMillis() + 1000* 60 * 60 *30))
		.signWith(getSignInKey(), Jwts. SIG.HS256)
		.compact();
		}
		public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
}
}
