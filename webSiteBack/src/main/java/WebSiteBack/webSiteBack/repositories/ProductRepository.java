package WebSiteBack.webSiteBack.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSiteBack.webSiteBack.entities.Evaluation;
import WebSiteBack.webSiteBack.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findByTitle(String title);
	Optional<Product> findById(Long id);
	@Query("from Product p left join fetch p.evaluations where p.id=id")
	List<Product> findByIdFetchEvaluation(@Param("id")Long id);
	
	List<Product> findByEvaluations(Evaluation evalution);
	
	@Query("from Product p left join fetch p.ingredProduct where p.id=id")
	List<Product> findByIdFetchingredProduct(@Param("id")Long id);
	
}
