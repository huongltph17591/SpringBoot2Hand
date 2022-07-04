package AssignmentJava5.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mysql.fabric.xmlrpc.base.Array;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_details")
public class Order_detail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="price")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	public Product product;
//	
	@ManyToOne
	@JoinColumn(name="order_id")
	public Order order;
	
}
