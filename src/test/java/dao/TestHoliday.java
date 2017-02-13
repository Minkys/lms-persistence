package dao;

import java.util.List;

import model.Holiday;
import service.HolidayService;

public class TestHoliday {

	public static void main(String[] args) {
		

		HolidayService HolidayService = new HolidayService();
			
		List<Holiday> list = HolidayService.list();
		for (Holiday holiday : list) {
			System.out.println(holiday);
	}
}
}
