package mrb.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.addAttribute("userLogin", item);
		return "/Account/Login";
	}
	
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public String Edit(@Valid @ModelAttribute UserLoginViewModel userLogin, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("userLogin", userLogin);
			//FillAdditionalAttributes(model);
			return "/Account/Login";
		}

		User user = mrbService.getUserService().findByUserName(userLogin.getUserName());
		if(user == null) {
			model.addAttribute("userLogin", userLogin);
			return "/Account/Login";
		}
		else {
			
			return "redirect:/User/Index";
		}
		
		
	}
}
