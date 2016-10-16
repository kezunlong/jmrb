package mrb.web.viewmodel;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLoginViewModel {
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(Boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	
	private Boolean rememberMe;
	
}
