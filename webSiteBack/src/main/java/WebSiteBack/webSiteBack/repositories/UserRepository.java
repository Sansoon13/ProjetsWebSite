package WebSiteBack.webSiteBack.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSiteBack.webSiteBack.entities.Evaluation;
import WebSiteBack.webSiteBack.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long id);
	@Query("from User u left join u.evaluations where u.id=id")
	List<User> findByIdFetchEvaluations(@Param("id")Long id);
	
	List<User> findByEvaluations(Evaluation evalution);
	
	
}
 