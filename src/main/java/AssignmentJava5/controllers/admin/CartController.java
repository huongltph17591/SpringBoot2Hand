package AssignmentJava5.controllers.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AssignmentJava5.entities.Order;
import AssignmentJava5.entities.Order_detail;
import AssignmentJava5.entities.Product;
import AssignmentJava5.model.CartItem;
import AssignmentJava5.model.ProductModel;
import AssignmentJava5.respositories.OrderDao;
import AssignmentJava5.respositories.OrderDetailDAO;
import AssignmentJava5.respositories.ProductDAO;
import AssignmentJava5.service.*;
@Controller
public class CartController {
//	@Autowired
//	ShoppingCartService cart;
//	
//	@Autowired
//	SessionService sessionService;
//	
//	@GetMapping("/shop/cart")
//	public String index(Model model) {
//		model.addAttribute("cart", cart);
//		return "user/cart";
//	}
//	
//	@RequestMapping("/cart/update/{id}")
//	public String update(@PathVariable("id") Integer id, @RequestParam("quality") Integer qty) {
//		cart.update(id, qty);
//		return "redirect:/shop/cart";
//	}
//	
//	@RequestMapping("/cart/remove/{id}")
//	public String remove(@PathVariable("id") Integer id) {
//		cart.remove(id);	
//		sessionService.set("countProduct", cart.getCount());
//		return "redirect:/shop/cart";
//	}
//	
//	@ModelAttribute("total")
//	public int tolal() {
//		List<CartItem> list = new ArrayList<>(cart.getCartItems());
//		int total = 0;
//		for(CartItem i: list) {
//			total = (int) (total + i.getPrice() * i.getQuantity());
//		}
//		return total;
//	}
	
	
	
	
	
	
	
	
//	@Autowired
//    ProductDAO dao;
//    @Autowired
//    OrderDao oder;
//    @Autowired
//    OrderDetailDAO orderDetails;
//    @Autowired
//    ShoppingCartService shoppingCartService;
//
//    @RequestMapping(value = "/shoppingcart/add/{id}" )
//    public String add(Model model ,@PathVariable("id") Long id){
////       Product product = dao.findById(id).get();
//        Product product = dao.findById(Math.toIntExact(id));
//   //     List<Product> list = dao.findAll();
//        CartItem  item = new CartItem ();
//            BeanUtils.copyProperties(product,item);
//            item.setQuantity(1);
//        item.setId(product.getId());
//        shoppingCartService.add(item);
//        return "redirect:/shoppingcart/index";
//    }
//    @RequestMapping("/shoppingcart/index")
//    public String index(Model model){
//        Collection<CartItem>  cartItems = shoppingCartService.getCartItems();
//        model.addAttribute("items",cartItems);
//        model.addAttribute("total",shoppingCartService.getAmount());
//        model.addAttribute("NoOfItem",shoppingCartService.getCount());
//        return "layoutchange/ItemCart";
//    }
//
//    @RequestMapping("/shoppingcart/save")
//    public String checkout(Model model ,@ModelAttribute("item") Order item ){
//        Collection<CartItem>  cart = shoppingCartService.getCartItems();
//        model.addAttribute("items",cart);
//        model.addAttribute("total",shoppingCartService.getAmount());
//        model.addAttribute("NoOfItem",shoppingCartService.getCount());
//        return "layoutchange/checkform";
//    }
//    @RequestMapping("/shoppingcart/save/order")
//    public String saveorder(Model model ,@ModelAttribute("item") Order item ){
//        oder.save(item);
//        Collection<CartItem>  carts = shoppingCartService.getCartItems();
//        Product prd = new Product();
//        for(CartItem x : carts){
//            Order_detail items = new Order_detail();
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
//
//    @RequestMapping("/remove/{id}")
//    public String remove(@PathVariable("id") Integer id){
//        shoppingCartService.remove(id);
//        return "redirect:/shoppingcart/index";
//    }
//    @RequestMapping("/shoppingcart/update")
//    public String update(@RequestParam("id") Integer id,@RequestParam("quantity") Integer quantity){
//        shoppingCartService.update(id,quantity);
//        return "redirect:/shoppingcart/index";
//    }
}
