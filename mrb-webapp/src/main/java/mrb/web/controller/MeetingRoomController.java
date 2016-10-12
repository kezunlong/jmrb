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
import mrb.model.basedata.*;
import mrb.model.meetingroom.*;
import mrb.web.service.MRBService;

@Controller()
@RequestMapping("/MeetingRoom")
public class MeetingRoomController extends BaseController {
	@Autowired
	private MRBService mrbService;

	private static final Log logger = LogFactory.getLog(MeetingRoomController.class);

	@RequestMapping({"/", "/Index"})
	public String Index(@ModelAttribute MeetingRoomFilter filter, Model model) {
		logger.info("list conference rooms");
		
		PagingOption pagingOption = GetPagingOption(1);
		List<MeetingRoom> meetingRooms = GetMeetingRooms(filter, pagingOption);
		model.addAttribute("meetingRooms", meetingRooms);
		model.addAttribute("filter", filter);
		FillAdditionalAttributes(model);
		FillPagingAttributes(pagingOption, model);
		
		return "MeetingRoom/Index";
	}
	
	// jquery method for pagination
	@RequestMapping("/Partial_MeetingRoomList")
	public String MeetingRoomList(@ModelAttribute MeetingRoomFilter filter, Integer page, Model model) {
		PagingOption pagingOption = GetPagingOption(page);
		List<MeetingRoom> list = GetMeetingRooms(filter, pagingOption);
		model.addAttribute("meetingRooms", list);
		FillPagingAttributes(pagingOption, model);		
		return "/MeetingRoom/Partial_MeetingRoomList";
	}
	
	@RequestMapping("/Create")
	public String Create(Model model) {
		MeetingRoom meetingRoom = new MeetingRoom();
		meetingRoom.setStatus(MeetingRoomStatus.Normal);
		model.addAttribute("meetingRoom", meetingRoom);
		FillAdditionalAttributes(model);
		
		return "/MeetingRoom/Edit";
	}
	
	@RequestMapping(value="/Edit/{id}", method=RequestMethod.GET)
	public String Edit(@PathVariable Integer id, Model model) {
		MeetingRoom meetingRoom = mrbService.getMeetingRoomService().findById(id);
		model.addAttribute("meetingRoom", meetingRoom);
		FillAdditionalAttributes(model);
		
		return "/MeetingRoom/Edit";
	}
	
	@RequestMapping(value="/Edit", method=RequestMethod.POST)
	public String Edit(@Valid @ModelAttribute MeetingRoom meetingRoom, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("meetingRoom", meetingRoom);
			FillAdditionalAttributes(model);
			return "/MeetingRoom/Edit";
		}

		if(meetingRoom.getId() == 0) {
			mrbService.getMeetingRoomService().insert(meetingRoom);
		}
		else {
			mrbService.getMeetingRoomService().update(meetingRoom);
		}
		return "redirect:/MeetingRoom/Index";
	}
	
	@RequestMapping(value="/Delete/{id}")
	public String Delete(@PathVariable Integer id, Model model) {
		MeetingRoom meetingRoom = mrbService.getMeetingRoomService().findById(id);
		if(meetingRoom != null) {
			mrbService.getMeetingRoomService().delete(id);
		}
		return "redirect:/MeetingRoom/Index";
	}
	
	private List<MeetingRoom> GetMeetingRooms(MeetingRoomFilter filter, PagingOption option) {
		if(filter == null) {
			filter = new MeetingRoomFilter();
		}
		
		List<MeetingRoom> list = mrbService.getMeetingRoomService().filter(filter, option);
		return list;
	}
	
	private void FillAdditionalAttributes(Model model) {
		List<Dict> offices = mrbService.getDictService().findByCategory("OFFICE");
		MeetingRoomStatus[] meetingRoomStatus = MeetingRoomStatus.values();
		model.addAttribute("offices", offices);
		model.addAttribute("meetingRoomStatus", meetingRoomStatus);
	}
	
	private void FillPagingAttributes(PagingOption pagingOption, Model model) {
		model.addAttribute("pagingOption", pagingOption);
		model.addAttribute("pagingUIOption", GetPagingUIOption());
		Function<Integer, String> function = p -> MessageFormat.format("javascript: Search({0})", p); 
		model.addAttribute("pageUrl", function);
	}
}