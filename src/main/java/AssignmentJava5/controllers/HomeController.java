	package AssignmentJava5.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AssignmentJava5.entities.Order;
import AssignmentJava5.entities.Order_detail;
import AssignmentJava5.entities.Product;
import AssignmentJava5.respositories.CategoryDAO;
import AssignmentJava5.respositories.OrderDao;
import AssignmentJava5.respositories.OrderDetailDAO;
import AssignmentJava5.respositories.ProductDAO;
import AssignmentJava5.service.ProductRepository;
import AssignmentJava5.utils.UploadFileUtils;
@Controller
public class HomeController {
	@Autowired
	ProductDAO dao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	 @Autowired
	    OrderDao orderDAO;
	   @Autowired
	    OrderDetailDAO oderDetailDAO;
	
	@Autowired
	private UploadFileUtils uploadUtil;
	
	@Autowired
	private ProductRepository pr;
	
	@GetMapping("/layoutchange/body")
	public String index(Model model,@RequestParam("p") Optional<Integer> p)
	{
		Product item=new Product();
		model.addAttribute("item", item);
		List<Product>items=dao.findAll();
		for (Product product : items) {
			if (product.getQuantity()<=0) {
				product.setStatus(1);
				pr.save(product);
			} 
		}
		
		model.addAttribute("items", items);
		Pageable pageable = PageRequest.of(p.orElse(0), 10);
        Page<Product> page = dao.findAll(pageable);
        model.addAttribute("page", page);
		return "/layoutchange/body";
	}
	
	@GetMapping("/layoutchange/list")
	public String list(Model model)
	{
		Product item=new Product();
		model.addAttribute("item", item);
		List<Product>items=dao.findAll();
		model.addAttribute("items", items);
//		Pageable pageable = PageRequest.of(p.orElse(0), 10);
//        Page<Product> page = dao.findAll(pageable);
//        model.addAttribute("page", page);
		return "/home";
	}
	
	@RequestMapping("/home/views")
	public String show(Model model) {
        model.addAttribute("homeviews","/layoutchange/body");
        
		return "layout";
	}
	
	@RequestMapping("/home/list")
	public String showlist(Model model) {
        model.addAttribute("homeviews","/layoutchange/list");
		return "layout";
	}
	
    @RequestMapping("/home/YourCart/{id}")
    public String YourCart(Model model , @PathVariable("id") Integer id){
         List<Order> items = orderDAO.findAllByAccount_Id( id);
         model.addAttribute("items",items);
        return "layoutchange/YourCart";
    }
    @RequestMapping("/home/YourCart/Details/{id}")
    public String Details(Model model , @PathVariable("id") Integer id){
        List<Order_detail> items = oderDetailDAO.findAllByOrder_Id(id);
        model.addAttribute("items",items);
        return "layoutchange/CartDetails";
    }
//    @RequestMapping("/home/YourCart/Cancel/{id}")
//    public String Cancel(Model model,@PathVariable("id") Integer id){
//        List<Order> item = orderDAO.findAllById(id);
//        for(Order x : item) {
//            if(x.getConfirm() == true) {
//                model.addAttribute("message","You can't cancel your order because your status is confirmed");
//            } else {
//                x.setAvailable(false);
//                orderDAO.save(x);
//                model.addAttribute("message","Cancel success");
//            }
//        }
//        model.addAttribute("items",item);
//        return "layoutchange/YourCart";
//
//    }
    
    @GetMapping("/admin1/homeAdmin")
	public String showAdmin(Model model)
	{
    	model.addAttribute("viewsAdmin","/layoutchange/body");
//      model.addAttribute("viewsAdmin","/admin/category/index");
//      model.addAttribute("viewsAdmin","admin/product/index");
//      model.addAttribute("viewsAdmin","admin/orders/index");
//      model.addAttribute("viewsAdmin","admin/orderdetails/index");
		return "/admin/homeAdmin";
	}
    
    @GetMapping("/accounts/homeAdmin")
	public String accAdmin(Model model)
	{
    	model.addAttribute("viewsAdmin","/admin/accounts/index");
		return "/admin/homeAdmin";
	}
    
    @GetMapping("/categorys/homeAdmin")
	public String cateAdmin(Model model)
	{
    	model.addAttribute("viewsAdmin","/admin/category/index");
		return "/admin/homeAdmin";
	}
    
    @GetMapping("/homeAdmin/views")
	public String homeAdmin(Model model) {
    	model.addAttribute("homeviews","/admin1/homeAdmin");
		return "layout";
	}
    
//    @GetMapping("/homeAdmin/views/accounts")
//	public String accAdmin(Model model) {
//    	model.addAttribute("homeviews","/admin/accounts/index");
//		return "layout";
//	}
//    
//    @GetMapping("/homeAdmin/views/category")
//	public String cateAdmin(Model model) {
//    	model.addAttribute("homeviews","/admin1/homeAdmin");
//		return "layout";
//	}
}
