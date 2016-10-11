package mrb.model.auth;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class UserFilter {
	private String userName;
	private String sectorId;
	private String officeId;
	private Optional<Boolean> status;
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSectorId() {
		return this.sectorId;
	}
	
	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}
	
	public String getOfficeId() {
		return this.officeId;
	}
	
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	
	public Optional<Boolean> getStatus() {
		return this.status;
	}
	
	public void setStatus(Optional<Boolean> status) {
		this.status = status;
	}
	
	public String getFilterString() {
		String result = "";
		
		if(StringUtils.isNotEmpty(userName)) {
			result += " AND (USERNAME LIKE '%" + userName + "%' OR ENGLISHNAME LIKE '%" + userName + "%' OR CHINESENAME LIKE '%" + userName + "%')";
		}
		
		if(StringUtils.isNotEmpty(sectorId)) {
			result += " AND SECTORID = '" + sectorId + "'";
		}
		
		if(StringUtils.isNotEmpty(officeId)) {
			result += " AND OFFICEID = '" + officeId + "'";
		}
		
		if(status != null && status.isPresent()) {
			result += " AND STATUS = '" + (status.get() == true ? "1" : "0") + "'";
		}
		
		return result;
	}
}