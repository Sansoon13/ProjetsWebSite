package WebSite.repositories;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import WebSite.entities.IngredProd;
import WebSite.entities.Ingredient;
import WebSite.entities.Product;
@Repository
public interface IngredProdRepository extends JpaRepository<IngredProd,Long>{
	List<IngredProd> findByIngredient(Ingredient ingredient);
	List<IngredProd> findByProduct(Product product);
	
	Optional<IngredProd> findByIngredientIdAndProductId(Long ingredientId,Long productId);
	Optional<IngredProd> findByIngredientAndProduct(Ingredient ingredient,Product product);
	
	void deleteByProduct(Product product);
}
