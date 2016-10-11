package mrb.model.meetingroom;

import org.apache.commons.lang3.StringUtils;

public class MeetingRoomFilter {
	private String name;
	private String officeId;
	private String floor;
	private String status;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOfficeId() {
		return this.officeId;
	}
	
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	
	public String getFloor() {
		return this.floor;
	}
	
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getFilterString() {
		String result = "";
		
		if(StringUtils.isNotEmpty(name)) {
			result += " AND (NAME LIKE '%" + name + "%' OR NAMECN LIKE '%" + name + "%')";
		}
		
		if(StringUtils.isNotEmpty(officeId)) {
			result += " AND OFFICEID = '" + officeId + "'";
		}
		
		if(StringUtils.isNotEmpty(floor)) {
			result += " AND FLOOR = " + floor;
		}
		
		if(StringUtils.isNotEmpty(status)) {
			result += " AND STATUS = '" + status + "'";
		}
		
		return result;
	}
}
