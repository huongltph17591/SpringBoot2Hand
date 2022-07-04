package AssignmentJava5.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import AssignmentJava5.entities.Order;
import AssignmentJava5.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
	@NotNull
	private int id;
	
	private Order order;
	private Product product;
	@NotEmpty
	private Double price;
	@NotEmpty
	private int quantity;
}
