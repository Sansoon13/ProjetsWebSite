package WebSite.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import WebSite.entities.Category;
import WebSite.entities.CategoryProduct;
import WebSite.entities.Product;
@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct, Long>{
		List<CategoryProduct> findByCategory(Category category);
		List<CategoryProduct> findByProduct(Product product);
		List<CategoryProduct> findByCategoryAndProduct(Category category,Product product);
		void deleteByProduct(Product product);
}
