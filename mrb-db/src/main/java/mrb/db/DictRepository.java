package mrb.db;

import java.util.List;

import ir.utilities.db.PagingOption;
import mrb.model.basedata.Dict;
import mrb.model.basedata.DictFilter;

public interface DictRepository {
	List<Dict> findAll();
	
	List<Dict> filter(DictFilter filter, PagingOption option);
	
	List<Dict> findByCategory(String category);
	
	Dict findById(String id);
	
	void insert(Dict item);
	
	void update(Dict item);
	
	void delete(String id);
}
