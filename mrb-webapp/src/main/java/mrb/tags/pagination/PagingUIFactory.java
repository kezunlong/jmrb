package mrb.tags.pagination;

public class PagingUIFactory {
    public static PagingUIOption GetDefaultPagingUI()
    {
		PagingUIOption option = new PagingUIOption();
		option.setFirstPageText("First");
		option.setPrevPageText("Previous");
		option.setNextPageText("Next");
		option.setLastPageText("Last");
		option.setTotalPageLink(10);
		option.setCustomInfoCssClass("custominfo");
		return option;
    }

    public static PagingUIOption GetBootstrapPagingUI()
    {
    	PagingUIOption option = new PagingUIOption();
        
    	option.setFirstPageText("<span class='icon fa fa-step-backward'></span>");
    	option.setPrevPageText("<span class='icon fa fa-chevron-left'></span>");
    	option.setNextPageText("<span class='icon fa fa-chevron-right'></span>");
    	option.setLastPageText("<span class='icon fa fa-step-forward'></span>");
    	option.setCssClass("pagination pagination-sm");
    	option.setPageCssClass("");
    	option.setCurrentPageCssClass("active");
    	option.setDisablePageCssClass("disabled");
    	option.setTotalPageLink(10);
    	option.setCustomInfoHTML("Records: {TotalItems}, Pages: {TotalPages}");
    	option.setCustomInfoCssClass("custominfo");
    	
    	return option;
    }
}