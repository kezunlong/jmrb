package mrb.tags.pagination;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.function.Function;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;

import ir.utilities.db.PagingOption;

public class MvcPaging extends SimpleTagSupport {
    private PagingOption pagingOption;
    private PagingUIOption pagingUIOption;
    private Function<Integer, String> pageUrl;
    
    public PagingOption getPagingOption() {
    	return this.pagingOption;
    }
    public void setPagingOption(PagingOption pagingOption) {
    	this.pagingOption = pagingOption;
    }
    public PagingUIOption getPagingUIOption() {
    	return this.pagingUIOption;
    }
    public void setPagingUIOption(PagingUIOption uiOption) {
    	this.pagingUIOption = uiOption;
    }
    public Function<Integer, String> getPageUrl() {
    	return this.pageUrl;
    }
    public void setPageUrl(Function<Integer, String> pageUrl) {
    	this.pageUrl = pageUrl;
    }
    
    public void doTag() throws JspException, IOException {
    	if(pagingOption == null || pagingOption.getTotalPages() <= 0) {
    		return;
    	}
    	
    	String customInfo = getCustomInfoHTML();
    	
    	StringBuilder links = new StringBuilder();
    	links.append(getPageURL(1, pagingUIOption.getFirstPageText()));
    	links.append(getPageURL(pagingOption.getPageIndex() - 1, pagingUIOption.getPrevPageText()));
        int start = pagingOption.getPageIndex() / pagingUIOption.getTotalPageLink();
        if (pagingOption.getPageIndex() % pagingUIOption.getTotalPageLink() == 0) start -= 1;
        start = start * pagingUIOption.getTotalPageLink() + 1;
        int end = start + pagingUIOption.getTotalPageLink() - 1;
        if (end > pagingOption.getTotalPages()) end = pagingOption.getTotalPages();

        if (start > pagingUIOption.getTotalPageLink())
        {
            links.append(getPageURL(start - 1, "..."));
        }

        for (int i = start; i <= end; i++)
        {
            links.append(getPageURL(i, Integer.toString(i)));
        }

        if (end < pagingOption.getTotalPages())
        {
            links.append(getPageURL(end + 1, "..."));
        }
        links.append(getPageURL(pagingOption.getPageIndex() + 1, pagingUIOption.getNextPageText()));
        links.append(getPageURL(pagingOption.getTotalPages(), pagingUIOption.getLastPageText()));
        
        String ulTag = MessageFormat.format("<ul class=''{0}''>\r\n{1}\r\n</ul>", 
        		pagingUIOption.getCssClass(),
        		links);
        
        String result = "<div>\n<div style='float:left'>\n{0}\n</div>\n<div style='float:right'>\n{1}\n</div>\n</div>";
        Boolean isCustomerInfoLeft = pagingUIOption.getCustomInfoPosition() != "right";
        result = MessageFormat.format(result, 
        		isCustomerInfoLeft ? customInfo : ulTag, 
        		isCustomerInfoLeft ? ulTag : customInfo);
        
        getJspContext().getOut().print(result);
    }
    
    private String getCustomInfoHTML() {
    	String result = "";
    	String customInfo = pagingUIOption.getCustomInfoHTML();
    	if(StringUtils.isNotEmpty(customInfo)) {
            customInfo = customInfo.replace("{TotalItems}", Integer.toString(pagingOption.getRecordCount()));
            customInfo = customInfo.replace("{TotalPages}", Integer.toString(pagingOption.getTotalPages()));
            customInfo = customInfo.replace("{CurrentPage}", Integer.toString(pagingOption.getPageIndex()));
            customInfo = customInfo.replace("{ItemsPerPage}", Integer.toString(pagingOption.getPageSize()));
            int fromItemIndex = (pagingOption.getPageIndex() - 1) * pagingOption.getPageSize() + 1;
            int toItemIndex = fromItemIndex + pagingOption.getPageSize() - 1;
            if(toItemIndex > pagingOption.getRecordCount()) {
                toItemIndex = pagingOption.getRecordCount();
            }
            customInfo = customInfo.replace("{FromItemIndex}", Integer.toString(fromItemIndex));
            customInfo = customInfo.replace("{ToItemIndex}", Integer.toString(toItemIndex));
            result = MessageFormat.format("<span{0}>{1}</span>", 
            		StringUtils.isNotEmpty(pagingUIOption.getCustomInfoCssClass()) ? MessageFormat.format(" class=''{0}''", pagingUIOption.getCustomInfoCssClass()) : "",
            		customInfo);
    	}
    	return result;
    }
    
    private String getPageURL(int page, String pageText) {
    	if(StringUtils.isEmpty(pageText)) {
    		return "";
    	}
    	
    	if(page < 1) page = 1;
    	if(page > pagingOption.getTotalPages()) page = pagingOption.getTotalPages();
    	
    	String liCss = pagingUIOption.getPageCssClass();
    	if(pagingOption.getPageIndex() == page) {
    		liCss += Integer.toString(page) == pageText ? pagingUIOption.getCurrentPageCssClass() : pagingUIOption.getDisablePageCssClass();
    	}
    	
    	String aTag = MessageFormat.format("<a href=''{0}'' {1}>{2}</a>",
    			pageUrl.apply(page),
    			pagingOption.getPageIndex() == page ? "disabled='disabled'" : "",
    			StringUtils.isEmpty(pageText) ? Integer.toString(page) : pageText);
    	
    	String liTag = MessageFormat.format("<li class=''{0}''>{1}</li>\n", liCss, aTag);
    	
    	return liTag;
    }
}