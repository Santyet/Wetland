package model;

public class DateA {

	private int day;
	private int month;
	private int year;

	/**
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public DateA(int day, int month, int year) {
		this.day = day;
		this.month = month; 
		this.year = year;
	}

	public String toString(){

		return day+"/"+month+"/"+year;
	}
}
