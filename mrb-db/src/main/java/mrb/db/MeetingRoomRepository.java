package mrb.db;

import java.util.List;

import ir.utilities.db.PagingOption;
import mrb.model.meetingroom.MeetingRoom;
import mrb.model.meetingroom.MeetingRoomFilter;

public interface MeetingRoomRepository {
	List<MeetingRoom> findAll();
	
	List<MeetingRoom> filter(MeetingRoomFilter filter, PagingOption option);
	
	MeetingRoom findById(int id);
	
	void insert(MeetingRoom item);
	
	void update(MeetingRoom item);
	
	void delete(int id);
}