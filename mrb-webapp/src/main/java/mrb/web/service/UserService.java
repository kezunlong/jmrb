package mrb.web.service;

import java.util.List;

import ir.utilities.db.PagingOption;
import mrb.model.auth.User;
import mrb.model.auth.UserFilter;
import mrb.model.basedata.Dict;
import mrb.web.service.BaseService;
import mrb.web.service.MRBService;

public class UserService extends BaseService {
	public UserService(MRBService service) {
		super(service);
	}
	
	public List<User> findAll() {
		List<User> list = repository.getUserRepository().findAll();
		
		for(User item : list) {
			FillUserProperties(item);
		}
		
		return list;
	}
	
	public List<User> filter(UserFilter filter, PagingOption option) {
		List<User> list = repository.getUserRepository().filter(filter, option);
		
		for(User item : list) {
			FillUserProperties(item);
		}
		
		return list;
	}
	
	public User findById(int id) {
		User item = repository.getUserRepository().findById(id);
		
		FillUserProperties(item);
		
		return item;
	}
	
	public void insert(User item) {
		repository.getUserRepository().insert(item);
	}
	
	public void update(User item) {
		repository.getUserRepository().update(item);
	}
	
	public void delete(int id) {
		repository.getUserRepository().delete(id);
	}
	
	private void FillUserProperties(User item) {
		Dict sector = service.getDictService().findById(item.getSectorId());
		Dict office = service.getDictService().findById(item.getOfficeId());
		item.setSector(sector);
		item.setOffice(office);
	}
}