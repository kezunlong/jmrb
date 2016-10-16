package mrb.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ir.utilities.security.LDAPAuthentication;
import mrb.model.auth.User;
import mrb.service.MRBService;
import mrb.web.viewmodel.UserLoginViewModel;

@Controller
public class AccountController {
	@Autowired
	private MRBService mrbService;

	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public String Login(Model model) {
		UserLoginViewModel item = new UserLoginViewModel();
		item.setUserName("irfgoy");
		model.addAttribute("userLogin", item);
		return "/Account/Login";
	}
	
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public String Edit(@Valid @ModelAttribute UserLoginViewModel userLogin, BindingResult bindingResult, Model model) {
		if (!bindingResult.hasErrors()) {
			User user = mrbService.getUserService().findByUserName(userLogin.getUserName());
			if(user == null) {
				bindingResult.addError(new ObjectError("userName", "User does not exist"));
			}
			else {
				LDAPAuthentication ldapAuthentication = new LDAPAuthentication();
				if(ldapAuthentication.doIRAuthencation(userLogin.getUserName(), userLogin.getPassword())) {
					// Write Session
					
					return "redirect:/User/Index";
				}
				else {
					bindingResult.addError(new ObjectError("userName", "Login failed"));
				}
			}
		}
		
		model.addAttribute("userLogin", userLogin);
		System.out.println("UserName Field Error: " + bindingResult.getFieldError("userName"));
		System.out.println("Password Field Error: " + bindingResult.getFieldError("password"));
		return "/Account/Login";		
	}
}
