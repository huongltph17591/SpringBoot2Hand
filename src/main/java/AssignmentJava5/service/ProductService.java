package AssignmentJava5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AssignmentJava5.entities.Product;

@Service//chi ra day la service
@Transactional//chi ra hoat dong theo co che giao dich
public class ProductService {
	@Autowired//tiem interface vao service
	private ProductRepository repo;
	//chuc nang lay toan bo san pham
	public List<Product> listAll()
	{
		return repo.findAll();
	}
	//chuc nang them san pham
	public void save(Product product)
	{
		repo.save(product);
	}
	//chuc nang lay 1 san pham theo id
	public Product get(int id)
	{
		return repo.findById(id).get();
	}
	//chuc nang xoa san pham
	public void delete(int id)
	{
		repo.deleteById(id);
	}

}
