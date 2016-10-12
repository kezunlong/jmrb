package mrb.web.service;

import mrb.db.jdbc.MRBRepository;
import mrb.web.service.MRBService;

public class BaseService {
	protected MRBService service;
	protected MRBRepository	repository;
	
	public BaseService(MRBService service) {
		this.service = service;
		this.repository = service.getRepository();
	}
	
}