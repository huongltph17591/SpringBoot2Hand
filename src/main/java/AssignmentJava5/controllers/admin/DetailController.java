package AssignmentJava5.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import AssignmentJava5.entities.Order;
import AssignmentJava5.entities.Order_detail;
import AssignmentJava5.entities.Product;
import AssignmentJava5.model.OrderDetailModel;
import AssignmentJava5.respositories.OrderDao;
import AssignmentJava5.respositories.OrderDetailDAO;
import AssignmentJava5.respositories.ProductDAO;

@Controller
public class DetailController {
	@Autowired
	OrderDetailDAO orderdetailDAO;	
	
	@Autowired
	OrderDao orderDao;	
	
	@Autowired
	ProductDAO proDAO;
	
	@RequestMapping("admin/orderdetails/index")
	public String index(Model model) {
		List<Order_detail>items=orderdetailDAO.findAll();
		model.addAttribute("items", items);
		List<Order> listOrder = this.orderDao.findAll();
		model.addAttribute("listOrder", listOrder);
		List<Product> listPro = this.proDAO.findAll();
		model.addAttribute("listPro", listPro);
		model.addAttribute("viewodt", "/orderdetails/create");
		return "admin/orderdetails/index";
	}
	
	@GetMapping("/orderdetails/create")
	public String create(@ModelAttribute("item") Order_detail orderdetail, Model model)
	{
		List<Order> listOrder = this.orderDao.findAll();
		model.addAttribute("listOrder", listOrder);
		List<Product> listPro = this.proDAO.findAll();
		model.addAttribute("listPro", listPro);
		return "admin/orderdetails/create";
	}
	
	@PostMapping("admin/orderdetails/store")
	public String create(OrderDetailModel orderdetailModel) {
		Order_detail orderdetail = new Order_detail();
		orderdetail.setOrder(orderdetailModel.getOrder());
		orderdetail.setProduct(orderdetailModel.getProduct());
		orderdetail.setPrice(orderdetailModel.getPrice());
		orderdetail.setQuantity(orderdetailModel.getQuantity());
		orderdetailDAO.save(orderdetail);
		return "redirect:/admin/orderdetails/index";
	}
	
	@GetMapping("/editorderdetails/{id}")
	public String editorderdetails(Model model,@PathVariable("id") int id) {
		Order_detail item = orderdetailDAO.findById(id).get();
		model.addAttribute("item", item);
		List<Order> listOrder = this.orderDao.findAll();
		model.addAttribute("listOrder", listOrder);
		List<Product> listPro = this.proDAO.findAll();
		model.addAttribute("listPro", listPro);
		return "admin/orderdetails/edit";
	}
	
	@GetMapping("admin/orderdetails/edit/{id}")
	public String edit(Model model,@PathVariable("id") int id) {
		model.addAttribute("viewodt","/editorderdetails/"+id);
		
		List<Order_detail>items=orderdetailDAO.findAll();
		model.addAttribute("items", items);
		List<Order> listOrder = this.orderDao.findAll();
		model.addAttribute("listOrder", listOrder);
		List<Product> listPro = this.proDAO.findAll();
		model.addAttribute("listPro", listPro);
		return "admin/orderdetails/index";
	}
	
	@PostMapping("admin/orderdetails/update/{id}")
	public String update(@PathVariable("id") Integer id,OrderDetailModel orderdetailModel) {
		Order_detail odt1 = this.orderdetailDAO.getById(id);
		Order_detail odt = new Order_detail();
		odt.setId(orderdetailModel.getId());
		odt.setPrice(orderdetailModel.getPrice());
		odt.setOrder(odt1.getOrder());
		odt.setProduct(orderdetailModel.getProduct());
		odt.setQuantity(orderdetailModel.getQuantity());
		orderdetailDAO.save(odt);
		return "redirect:/admin/orderdetails/index";
	}


	@RequestMapping("admin/orderdetails/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		orderdetailDAO.deleteById(id);
		return "redirect:/admin/orderdetails/index";
	}

}
