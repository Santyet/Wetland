package model;

public class Event {

	private EventType eventType;
	private DateA eventDate;
	private String host;
	private double cost;
	private String description;

	/**
	 * @param eventSelect
	 * @param ed
	 * @param host
	 * @param cost
	 * @param description
	 */

	public Event(EventType eventSelect, DateA ed, String host, double cost, String description) {
		this.eventType = eventSelect;
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

	public int bringYear(){

		return eventDate.getYear();
	}

    /**
     * @return EventType return the eventType
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    /**
     * @return DateA return the eventDate
     */
    public DateA getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(DateA eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * @return String return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return double return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
