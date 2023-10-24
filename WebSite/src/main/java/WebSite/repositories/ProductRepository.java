package WebSite.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSite.entities.Category;
import WebSite.entities.Evaluation;
import WebSite.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	//All
	@Query("from Product p left join fetch p.evaluations")
	List<Product> findAllFetchEvaluations();
	
	@Query("from Product p left join fetch p.evaluations left join fetch p.ingredients")
	List<Product> findAllFetchEvaluationsAndIngredients();
	
	//Chargement des collections:
	@Query("from Product p left join fetch p.evaluations where p.id=:id")
	Optional<Product> findByIdFetchEvaluations(@Param("id")Long id);
	
	@Query("from Product p left join fetch p.ingredients where p.id=:id")
	Optional<Product> findByIdFetchIngredients(@Param("id")Long id);
	
	@Query("from Product p left join fetch p.categories where p.id=:id")
	Optional<Product> findByIdFetchCategories(@Param("id")Long id);
	
	@Query("from Product p "
			+ "left join fetch p.evaluations "
			+ "left join fetch p.ingredients "
			+ "left join fetch p.categories "
			+ "where p.id=:id")
	Optional<Product> findByIdFetchAll(@Param("id")Long id);
	
	//Requete de recherche par attributs:
	Optional<Product> findByTitle(String title);
	Optional<Product> findById(Long id);
	
	Set<Product> findByTitleContaining(String title);
	
	Set<Product> findByPriceBetween(double priceLow,double priceHigh);
	
	@Query("select e.product from Evaluation e GROUP BY e.product having AVG(e.rating)>=:avgRating")
	Set<Product> findByAvgRating(double avgRating);
	
	@Query("from Product p left join fetch p.categories c where c.category=:category")
	Set<Product> findByCategories(@Param("category")Category category);
	
//	@Query("from Product p left join fetch p.evaluations e where e.evaluation=:evaluation")
//	Set<Product> findByEvaluations(@Param("evaluation")Evaluation evaluation);
}
