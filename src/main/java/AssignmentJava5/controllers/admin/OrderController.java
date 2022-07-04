package AssignmentJava5.controllers.admin;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import AssignmentJava5.entities.Account;
import AssignmentJava5.entities.Category;
import AssignmentJava5.entities.Order;
import AssignmentJava5.entities.Product;
import AssignmentJava5.model.OrderModel;
import AssignmentJava5.model.ProductModel;
import AssignmentJava5.respositories.AccountRepository;
import AssignmentJava5.respositories.OrderDao;

@Controller
public class OrderController {
//	@Autowired
//	accDao accDao;	
	
	@Autowired
	AccountRepository accDao;
	
	@Autowired
	OrderDao orderDao;	
	
	@RequestMapping("admin/orders/index")
	public String index(Model model) {
		List<Order>items=orderDao.findAll();
		model.addAttribute("items", items);
		List<Account> listUser = this.accDao.findAll();
		model.addAttribute("listUser", listUser);
		model.addAttribute("vieworders", "/orders/create");
		return "admin/orders/index";
	}
	
	@GetMapping("/orders/create")
	public String create(@ModelAttribute("item") Order ord, Model model)
	{
		List<Account> listUser = this.accDao.findAll();
		model.addAttribute("listUser", listUser);
		return "admin/orders/create";
	}
	
	@PostMapping("admin/orders/store")
	public String create(OrderModel order) {
		Order ord = new Order();
		ord.setAddress(order.getAddress());
		ord.setAccount(order.getAccount());
		ord.setCreateDate(new Date());
		orderDao.save(ord);
		return "redirect:/admin/orders/index";
	}
	
	@GetMapping("/editorder/{id}")
	public String editorder(Model model,@PathVariable("id") int id) {
		Order item = orderDao.findById(id).get();
		model.addAttribute("item", item);
		List<Account> listUser = this.accDao.findAll();
		model.addAttribute("listUser", listUser);
		return "admin/orders/edit";
	}
	
	@GetMapping("admin/orders/edit/{id}")
	public String edit(Model model,@PathVariable("id") int id) {
		model.addAttribute("vieworders","/editorder/"+id);
		
		List<Order>items=orderDao.findAll();
		model.addAttribute("items", items);
		List<Account> listUser = this.accDao.findAll();
		model.addAttribute("listUser", listUser);
		return "admin/orders/index";
	}
	
	@PostMapping("admin/orders/update/{id}")
	public String update(@PathVariable("id") Integer id,OrderModel order) {
		Order ord1 = this.orderDao.getById(id);
		Order ord = new Order();
		ord.setId(order.getId());
		ord.setAddress(order.getAddress());
		ord.setCreateDate(ord1.getCreateDate());
		ord.setAccount(order.getAccount());
		orderDao.save(ord);
		return "redirect:/admin/orders/index";
	}


	@RequestMapping("admin/orders/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		orderDao.deleteById(id);
		return "redirect:/admin/orders/index";
	}
	
}
