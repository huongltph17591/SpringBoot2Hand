package AssignmentJava5.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import AssignmentJava5.entities.Account;

public interface AccountRepository
	extends JpaRepository<Account, Integer> {
	@Query("SELECT entity FROM Account entity WHERE email=:email")
	public Account findByEmail(@Param("email") String email);
//	
//	@Query(name="Account.findByEmail")
//	public Account timTheoEmail(@Param("email") String email);
//	
//	public List<Account> findByFullnameLike(String fullname);
	
	Account findAccountByUsername(String username);
}
