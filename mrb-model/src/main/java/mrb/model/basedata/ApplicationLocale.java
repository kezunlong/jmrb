package mrb.model.basedata;

public enum ApplicationLocale {
	English("en"),
	Chinese("zh_CN");
	
	private String locale;
	
	public String getLocale() {
		return this.locale;
	}
	
	ApplicationLocale(String locale) {
		this.locale = locale;
	}
}
