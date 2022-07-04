package AssignmentJava5.controllers.admin;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import AssignmentJava5.entities.*;
import AssignmentJava5.model.*;
import AssignmentJava5.respositories.*;
import AssignmentJava5.service.*;
import AssignmentJava5.utils.UploadFileUtils;

@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	
	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	private UploadFileUtils uploadUtil;
	
	@Autowired
    SessionService session;
	
	@RequestMapping("admin/product/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("product") ProductModel product) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
        Page<Product> data = dao.findAll(pageable);
		model.addAttribute("data", data);
		List<Product>items=dao.findAll();
		model.addAttribute("items", items);
		List<Category> listCate = this.categoryDao.findAll();
		
		for (Product product1 : items) {
			if (product1.getQuantity()<=0) {
				product1.setStatus(1);
				dao.save(product1);
			} 
		}
		
		model.addAttribute("listCate", listCate);
		model.addAttribute("views", "/create");
		return "admin/products/index";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("item") Product pro, Model model)
	{
		List<Category> listCate = this.categoryDao.findAll();
		model.addAttribute("listCate", listCate);
		return "admin/products/create";
	}
	
	@PostMapping("admin/product/store")
	public String create(ProductModel product, @RequestParam("image")MultipartFile uploadFile) {
		String uuid = UUID.randomUUID().toString();
		this.uploadUtil.handleUpLoadFile(uploadFile,uuid);
		Product pro = new Product();
		pro.setName(product.getName());
		pro.setImage(uuid+"_"+uploadFile.getOriginalFilename());
		pro.setImage(uploadFile.getOriginalFilename());
		pro.setCreateDate(new Date());
		pro.setPrice(product.getPrice());
		pro.setQuantity(product.getQuantity());
		pro.setStatus(product.getStatus());
		pro.setCategory(product.getCategory());
		dao.save(pro);
		return "redirect:/admin/product/index";
	}
	
	@GetMapping("/edit1/{id}")
	public String edit1(Model model,@PathVariable("id") int id) {
		Product item = dao.findById(id);
		model.addAttribute("item", item);
		List<Category> listCate = this.categoryDao.findAll();
		model.addAttribute("listCate", listCate);
		return "admin/products/edit";
	}
	
	@GetMapping("admin/product/edit/{id}")
	public String edit(Model model,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="10") int size,
			@ModelAttribute("product") ProductModel product
			,@PathVariable("id") int id) {
		model.addAttribute("views","/edit1/"+id);
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> pro = this.dao.findAll(pageable);
		model.addAttribute("data", pro);
		List<Product>items=dao.findAll();
		model.addAttribute("items", items);
		List<Category> listCate = this.categoryDao.findAll();
		model.addAttribute("listCate", listCate);
		return "admin/products/index";
	}
	
	@PostMapping("admin/products/update/{id}")
	public String update(@PathVariable("id") Integer id,@RequestParam("image") MultipartFile uploadFile,ProductModel product) {
		String uuid = UUID.randomUUID().toString();
		this.uploadUtil.handleUpLoadFile(uploadFile,uuid);
		Product pro1 = this.dao.getById(id);
		Product pro = new Product();
		pro.setId(product.getId());
		pro.setName(product.getName());
		if(uploadFile.getOriginalFilename().equals("")) {
			pro.setImage(pro1.getImage());
		}
		else {
			pro.setImage(uuid+"_"+uploadFile.getOriginalFilename());
		}
		pro.setImage(uploadFile.getOriginalFilename());
		pro.setCreateDate(pro1.getCreateDate());
		pro.setPrice(product.getPrice());
		pro.setQuantity(product.getQuantity());
		pro.setStatus(product.getStatus());
		pro.setCategory(pro1.getCategory());
		dao.save(pro);
		return "redirect:/admin/product/index";
	}


	@RequestMapping("admin/product/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		dao.deleteById(id);
		return "redirect:/admin/product/index";
	}

//	@RequestMapping("/product/search")
//    public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw, @RequestParam("p") Optional<Integer> p) {
//        Product item = new Product();
//        model.addAttribute("item",item);
//        List<Category> categories = categoryDao.findAll();
//        model.addAttribute("categories",categories);
//        String kwords = kw.orElse(session.get("keywords"));
//        session.set("keywords", kwords);
//        Pageable pageable = PageRequest.of(p.orElse(0), 5);
//        Page<Product> page = dao.findByNameLike("%"+kwords+"%", pageable);
//        model.addAttribute("page", page);
//        return "layoutchange/products";
//    }
	
	@RequestMapping("/product/search")
	public String search(Model model,
			@RequestParam("min") Optional<Integer> min,
			@RequestParam("max") Optional<Integer> max) {
		Integer minPrice=min.orElse(Integer.MIN_VALUE);
		Integer maxPrice=max.orElse(Integer.MAX_VALUE);
		List<Product> items=dao.findByPrice(minPrice, maxPrice);
		if(items.isEmpty()) {
			System.out.println("không tìm thấy dữ liệu");
		}else {
			model.addAttribute("items", items);
		}

		return"product/search";
	}
	
//	@RequestMapping("product/sort")
//	public String sort(Model model,@RequestParam("feild")Optional<String> field) {
//		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
//		model.addAttribute("feild", field.orElse("price").toUpperCase());
//		
//		List<Product>items=dao.findAll(sort);
//		
//		
//		model.addAttribute("items", items);
//		return "product/sort";
//	}
	
//	@RequestMapping("product/page")
//	public String pagenate(Model model,@RequestParam("p") Optional<Integer> p) {
//		Pageable pagenate=PageRequest.of(p.orElse(0), 3);
//		Page<Product> page=dao.findAll(pagenate);
//		model.addAttribute("page", page);
//		return "product/page";
//	}
	
}

