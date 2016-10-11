package mrb.model.meetingroom;

import org.hibernate.validator.constraints.NotEmpty;

import mrb.model.basedata.Dict;

public class MeetingRoom {
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String nameCN;
	@NotEmpty
	private String officeId;
	private int floor;
	private int capacity;
	private boolean hasProjector;
	private MeetingRoomStatus status;
	
	private Dict office;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNameCN() {
		return this.nameCN;
	}
	
	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}
	
	public String getOfficeId() {
		return this.officeId;
	}
	
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	
	public int getFloor() {
		return this.floor;
	}
	
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean getHasProjector() {
		return this.hasProjector;
	}
	
	public void setHasProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}
	
	public MeetingRoomStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(MeetingRoomStatus status) {
		this.status = status;
	}
	
	public Dict getOffice() {
		return this.office;
	}
	
	public void setOffice(Dict office) {
		this.office = office;
	}
}