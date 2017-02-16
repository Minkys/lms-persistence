package service;

import java.util.List;

import dao.HolidayDAO;
import model.Holiday;

public class HolidayService {

	private HolidayDAO holidayDao = new HolidayDAO();
	
	public List<Holiday> list() {

		return holidayDao.list();
	}
	public void save(Holiday holiday) {
		holidayDao.addHoliday(holiday);
	}
	
	public void delete(Long holidayId) {
		holidayDao.delete(holidayId);
	}
	
	public void update(Holiday holiday) {
		holidayDao.update(holiday);
	}
	
	public Holiday findById(Long id) {

		return holidayDao.findById(id);
	}
}
