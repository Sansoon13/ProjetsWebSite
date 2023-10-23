package WebSite.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSite.entities.Evaluation;
import WebSite.entities.Product;
import WebSite.entities.User;
import jakarta.transaction.Transactional;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long>{
	Optional<Evaluation> findByRating(String rating);
	Optional<Evaluation> findByComment(String comment);
	Optional<Evaluation> findById(Long id);
	List<Evaluation> findByAuthor(User author);
	List<Evaluation> findByProduct(Product product);
	
	@Modifying
	@Transactional
	void deleteByProduct(Product product);
	
	@Modifying
	@Transactional
	@Query("update Evaluation e set e.author=null where e.author=:author")
	void setUserToNull(@Param("author")User author);

}
