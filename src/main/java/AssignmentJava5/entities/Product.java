package AssignmentJava5.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image")
	private String image;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="created_date")
	private Date createDate;
	
	@Column(name="status")
	private Integer status;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
//	
	@OneToMany(mappedBy = "product")
	private List<Order_detail> orderDetails;
	
	
}
