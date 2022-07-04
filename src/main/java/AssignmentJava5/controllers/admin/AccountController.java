package AssignmentJava5.controllers.admin;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import AssignmentJava5.entities.Account;
import AssignmentJava5.model.AccountModel;
import AssignmentJava5.respositories.AccountRepository;
import AssignmentJava5.service.SessionService;
import AssignmentJava5.utils.HashUtil;
import AssignmentJava5.utils.UploadFileUtils;

@Controller
public class AccountController {
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
    SessionService session;
	
	@Autowired
	private UploadFileUtils uploadUtil;
	
	@RequestMapping("admin/accounts/index")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size,
			@ModelAttribute("account") AccountModel account) {
		model.addAttribute("page", page);
		Pageable pageable = PageRequest.of(page, size);
        Page<Account> data = accountRepo.findAll(pageable);
		model.addAttribute("data", data);
		model.addAttribute("views", "/accounts/create");
		return "admin/accounts/index";
	}
	
	@GetMapping("/accounts/create")
	public String create(@Validated @ModelAttribute("account") Account acc,BindingResult errors)
	{
		return "admin/accounts/create";
	}
	
	@PostMapping("admin/accounts/store")
	public String store(AccountModel model,@RequestParam("photo")MultipartFile uploadFile)
	{
//		if(errors.hasErrors()){
//            System.out.println("Không hợp lệ");
//        }else {
        	String uuid = UUID.randomUUID().toString();
    		this.uploadUtil.handleUpLoadFile(uploadFile,uuid);
    		// Chuyển đổi model -> entity
    		Account a = new Account();
    		a.setFullname(model.getFullname());
    		a.setEmail(model.getEmail());
    		a.setSdt(model.getSdt());
    		a.setUsername(model.getUsername());
    		String hashedPassword = HashUtil.hash(a.getPassword());
			a.setPassword(hashedPassword);
//    		a.setPassword(model.getPassword());
    		a.setPhoto(uuid+"_"+uploadFile.getOriginalFilename());
    		a.setPhoto(uploadFile.getOriginalFilename());
    		a.setAdmin(model.getAdmin());
    		a.setActivated(model.getActivated());
    		this.accountRepo.save(a);
//    		System.out.println("Thêm thành công");
//        }
		
		return "redirect:/admin/accounts/index";
	}
	
	@GetMapping("/editacc/{id}")
	public String showedit(Model model,@PathVariable("id") int id) {
		Account account= accountRepo.findById(id).get();
		model.addAttribute("account", account);
		return "admin/accounts/edit";
	}
	
	@GetMapping("admin/accounts/edit/{id}")
	public String edit(Model model,
			@RequestParam(name="page", defaultValue="0") int page,
			@RequestParam(name="size", defaultValue="10") int size,
			@ModelAttribute("account") AccountModel account
			,@PathVariable("id") int id) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Account> a = this.accountRepo.findAll(pageable);
		model.addAttribute("data", a);
		model.addAttribute("views","/editacc/"+id);
		return "admin/accounts/index";
	}
	
	@PostMapping("admin/accounts/update/{id}")
	public String update(@PathVariable("id") Integer id,@RequestParam("photo") MultipartFile uploadFile, AccountModel acountmodel) {
		String uuid = UUID.randomUUID().toString();
		this.uploadUtil.handleUpLoadFile(uploadFile,uuid);
		Account account2 = this.accountRepo.getById(id);
		
		Account acc = new Account();
		acc.setId(acountmodel.getId());
		acc.setFullname(acountmodel.getFullname());
		acc.setEmail(acountmodel.getEmail());
		acc.setSdt(acountmodel.getSdt());
		acc.setUsername(acountmodel.getUsername());
		acc.setPassword(account2.getPassword());
		if(uploadFile.getOriginalFilename().equals("")) {
			acc.setPhoto(account2.getPhoto());
		}
		else {
			acc.setPhoto(uuid+"_"+uploadFile.getOriginalFilename());
		}
//		acc.setPhoto(uploadFile.getOriginalFilename());
		acc.setAdmin(acountmodel.getAdmin());
		acc.setActivated(acountmodel.getActivated());
		accountRepo.save(acc);
		return "redirect:/admin/accounts/index";
	}
	
	@GetMapping("admin/accounts/delete/{id}")
	public String delete(@PathVariable("id") int id)
	{
		this.accountRepo.deleteById(id);
		return "redirect:/admin/accounts/index";
	}
	
	
	
//	@GetMapping("/account/login")
//    public String login() {
//        return "auth/login";
//    }
//
//    @RequestMapping("/account/login")
//    public String login(Model model,
//                        @RequestParam("username") String username,
//                        @RequestParam("password") String password ,
//                        HttpServletRequest req
//                        ) {
//
//           Account user = accountRepo.findAccountByUsername(username);
//            if (!user.getPassword().equals(password)) {
//                model.addAttribute("message", "Invalid password");
//            } else {
//                String uri = session.get("security-uri");
//                if (uri != null) {
//                    return "redirect:" + uri;
//                } else {
//                    if(user.getActivated()==0){
//                    if(user.getAdmin()==1){
//                        model.addAttribute("message", "Login succeed");
//                        session.set("user", user);
//                        return "redirect:/home/views";
//                    }else {
//                        model.addAttribute("message", "Login succeed");
//                        session.set("user", user);
//                        return "/home/views";
//                    }
//                }else{
//                        model.addAttribute("message", "Login failed , Your account has been banned. Contact .. to reset your account");
//                    }
//                }
//            }
//
//        return "login";
//    }
    @RequestMapping("/account/logout")
    public String logout(){
      session.remove("user");
        return "redirect:/Home/views";
    }
}
