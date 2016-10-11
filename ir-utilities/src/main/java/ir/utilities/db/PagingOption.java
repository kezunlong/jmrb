package ir.utilities.db;

public class PagingOption {
	private int pageIndex;
	private int pageSize;
	private boolean fetchRecordCount;
	private int recordCount;
	
	public int getPageIndex() {
		return this.pageIndex;
	}
	
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getPageSize() {
		return this.pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	// does not include startRowNum, meaning in the query will be: > getStartRowNum()
	public int getStartRowNum() {
		return (this.pageIndex - 1) * pageSize;
	}
	
	// include endRowNum, meaning in the query will be: <= getEndRowNum()
	public int getEndRoNum() {
		return getStartRowNum() + pageSize;
	}
	
	public boolean getFetchRecordCount() {
		return this.fetchRecordCount;
	}
	
	public void setFetchRecordCount(boolean fetchRecordCount) {
		this.fetchRecordCount = fetchRecordCount;
	}
	
	public int getRecordCount() {
		return this.recordCount;
	}
	
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	
    public int getTotalPages()
    {
        return (int)Math.ceil((double)recordCount / pageSize);
       
    }
}