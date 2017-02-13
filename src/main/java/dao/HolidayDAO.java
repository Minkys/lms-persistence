package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Holiday;
import util.ConnectionUtil;

public class HolidayDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<Holiday> list() {

		String sql = "SELECT ID, HOLIDAY_DATE, REASON FROM HOLIDAYS";
		
		List<Holiday> list = jdbcTemplate.query(sql, new Object[]{}, (rs, rowNo) -> {

			Holiday holiday = new Holiday();
			holiday.setId(rs.getLong("ID"));
			holiday.setHolidayDate(rs.getDate("HOLIDAY_DATE").toLocalDate());
			holiday.setStatus(rs.getString("REASON"));
			return holiday;
		});
		return list;

	}
}
