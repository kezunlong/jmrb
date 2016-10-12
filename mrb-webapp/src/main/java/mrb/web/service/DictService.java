package mrb.web.service;

import java.util.List;

import ir.utilities.db.PagingOption;
import mrb.model.basedata.Dict;
import mrb.model.basedata.DictFilter;
import mrb.web.service.BaseService;
import mrb.web.service.MRBService;

public class DictService extends BaseService {
	public DictService(MRBService service) {
		super(service);
	}
	
	public List<Dict> findAll() {
		return repository.getDictRepository().findAll();
	}
	
	public List<Dict> filter(DictFilter filter, PagingOption option) {
		return repository.getDictRepository().filter(filter, option);
	}
	
	public List<Dict> findByCategory(String category) {
		return repository.getDictRepository().findByCategory(category);
	}
	
	public Dict findById(String id) {
		return repository.getDictRepository().findById(id);
	}
	
	public void insert(Dict item) {
		repository.getDictRepository().insert(item);
	}
	
	public void update(Dict item) {
		repository.getDictRepository().update(item);
	}
	
	public void delete(String id) {
		repository.getDictRepository().delete(id);
	}
}