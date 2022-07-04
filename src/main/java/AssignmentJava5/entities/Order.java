package AssignmentJava5.entities;

import java.util.Date;
import java.util.Iterator;
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


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private Account account;
	
	@OneToMany(mappedBy = "order")
	private List<Order_detail>orderDetails;
	
	@Column(name="total")
	private Integer total;
	
	@Column(name="available")
	private int available;
//    Boolean confirm;
	
	
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", createDate=" + createDate + ", address=" + address + ", account=" + account
				+ ", orderDetails=" + orderDetails + ", total=" + total + ", available=" + available + "]";
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Date getCreateDate() {
		return createDate;
	}




	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public Account getAccount() {
		return account;
	}




	public void setAccount(Account account) {
		this.account = account;
	}




	public List<Order_detail> getOrderDetails() {
		return orderDetails;
	}




	public void setOrderDetails(List<Order_detail> orderDetails) {
		
		this.orderDetails = orderDetails;
	}




	public Integer getTotal() {
		return total;
	}




	public void setTotal(Integer total) {
		this.total = total;
	}




	public int getAvailable() {
		return available;
	}




	public void setAvailable(int available) {
		this.available = available;
	}
	
}
