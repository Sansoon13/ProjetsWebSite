package WebSite.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSite.entities.Category;
import WebSite.entities.Product;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByTitle(String title);
	Optional<Category> findById(Long id);
	List<Category> findByTitleContaining(String title);
	@Query("from Category c left join fetch c.products where c.id=:id")
	Optional<Category> findByIdFetchProducts(@Param("id")Long id);
	
	@Query("from Category c left join fetch c.products p where p.product=:product")
	List<Category> findByProducts(@Param("product")Product product);
	
}
