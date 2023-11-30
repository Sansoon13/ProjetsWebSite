package WebSite.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import WebSite.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>{
	Optional<RefreshToken> findByToken(String token);
}
