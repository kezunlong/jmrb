package mrb.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;

import ir.utilities.db.PagingOption;
import mrb.db.MeetingRoomRepository;
import mrb.model.meetingroom.MeetingRoom;
import mrb.model.meetingroom.MeetingRoomFilter;


public class MeetingRoomJdbcRepository extends JdbcBaseRepository implements MeetingRoomRepository {
	private static final String SELECT_MEETINGROOM = "SELECT * FROM MRB_MEETINGROOM";
	private static final String SELECT_MEETINGROOM_NEWID = "SELECT SEQ_MRB_MEETINGROOM.NEXTVAL AS ID FROM DUAL";
	private static final String INSERT_MEETINGROOM = "INSERT INTO MRB_MEETINGROOM(ID, NAME, NAMECN, OFFICEID, FLOOR, CAPACITY, HASPROJECTOR, STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_MEETINGROOM = "UPDATE MRB_MEETINGROOM SET NAME = ?, NAMECN = ?, OFFICEID = ?, FLOOR = ?, CAPACITY = ?, HASPROJECTOR = ?, STATUS = ? WHERE ID = ?";
	private static final String DELETE_MEETINGROOM = "DELETE MRB_MEETINGROOM WHERE ID = ?";

	private static final Log logger = LogFactory.getLog(MeetingRoomJdbcRepository.class);
	
	public MeetingRoomJdbcRepository(MRBRepository repository) {
		super(repository);
	}

	@Override
	public List<MeetingRoom> findAll() {
		return jdbcTemplate.query(SELECT_MEETINGROOM, new MeetingRoomRowMapper());
	}

	@Override
	public List<MeetingRoom> filter(MeetingRoomFilter filter, PagingOption option) {
		String sql = SELECT_MEETINGROOM + " WHERE 1 = 1" + filter.getFilterString(); 
		logger.info(sql);
		if(option.getFetchRecordCount()) {
			option.setRecordCount(getRecordCount(sql));
		}
		
		return getPagingData(sql, option, new MeetingRoomRowMapper());
	}

	@Override
	public MeetingRoom findById(int id) {
		String sql = SELECT_MEETINGROOM + " WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new MeetingRoomRowMapper(), id);
	}

	@Override
	public void insert(MeetingRoom item) {
		int id = jdbcTemplate.queryForObject(SELECT_MEETINGROOM_NEWID, Integer.class);
		item.setId(id);
		
		jdbcTemplate.update(INSERT_MEETINGROOM,
				item.getId(),
				item.getName(),
				item.getNameCN(),
				item.getOfficeId(),
				item.getFloor(),
				item.getCapacity(),
				item.getHasProjector(),
				item.getStatus().toString());
	}

	@Override
	public void update(MeetingRoom item) {
		jdbcTemplate.update(UPDATE_MEETINGROOM,
				item.getName(),
				item.getNameCN(),
				item.getOfficeId(),
				item.getFloor(),
				item.getCapacity(),
				item.getHasProjector(),
				item.getStatus().toString(),
				item.getId());
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update(DELETE_MEETINGROOM, id);
	}
	
	private static final class MeetingRoomRowMapper implements RowMapper<MeetingRoom> {
		public MeetingRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
			MeetingRoom item = new MeetingRoom();
			item.setId(rs.getInt("ID"));
			item.setName(rs.getString("NAME"));
			item.setNameCN(rs.getString("NAMECN"));
			item.setOfficeId(rs.getString("OFFICEID"));
			item.setFloor(rs.getInt("FLOOR"));
			item.setCapacity(rs.getInt("CAPACITY"));
			item.setHasProjector(rs.getBoolean("HASPROJECTOR"));
			item.setStatus(MeetingRoomStatus.valueOf(rs.getString("STATUS")));
			return item;
		}
	}
}