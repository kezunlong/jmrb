package mrb.model.auth;

import org.hibernate.validator.constraints.NotEmpty;

import mrb.model.basedata.Dict;

public class User {
	private int id;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String englishName;
	private String chineseName;
	@NotEmpty
	private String email;
	private String telephone;
	private String mobile;
	@NotEmpty
	private String sectorId;
	@NotEmpty
	private String officeId;
	private String address;
	private boolean status;

	private Dict sector;
	private Dict office;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEnglishName() {
		return this.englishName;
	}
	
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
	public String getChineseName() {
		return this.chineseName;
	}
	
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Dict getSector() {
		return this.sector;
	}
	
	public void setSector(Dict sector) {
		this.sector = sector;
	}
	
	public Dict getOffice() {
		return this.office;
	}
	
	public void setOffice(Dict office) {
		this.office = office;
	}
}