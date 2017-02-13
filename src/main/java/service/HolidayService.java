package service;

import java.util.List;

import dao.HolidayDAO;
import model.Holiday;

public class HolidayService {

	private HolidayDAO holidayDao = new HolidayDAO();
	
	public List<Holiday> list() {

		return holidayDao.list();
	}
	
}
