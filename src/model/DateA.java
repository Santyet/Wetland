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

    /**
     * @return int return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return int return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return int return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

}
