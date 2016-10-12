package mrb.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mrb.db.jdbc.MRBRepository;
import mrb.web.service.DictService;
import mrb.web.service.MeetingRoomService;
import mrb.web.service.UserService;

@Service
public class MRBService {
	private MRBRepository repository;
	
	@Autowired
	public MRBService(JdbcTemplate jdbcTemplate) {
		this.repository = new MRBRepository(jdbcTemplate);
	}
	
	public MRBRepository getRepository() {
		return this.repository;
	}
	
    private DictService dictService;
    
    public DictService getDictService() {
        if(dictService == null) {
        	dictService = new DictService(this);
        }
        return dictService;
    }
    
    private MeetingRoomService meetingRoomService;
    
    public MeetingRoomService getMeetingRoomService() {
        if(meetingRoomService == null) {
        	meetingRoomService = new MeetingRoomService(this);
        }
        return meetingRoomService;
    }
    
    private UserService userService;
    
    public UserService getUserService() {
        if(userService == null) {
        	userService = new UserService(this);
        }
        return userService;
    }
}