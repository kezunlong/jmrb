package mrb.service;

import java.util.List;

import ir.utilities.db.PagingOption;
import mrb.model.basedata.Dict;
import mrb.model.meetingroom.MeetingRoom;
import mrb.model.meetingroom.MeetingRoomFilter;


public class MeetingRoomService extends BaseService {
	public MeetingRoomService(MRBService service) {
		super(service);
	}
	
	public List<MeetingRoom> findAll() {
		List<MeetingRoom> list = repository.getMeetingRoomRepository().findAll();
		
		for(MeetingRoom item : list) {
			FillMeetingRoomProperties(item);
		}
		
		return list;
	}
	
	public List<MeetingRoom> filter(MeetingRoomFilter filter, PagingOption option) {
		List<MeetingRoom> list = repository.getMeetingRoomRepository().filter(filter, option);
		
		for(MeetingRoom item : list) {
			FillMeetingRoomProperties(item);
		}
		
		return list;
	}
	
	public MeetingRoom findById(int id) {
		MeetingRoom item = repository.getMeetingRoomRepository().findById(id);
		
		FillMeetingRoomProperties(item);
		
		return item;
	}
	
	public void insert(MeetingRoom item) {
		repository.getMeetingRoomRepository().insert(item);
	}
	
	public void update(MeetingRoom item) {
		repository.getMeetingRoomRepository().update(item);
	}
	
	public void delete(int id) {
		repository.getMeetingRoomRepository().delete(id);
	}
	
	private void FillMeetingRoomProperties(MeetingRoom item) {
		Dict office = service.getDictService().findById(item.getOfficeId());
		item.setOffice(office);
	}
}