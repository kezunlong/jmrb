package mrb.model.basedata;

import org.apache.commons.lang3.StringUtils;

public class DictFilter {
	private String category;
	private String value;
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getFilterString() {
		String result = "";
		
		if(StringUtils.isNotEmpty(category)) {
			result += " AND CATEGORY = '" + category + "'";
		}
		
		if(StringUtils.isNotEmpty(value)) {
			result += " AND (VALUE LIKE '%" + value + "%' OR VALUECN LIKE '%" + value + "%')";
		}
				
		return result;
	}
}