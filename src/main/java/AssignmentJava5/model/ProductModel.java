package AssignmentJava5.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import AssignmentJava5.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
	@NotNull
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private double price;
	@NotEmpty
	private int quantity;
//	private String image;
	@NotEmpty
	private int status;
//	private Date createDate;
	@NotEmpty
	private Category category;
	
	
}
