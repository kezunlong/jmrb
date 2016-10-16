package mrb.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import ir.utilities.db.PagingOption;
import mrb.db.UserRepository;
import mrb.model.auth.User;
import mrb.model.auth.UserFilter;


public class UserJdbcRepository extends JdbcBaseRepository implements UserRepository {
	private static final String SELECT_USER = "SELECT * FROM MRB_USER";
	private static final String SELECT_USER_NEWID = "SELECT SEQ_MRB_USER.NEXTVAL AS ID FROM DUAL";
	private static final String INSERT_USER = "INSERT INTO MRB_USER(ID, USERNAME, ENGLISHNAME, CHINESENAME, EMAIL, TELEPHONE, MOBILE, SECTORID, OFFICEID, ADDRESS, STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_USER = "UPDATE MRB_USER SET USERNAME = ?, ENGLISHNAME = ?, CHINESENAME = ?, EMAIL = ?, TELEPHONE = ?, MOBILE = ?, SECTORID = ?, OFFICEID = ?, ADDRESS = ?, STATUS = ? WHERE ID = ?";
	private static final String DELETE_USER = "DELETE MRB_USER WHERE ID = ?";

	private static final Log logger = LogFactory.getLog(UserJdbcRepository.class);
	
	public UserJdbcRepository(MRBRepository repository) {
		super(repository);
	}

	public List<User> findAll() {
		return jdbcTemplate.query(SELECT_USER, new UserRowMapper());
	}

	public List<User> filter(UserFilter filter, PagingOption option) {
		String sql = SELECT_USER + " WHERE 1 = 1" + filter.getFilterString(); 
		logger.info(sql);
		if(option.getFetchRecordCount()) {
			option.setRecordCount(getRecordCount(sql));
		}
		
		return getPagingData(sql, option, new UserRowMapper());
	}

	public User findById(int id) {
		String sql = SELECT_USER + " WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
	}
	
	public User findByUserName(String userName) {
		String sql = SELECT_USER + " WHERE UserName = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new UserRowMapper(), userName);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	public void insert(User item) {
		int id = jdbcTemplate.queryForObject(SELECT_USER_NEWID, Integer.class);
		item.setId(id);
		
		jdbcTemplate.update(INSERT_USER,
				item.getId(),
				item.getUserName(),
				item.getEnglishName(),
				item.getChineseName(),
				item.getEmail(),
				item.getTelephone(),
				item.getMobile(),
				item.getSectorId(),
				item.getOfficeId(),
				item.getAddress(),
				item.getStatus());
	}

	public void update(User item) {
		jdbcTemplate.update(UPDATE_USER,
				item.getUserName(),
				item.getEnglishName(),
				item.getChineseName(),
				item.getEmail(),
				item.getTelephone(),
				item.getMobile(),
				item.getSectorId(),
				item.getOfficeId(),
				item.getAddress(),
				item.getStatus(),
				item.getId());
	}

	public void delete(int id) {
		jdbcTemplate.update(DELETE_USER, id);
	}
	
	private static final class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User item = new User();
			item.setId(rs.getInt("ID"));
			item.setUserName(rs.getString("USERNAME"));
			item.setEnglishName(rs.getString("ENGLISHNAME"));
			item.setChineseName(rs.getString("CHINESENAME"));
			item.setEmail(rs.getString("EMAIL"));
			item.setTelephone(rs.getString("TELEPHONE"));
			item.setMobile(rs.getString("MOBILE"));
			item.setSectorId(rs.getString("SECTORID"));
			item.setOfficeId(rs.getString("OFFICEID"));
			item.setAddress(rs.getString("ADDRESS"));
			item.setStatus(rs.getBoolean("STATUS"));
			return item;
		}
	}
}