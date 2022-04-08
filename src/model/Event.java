package model;

public class Event {

	private String eventType;
	private DateA eventDate;
	private String host;
	private double cost;
	private String description;

	/**
	 * @param eventType
	 * @param ed
	 * @param host
	 * @param cost
	 * @param description
	 */

	public Event(String eventType, DateA ed, String host, double cost, String description) {
		this.eventType = eventType;
		this.eventDate = ed;
		this.host = host;
		this.cost = cost;
		this.description = description;
	}

	public String toString(){

		return "Event type: "+eventType
		+"\nEvent date: "+eventDate
		+"\nEvent host: "+host
		+"\nEvent cost: "+cost
		+"\nEvent description: "+description;
	}
}
