package model;

public class Plan {

	private double percentage;
	private int count;

	/**
	 * 
	 * @param percentage
	 * @param count
	 */
	public Plan(double percentage, int count) {
		this.percentage = percentage;
		this.count = count;
	}

	public String toString(){

		return "The percentage is: "+percentage
		+"\nThe number of yearly maintenance is: "+count;
	}

}
