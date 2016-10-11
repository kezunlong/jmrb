package mrb.service;

import mrb.db.jdbc.MRBRepository;

public class BaseService {
	protected MRBService service;
	protected MRBRepository	repository;
	
	public BaseService(MRBService service) {
		this.service = service;
		this.repository = service.getRepository();
	}
	
}