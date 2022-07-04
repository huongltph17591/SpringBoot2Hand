package AssignmentJava5.controllers.admin;

import AssignmentJava5.respositories.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {
    @Autowired
    OrderDao dao;
    @RequestMapping("/Save/Order")
    public String Save(){

        return "";
    }
}
