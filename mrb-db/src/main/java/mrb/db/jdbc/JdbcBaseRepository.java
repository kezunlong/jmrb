package mrb.db.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ir.utilities.db.PagingOption;


public class JdbcBaseRepository {
	private static final String SELECT_PAGING = "SELECT * FROM ("
+ "  SELECT ROWNUM ROW_NUM, SUBQ.*"
+ "  FROM"
+ "     (%s) SUBQ"
+ "  WHERE ROWNUM <= %d"
+ ")" 
+ "WHERE ROW_NUM > %d";
	private static final String SELECT_COUNT = "SELECT COUNT(*) FROM ("
			+ "   (%s) SUBQ"
			+ ")";
	
	protected MRBRepository repository;
	protected JdbcTemplate jdbcTemplate;

	public JdbcBaseRepository(MRBRepository repository) {
		this.repository = repository;
		this.jdbcTemplate = repository.getJdbcTemplate();
	}
	
	protected int getRecordCount(String sql) {
		String sqlCount = String.format(SELECT_COUNT, sql);
		return jdbcTemplate.queryForObject(sqlCount, Integer.class);
	}
	
	protected <T> List<T> getPagingData(String sql, PagingOption option, RowMapper<T> rowMapper) {
		String sqlPaging = String.format(SELECT_PAGING, sql, option.getEndRoNum(), option.getStartRowNum());
		return jdbcTemplate.query(sqlPaging, rowMapper);
	}
	
}
