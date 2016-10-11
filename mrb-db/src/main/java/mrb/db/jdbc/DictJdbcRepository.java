package mrb.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import ir.utilities.db.PagingOption;
import mrb.db.DictRepository;
import mrb.model.basedata.Dict;
import mrb.model.basedata.DictFilter;

public class DictJdbcRepository extends JdbcBaseRepository implements DictRepository {
	private static final String SELECT_DICT = "SELECT * FROM MRB_DICT";
	private static final String INSERT_DICT = "INSERT INTO MRB_DICT(ID, CATEGORY, VALUE, VALUECN, ORDERNUMBER) VALUES(?, ?, ?, ?, ?)";
	private static final String UPDATE_DICT = "UDPATE MRB_DICT SET CATEGORY = ?, VALUE = ?, VALUECN = ?, ORDERNUMBER = ? WHERE ID = ?";
	private static final String DELETE_DICT = "DELETE MRB_DICT WHERE ID = ?";
	
	public DictJdbcRepository(MRBRepository repository) {
		super(repository);
	}

	public List<Dict> findAll() {
		return jdbcTemplate.query(SELECT_DICT, new DictRowMapper());
	}

	public List<Dict> filter(DictFilter filter, PagingOption option) {
		String sql = SELECT_DICT + " WHERE 1 = 1" + filter.getFilterString(); 
		if(option.getFetchRecordCount()) {
			option.setRecordCount(getRecordCount(sql));
		}
		
		return getPagingData(sql, option, new DictRowMapper());
	}
	
	public List<Dict> findByCategory(String category) {
		String sql = SELECT_DICT + " WHERE CATEGORY = ? ORDER BY ORDERNUMBER";
		return jdbcTemplate.query(sql, new DictRowMapper(), category);
	}

	public Dict findById(String id) {
		String sql = SELECT_DICT + " WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new DictRowMapper(), id);
	}

	public void insert(Dict item) {
		jdbcTemplate.update(INSERT_DICT,
				item.getId(),
				item.getCategory(),
				item.getValue(),
				item.getValueCN(),
				item.getOrderNumber());
	}

	public void update(Dict item) {
		jdbcTemplate.update(UPDATE_DICT,
				item.getCategory(),
				item.getValue(),
				item.getValueCN(),
				item.getOrderNumber(),
				item.getId());
	}

	public void delete(String id) {
		jdbcTemplate.update(DELETE_DICT, id);
	}
	
	private static final class DictRowMapper implements RowMapper<Dict> {
		public Dict mapRow(ResultSet rs, int rowNum) throws SQLException {
			Dict item = new Dict();
			item.setId(rs.getString("id"));
			item.setCategory(rs.getString("category"));
			item.setValue(rs.getString("value"));
			item.setValueCN(rs.getString("valuecn"));
			item.setOrderNumber(rs.getInt("ORDERNUMBER"));
			return item;
		}
	}
}
