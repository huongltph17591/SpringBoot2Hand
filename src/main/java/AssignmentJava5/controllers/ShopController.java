package AssignmentJava5.controllers;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AssignmentJava5.model.CartItem;
import AssignmentJava5.entities.Account;
import AssignmentJava5.entities.Order;
import AssignmentJava5.entities.Order_detail;
import AssignmentJava5.entities.Product;
import AssignmentJava5.model.*;
import AssignmentJava5.respositories.OrderDao;
import AssignmentJava5.respositories.OrderDetailDAO;
import AssignmentJava5.respositories.ProductDAO;
import AssignmentJava5.service.*;
@Controller
@RequestMapping("/shoppingcart")
public class ShopController {
	@Autowired
    private CartManager cartManager;
    @Autowired
    private ProductService service;
    @Autowired
    ProductDAO dao;
    @Autowired
    OrderDao oder;
    @Autowired
    OrderDetailDAO orderDetails;
    @Autowired
	private HttpServletRequest request;
//    @Autowired
//    ShoppingCartService shoppingCartService;
    
    
    @RequestMapping("/indexcart")
    public String index(HttpSession session,Model model){
        Account u = (Account) session.getAttribute("account");
        System.out.println(u);
    	Order or = this.oder.getOrderByTT(0,u);
    	
    	if (or!=null) {
    		model.addAttribute("ord", or);
    		List<Order_detail> od = this.orderDetails.fillbyorderid(or);
    		
    		for (Order_detail order_detail : od) {
    			if (order_detail.getOrder().getId()== or.getId()) {
    				or.setOrderDetails(od);
    			}
			
			System.out.println(or);
		}
		}
    	
        return "/shoppingcart/indexcart";
    }
    
    @RequestMapping(value = "/add/{id}")
    public String add(HttpSession session, @PathVariable("id") Integer id){
        Product product = service.get(id);
        System.out.println(product);
        Account u = (Account) session.getAttribute("account");
        Order order = this.oder.getOrderByTT(0,u);
        float tong =0;
        if (u==null) {
        	 return "redirect:/home/views";
		}
        else if (order==null) {
        	Order ord = new Order();
        	ord.setAddress("");
    		ord.setAccount(u);
    		ord.setCreateDate(new Date());
    		ord.setTotal(0);
    		ord.setAvailable(0);
    		this.oder.save(ord);
    		System.out.println(ord);
    		
    		Order order2 = this.oder.getOrderByTT(0,u);
			List<Order_detail> od = this.orderDetails.fillbyorderid(order2);
    		Order_detail odt = new Order_detail();
			odt.setOrder(order2);
			odt.setProduct(product);
			odt.setQuantity(1);
			odt.setPrice(product.getPrice());
			System.out.println(odt+"//");
			this.orderDetails.save(odt);
			for (Order_detail order_detail : od) {
				tong=(float) (order_detail.getPrice()+tong);
			}
			order2.setTotal((int) tong);
			this.oder.save(order2);
			return "redirect:/shoppingcart/indexcart";
		}else {
	        	List<Order_detail> od = this.orderDetails.fillbyorderid(order);
	        	for (Order_detail ord : od) {
					if (ord.getProduct().getId()== id) {
						Order_detail odt = new Order_detail();
						odt.setId(ord.getId());
						odt.setOrder(order);
						odt.setProduct(product);
						System.out.println(odt);
						odt.setQuantity(ord.getQuantity()+1);
						odt.setPrice(product.getPrice()*odt.getQuantity());
						this.orderDetails.save(odt);
						for (Order_detail order_detail : od) {
							tong=(float) (order_detail.getPrice()+tong);
						}
						order.setTotal((int) tong);
						this.oder.save(order);
						System.out.println("????");
						return "redirect:/shoppingcart/indexcart";
					}
				}
	        	for (Order_detail ord : od) {
					 if(ord.getProduct().getId() != id) {
						Order_detail odt = new Order_detail();
						odt.setOrder(order);
						odt.setProduct(product);
						odt.setQuantity(1);
						odt.setPrice(product.getPrice());
						System.out.println(odt);
						this.orderDetails.save(odt);
						for (Order_detail order_detail : od) {
							tong=(float) (order_detail.getPrice()+tong);
						}
						order.setTotal((int) tong);
						this.oder.save(order);
						return "redirect:/shoppingcart/indexcart";
					}
				}
	        	
		}
        
        
        return "redirect:/shoppingcart/indexcart";
    }

    @RequestMapping("/remove/{id}")
    public String remove(HttpSession session, @PathVariable("id") Integer id){
    	Product product = service.get(id);
    	Account u = (Account) session.getAttribute("account");
        Order order = this.oder.getOrderByTT(0,u);
        List<Order_detail> od = this.orderDetails.fillbyorderid(order);
        for (Order_detail ord : od) {
			if (ord.getProduct().getId()==product.getId()) {
				this.orderDetails.delete(ord);
				return "redirect:/shoppingcart/indexcart";
			}
		}
        return "redirect:/shoppingcart/indexcart";
    }

    @RequestMapping("/update/{id}")
    public String update(HttpSession session, @PathVariable("id") Integer id, @RequestParam("quantity") int quantity){
    	Product product = service.get(id);
        System.out.println(product);
        Account u = (Account) session.getAttribute("account");
        Order order = this.oder.getOrderByTT(0,u);
        List<Order_detail> od = this.orderDetails.fillbyorderid(order);
        float tong =0;
        for (Order_detail ord : od) {
			if (ord.getProduct().getId()==product.getId()) {
				Order_detail odt = new Order_detail();
				odt.setId(ord.getId());
				odt.setOrder(order);
				odt.setProduct(product);
				System.out.println(odt);
				odt.setQuantity(quantity);
				odt.setPrice(product.getPrice()*odt.getQuantity());
				this.orderDetails.save(odt);
				for (Order_detail order_detail : od) {
					tong=(float) (order_detail.getPrice()+tong);
				}
				order.setTotal((int) tong);
				this.oder.save(order);
				System.out.println("????");
				return "redirect:/shoppingcart/indexcart";
			}
		}
    	
        return "redirect:/shoppingcart/indexcart";
    }
    
    @PostMapping("/save")
    public String save(HttpSession session,Model model, @RequestParam("address") String address){
    	 Account u = (Account) session.getAttribute("account");
         Order order = this.oder.getOrderByTT(0,u);
         List<Order_detail> od = this.orderDetails.fillbyorderid(order);
         System.out.println("////");
         for (Order_detail ord : od) {
 			Product p = this.dao.getById(ord.getProduct().getId());
 			p.setQuantity(p.getQuantity()-ord.getQuantity());
 			this.dao.save(p);
 		}
         order.setAddress(address);
         order.setAvailable(1);
         this.oder.save(order);

        return "shoppingcart/indexcart";
    }
    
    
    
//    @RequestMapping("/save")
//    public String save(HttpSession session,Model model,@ModelAttribute("item") Order item
//    		){
//    	
//    	
//    	Cart cart = cartManager.getCart(session);
//    	model.addAttribute("items",cart);
//    	oder.save(item);
//    	List<CartItem> citm = cart.getItems();
//    	
//    	for (CartItem x : citm) {
//			Product p = dao.findAllById(x.getId());
//			
////			p.setQuantity(p.getQuantity()-c.getQuantity());
////			service.save(x);
//			
//			Order_detail items = new Order_detail();
////          Product prd = dao.findAllById(x.getId());
//          p.setId(x.getId());
//          items.setQuantity(x.getQuantity());
//          items.setOrder(item);
////          items.setPrice(x.getPrice());
//          items.setProduct(p);
//          Product product = dao.findAllById(x.getId());
//          if(product.getQuantity() < x.getQuantity()){
//              model.addAttribute("message","This product just have "+product.getQuantity());
//          }else{
//              orderDetails.save(items);
//              product.setQuantity(product.getQuantity()-items.getQuantity());
//              dao.save(product);
//              model.addAttribute("message", "Order Success");
//
//          }
//		}
////    	cart.clear();
////    	model.addAttribute("tt", cart.getTotal());
//        return "/shoppingcart/indexcart";
//    }
    
//    @RequestMapping("/save")
//    public String save(Model model ,@ModelAttribute("item") Order item ){
//        oder.save(item);
//        Collection<CartItem>  carts = shoppingCartService.getCartItems();
//        Product prd = new Product();
//        for(CartItem x : carts){
//            OrderDetailModel items = new OrderDetailModel();
////            Product prd = dao.findAllById(x.getId());
//            prd.setId(x.getId());
//            items.setQuantity(x.getQuantity());
//            items.setOrder(item);
//            items.setPrice(x.getPrice());
//            items.setProduct(prd);
//            Product product = dao.findAllById(x.getId());
//            if(product.getQuantity() < x.getQuantity()){
//                model.addAttribute("message","This product just have "+product.getQuantity());
//            }else{
//                orderDetails.save(items);
//                product.setQuantity(product.getQuantity()-items.getQuantity());
//                dao.save(product);
//                model.addAttribute("message", "Order Success");
//
//            }
//        }
//        return "layoutchange/checkform";
//    }
}
