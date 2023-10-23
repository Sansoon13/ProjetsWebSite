package WebSite.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebSite.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findByTitle(String title);
	Optional<Category> findByTitleContaining(String title);
	@Query("from Category c left join fetch c.products where c.id=:id")
	List<Category> findByIdFetchProducts(@Param("id")Long id);
	
	
}
