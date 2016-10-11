package mrb.db;

import java.util.List;

import ir.utilities.db.PagingOption;
import mrb.model.auth.User;
import mrb.model.auth.UserFilter;

public interface UserRepository {
	List<User> findAll();
	
	List<User> filter(UserFilter filter, PagingOption option);
	
	User findById(int id);
	
	void insert(User item);
	
	void update(User item);
	
	void delete(int id);
}