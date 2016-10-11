package mrb.db.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import mrb.db.*;

public class MRBRepository {
	private JdbcTemplate jdbcTemplate;

	public MRBRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}
	
    private DictRepository dictRepository;
    
    public DictRepository getDictRepository() {
        if(dictRepository == null) {
        	dictRepository = new DictJdbcRepository(this);
        }
        return dictRepository;
    }
    
    private MeetingRoomRepository meetingRoomRepository;
    
    public MeetingRoomRepository getMeetingRoomRepository() {
        if(meetingRoomRepository == null) {
        	meetingRoomRepository = new MeetingRoomJdbcRepository(this);
        }
        return meetingRoomRepository;
    }
    
    private UserRepository userRepository;
    
    public UserRepository getUserRepository() {
        if(userRepository == null) {
        	userRepository = new UserJdbcRepository(this);
        }
        return userRepository;
    }
}