package mrb.web.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.function.Function;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ir.utilities.db.PagingOption;
import mrb.model.auth.*;
import mrb.model.basedata.*;
import mrb.web.service.MRBService;

@Controller()
@RequestMapping("/User")
public class UserController extends BaseController {
	@Autowired
	private MRBService mrbService;

	private static final Log logger = LogFactory.getLog(UserController.class);

	@RequestMapping({"/", "/Index"})
	public String Index(@ModelAttribute UserFilter filter, Model model) {
		logger.info("list users");
		
		PagingOption pagingOption = GetPagingOption(1);
		List<User> users = GetUsers(filter, pagingOption);
		model.addAttribute("users", users);
		model.addAttribute("filter", filter);
		FillAdditionalAttributes(model);
		FillPagingAttributes(pagingOption, model);
		
		return "User/Index";
	}
	
	// jquery method for pagination
	@RequestMapping("/Partial_UserList")
	public String MeetingRoomList(@ModelAttribute UserFilter filter, Integer page, Model model) {
		PagingOption pagingOption = GetPagingOption(page);
		List<User> list = GetUsers(filter, pagingOption);
		model.addAttribute("users", list);
		FillPagingAttributes(pagingOption, model);		
		return "/MeetingRoom/Partial_UserList";
	}
	
	@RequestMapping("/Create")
	public String Create(Model model) {
		User user = new User();
		user.setStatus(true);
		model.addAttribute("user", user);
		FillAdditionalAttributes(model);
		
		return "/User/Edit";
	}
	
	@RequestMapping(value="/Edit/{id}", method=RequestMethod.GET)
	public String Edit(@PathVariable Integer id, Model model) {
		User user = mrbService.getUserService().findById(id);
		model.addAttribute("user", user);
		FillAdditionalAttributes(model);
		
		return "/User/Edit";
	}
	
	@RequestMapping(value="/Edit", method=RequestMethod.POST)
	public String Edit(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			FillAdditionalAttributes(model);
			return "/User/Edit";
		}

		if(user.getId() == 0) {
			mrbService.getUserService().insert(user);
		}
		else {
			mrbService.getUserService().update(user);
		}
		return "redirect:/User/Index";
	}
	
	@RequestMapping(value="/Delete/{id}")
	public String Delete(@PathVariable Integer id, Model model) {
		User user = mrbService.getUserService().findById(id);
		if(user != null) {
			mrbService.getUserService().delete(id);
		}
		return "redirect:/User/Index";
	}
	
	private List<User> GetUsers(UserFilter filter, PagingOption option) {
		if(filter == null) {
			filter = new UserFilter();
		}
		
		List<User> list = mrbService.getUserService().filter(filter, option);
		return list;
	}
	
	private void FillAdditionalAttributes(Model model) {
		List<Dict> sectors = mrbService.getDictService().findByCategory("SECTOR");
		List<Dict> offices = mrbService.getDictService().findByCategory("OFFICE");
		model.addAttribute("sectors", sectors);
		model.addAttribute("offices", offices);
		
	}
	
	private void FillPagingAttributes(PagingOption pagingOption, Model model) {
		model.addAttribute("pagingOption", pagingOption);
		model.addAttribute("pagingUIOption", GetPagingUIOption());
		Function<Integer, String> function = p -> MessageFormat.format("javascript: Search({0})", p); 
		model.addAttribute("pageUrl", function);
	}
}
