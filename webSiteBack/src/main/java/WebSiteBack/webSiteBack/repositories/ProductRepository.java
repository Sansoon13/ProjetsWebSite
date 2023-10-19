package WebSiteBack.webSiteBack.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import WebSiteBack.webSiteBack.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findByTitle(String title);
	Optional<Product> findById(Long id);
	List<Product> findByEvaluation(Evaluation evaluation);
	
}
