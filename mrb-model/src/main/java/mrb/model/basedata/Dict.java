package mrb.model.basedata;

public class Dict {
	private String id;
	private String category;
	private String value;
	private String valueCN;
	private int orderNumber;
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
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
	
	public String getValueCN() {
		return this.valueCN;
	}
	
	public void setValueCN(String valueCN) {
		this.valueCN = valueCN;
	}
	
	public int getOrderNumber() {
		return this.orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getValueForLocale(String locale) {
		if(locale == ApplicationLocale.Chinese.getLocale()) {
			return valueCN;
		}
		else {
			return value;
		}
	}
}