package AssignmentJava5.respositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import AssignmentJava5.entities.*;

public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	
	
	@Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
	List<Product>findByPrice(Integer minPrice,Integer maxPrice);
	
//	@Query("SELECT new Report(o.category, sum(o.price), count(o)) "
//			+ " FROM Product o "
//			+ " GROUP BY o.category"
//			+ " ORDER BY sum(o.price) DESC")
//			List<Report> getInventoryByCategory();
	List<Product> findAllByCategoryId(int id);
    Product findById(int id);
    Product deleteById(long id);
    Product findAllById(long id);
	
	
	Page<Product> findByNameLike(String keywords, Pageable pageable);
    Page<Product> findByCategoryId(long keywords, Pageable pageable);
    Page<Product> findByPriceBetween(double a ,double b, Pageable pageable);
}
