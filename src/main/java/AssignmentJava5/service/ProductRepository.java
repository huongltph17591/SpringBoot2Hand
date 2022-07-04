package AssignmentJava5.service;

import org.springframework.data.jpa.repository.JpaRepository;

import AssignmentJava5.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//   Product findBySku(String sku);
}
