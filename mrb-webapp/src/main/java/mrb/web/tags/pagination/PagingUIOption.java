package mrb.web.tags.pagination;

public class PagingUIOption {
    private String firstPageText;
    private String prevPageText;
    private String nextPageText;
    private String lastPageText;
    private int totalPageLink;
    private String cssClass;
    private String pageCssClass;
    private String currentPageCssClass;
    private String disablePageCssClass;
    private String customInfoHTML;
    private String customInfoPosition;
    private String customInfoCssClass;
	
    public String getFirstPageText() {
    	return this.firstPageText;
    }
    public void setFirstPageText(String firstPageText) {
    	this.firstPageText = firstPageText;
    }
    public String getPrevPageText() {
    	return this.prevPageText;
    }
    public void setPrevPageText(String prevPageText) {
    	this.prevPageText = prevPageText;
    }
    public String getNextPageText() {
    	return this.nextPageText;
    }
    public void setNextPageText(String nextPageText) {
    	this.nextPageText = nextPageText;
    }
    public String getLastPageText() {
    	return this.lastPageText;
    }
    public void setLastPageText(String lastPageText) {
    	this.lastPageText = lastPageText;
    }   
    public int getTotalPageLink() {
    	return this.totalPageLink;
    }
    public void setTotalPageLink(int totalPageLink) {
    	this.totalPageLink = totalPageLink;
    }
    public String getCssClass() {
    	return this.cssClass;
    }
    public void setCssClass(String cssClass) {
    	this.cssClass = cssClass;
    }
    public String getPageCssClass() {
    	return this.pageCssClass;
    }
    public void setPageCssClass(String pageCssClass) {
    	this.pageCssClass = pageCssClass;
    }
    public String getCurrentPageCssClass() {
    	return this.currentPageCssClass;
    }
    public void setCurrentPageCssClass(String currentPageCssClass) {
    	this.currentPageCssClass = currentPageCssClass;
    }
    public String getDisablePageCssClass() {
    	return this.disablePageCssClass;
    }
    public void setDisablePageCssClass(String disablePageCssClass) {
    	this.disablePageCssClass = disablePageCssClass;
    }
    public String getCustomInfoHTML() {
    	return this.customInfoHTML;
    }
    public void setCustomInfoHTML(String customInfoHTML) {
    	this.customInfoHTML = customInfoHTML;
    }
    public String getCustomInfoPosition() {
    	return this.customInfoPosition;
    }
    public void setCustomInfoPosition(String customInfoPosition) {
    	this.customInfoPosition = customInfoPosition;
    }
    public String getCustomInfoCssClass() {
    	return this.customInfoCssClass;
    }
    public void setCustomInfoCssClass(String customInfoCssClass) {
    	this.customInfoCssClass = customInfoCssClass;
    }
}