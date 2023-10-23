package WebSite.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSite.entities.IngredProd;
import WebSite.entities.Ingredient;
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
	
	Optional<Ingredient> findByName(String name);
	
	@Query("from Ingredient i left join fetch i.ingredprod where i.id=:id")
	List<Ingredient> findByIdFecthIngredProd(@Param("id")Long id);
}
