package AssignmentJava5.respositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AssignmentJava5.entities.*;
import AssignmentJava5.model.*;
//import com.poly.main.Model.StatisOrder;

public interface OrderDao extends JpaRepository<Order, Integer>{
	List<Order> findAllByAccount_Id(int id);
	List<Order> findAllById(int id);
	
	@Query("SELECT entity FROM Order entity WHERE available=:available and account=:account")
	Order getOrderByTT(@Param("available") int available,@Param("account") Account account);
	
	@Query("SELECT entity FROM Order entity WHERE account=:account")
	List<Order> getOrderBytk(@Param("account") Account account);
//	
//	@Query("SELECT new OrderModel(o.name, o.date, sum(o.product.price * o.quality), o.status) FROM Order o WHERE o.address.user.id = ?1 GROUP BY o.name, o.date, o.status")
//	List<OrderModel> getOrderModel(int id);
//	
//	@Query("SELECT new OrderModel(o.name, o.date, sum(o.product.price * o.quality), o.status) FROM Order o WHERE o.status = 0 AND o.name LIKE ?1 GROUP BY o.name, o.date, o.status ORDER BY o.date ASC")
//	Page<OrderModel> fillTableWOrder(String name, Pageable pageable);
//	
//	@Query("SELECT new OrderModel(o.name, o.date, sum(o.product.price * o.quality), o.status) FROM Order o WHERE o.status = 1 AND o.name LIKE ?1 GROUP BY o.name, o.date, o.status ORDER BY o.date ASC")
//	Page<OrderModel> fillTableWOrder2(String name, Pageable pageable);
//	

//	@Query("SELECT new StatisOrder(o.product, count(o)) FROM Order o WHERE o.product.name Like ?1 GROUP BY o.product ")
//	Page<StatisOrder> fillToTable(String name, Pageable pageable);
}
