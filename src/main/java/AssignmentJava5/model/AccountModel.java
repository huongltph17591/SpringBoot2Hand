package AssignmentJava5.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import AssignmentJava5.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	@NotNull
	private int id;
	@NotBlank
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String fullname;
	@NotEmpty
	private String sdt;
	@NotEmpty
	@Email
	private String email;
//	private String photo;
	@NotEmpty
	private int activated;
	@NotEmpty
	private int admin;
}
