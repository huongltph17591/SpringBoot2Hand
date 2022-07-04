 package AssignmentJava5.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AssignmentJava5.entities.Account;
import AssignmentJava5.respositories.AccountRepository;
import AssignmentJava5.service.SessionService;
import AssignmentJava5.utils.HashUtil;

@Controller
public class LoginController {
	@Autowired
	SessionService session;

	@Autowired
	private AccountRepository accRepo;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("/login")
	public String getLoginForm() {
		return "/auth/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		Account entity = this.accRepo.findByEmail(email);
		HttpSession session = request.getSession();
		if (entity == null || entity.equals("") || entity.getActivated() != 0) {
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			return "redirect:/login";
		}

		boolean checkPwd = HashUtil.verify(password, entity.getPassword());

		if (checkPwd) {
			System.out.println("Sai paw");
			session.setAttribute("error", "Sai email hoặc mật khẩu");
			return "redirect:/login";
		}
		if (entity.getAdmin() == 0) {
			session.setAttribute("account", entity);
			return "redirect:/home/views";
		} else {
			session.setAttribute("account", entity);
			return "redirect:/homeAdmin/views";
		}

	}

	@RequestMapping("/logout")
	public String logout() {
		session.remove("account");
		session.remove("shoppingCart");
		System.out.println("đxuat tcong");
		System.out.println(session);
		return "redirect:/login";
	}
}
