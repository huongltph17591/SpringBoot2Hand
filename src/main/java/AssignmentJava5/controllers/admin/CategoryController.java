package AssignmentJava5.controllers.admin;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import AssignmentJava5.entities.Category;
import AssignmentJava5.respositories.*;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO dao;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("admin/category/index")
	public String index(Model model) {
		Category item=new Category();
		model.addAttribute("item", item);
		List<Category>items=dao.findAll();
		model.addAttribute("items", items);
		return "admin/category/index";
		
	}
	
	@RequestMapping("admin/category/edit/{id}")
	public String edit(Model model,@PathVariable("id") int id) {
		Category item=dao.findById(id).get();
		
		model.addAttribute("item", item);
		List<Category>items=dao.findAll();
		model.addAttribute("items", items);
		return "admin/category/index";
	}
	
	@RequestMapping("admin/category/create")
	public String create(Category item) {
		dao.save(item);
		return "redirect:/admin/category/index";
	}
	
	@RequestMapping("admin/category/update/{id}")
	public String update(Category item,@PathVariable("id") int id) {
		System.out.println("id"+id);
		System.out.println("name category"+item.getName());
		item.setId(item.getId());
		item.setName(item.getName());
		dao.save(item);
		return "redirect:/admin/category/edit/"+item.getId();
	}
	
	
	@RequestMapping("admin/category/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		dao.deleteById(id);
		return "redirect:/admin/category/index";
	}

}
