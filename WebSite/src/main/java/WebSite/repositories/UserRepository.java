package WebSite.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSite.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	Optional<User> findByFirstName(String firstName);
	Optional<User> findByLastName(String lastName);
	
	@Query("from User u left join fetch u.evaluations where u.id=:id")
	Optional<User> findByIdFetchEvaluations(@Param("id")Long id);
	
	
}
