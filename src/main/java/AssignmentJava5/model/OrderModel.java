package AssignmentJava5.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import AssignmentJava5.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderModel {
	@NotNull
	private int id;
	private Account account;
//	private Date create_date;
	@NotEmpty
	private String address;
}
