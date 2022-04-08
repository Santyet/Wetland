package model;

public class Wetland{

	private String name;
	private boolean locationType;
	private boolean type;
	private double area;
	private String pictureURL;
	private boolean protectedArea;
	private String locationName;
	private Specie[] species;
	private Event[] events;
	private int eventCount;
	private static final int maxSpecies=9999999;
	private static final int maxEvents=9999999;

	/**
	 * @param name
	 * @param locationType
	 * @param type
	 * @param area
	 * @param pictureURL
	 * @param protectedArea
	 */
	public Wetland(String name, boolean locationType, String locationName, boolean type, double area, String pictureURL, boolean protectedArea) {
		this.name = name;
		this.locationType = locationType;
		this.type = type;
		this.area = area;
		this.pictureURL = pictureURL;
		this.protectedArea = protectedArea;
		this.locationName = locationName;
		eventCount = 0;
		species = new Specie[maxSpecies];
		events = new Event[maxEvents];
	}

	public String toString(){

		return "Wetland's name: "+name
		+"\nLocation type: "+locationType
		+"\nLocation name: "+locationName
		+"\nType of wetland: "+type
		+"\nArea: "+area+"km2"
		+"\nPicture URL: "+pictureURL
		+"\nProtected: "+protectedArea
		+"\nNumber of events done: "+eventCount;
	}

	public String organizeSpecies(){

		String totalSpeciesInfo="";

		for(int i=0; i<maxSpecies;i++){
			if(species[i]!=null){
				totalSpeciesInfo+=i + ". " + species[i] + "\n";
			}
		}
		return totalSpeciesInfo;
	}

	public void setEvents(Event[] events) {
		this.events = events;
	}

	/**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

	 /**
     * @return int return the eventCount
     */
    public int getEventCount() {
        return eventCount;
    }

    /**
     * @param eventCount the eventCount to set
     */
    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }
}