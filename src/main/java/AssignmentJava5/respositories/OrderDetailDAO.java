package AssignmentJava5.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AssignmentJava5.entities.Order;
import AssignmentJava5.entities.Order_detail;

public interface OrderDetailDAO extends JpaRepository<Order_detail, Integer>{
	List<Order_detail> findAllByOrder_Id(int id);
	
	@Query("SELECT entity FROM Order_detail entity WHERE order=:order")
	public List<Order_detail> fillbyorderid(@Param("order") Order order);
}
