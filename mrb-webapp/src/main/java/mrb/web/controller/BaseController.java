package mrb.web.controller;

import ir.utilities.db.PagingOption;
import mrb.tags.pagination.PagingUIFactory;
import mrb.tags.pagination.PagingUIOption;

public class BaseController {
	
	
	protected PagingOption GetPagingOption(int page) {
		PagingOption option = new PagingOption();
		option.setPageIndex(page);
		option.setPageSize(5);
		option.setFetchRecordCount(true);
		
		return option;
	}
	
	protected PagingUIOption GetPagingUIOption() {
		return PagingUIFactory.GetBootstrapPagingUI();
	}
}
