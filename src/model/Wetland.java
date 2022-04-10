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
		species = new Specie[maxSpecies];
		events = new Event[maxEvents];
	}

    public void addEventToWetland(Event e){

        events[emptyPosE()] = e;

    }

    public void addSpecieToWetland(Specie s){

        species[emptyPosS()] = s;
    }

    public String calculateTotalSpecies(){
        
        int totalAF = 0, totalLF = 0, totalM = 0, totalB = 0, totalA = 0;

        for(int i = 0;i<maxSpecies;i++){
            if(species[i]!=null){
                if(species[i].getSpecieType().equals(SpecieType.AQUATIC_FLORA)){

                    totalAF++;
                }
                if(species[i].getSpecieType().equals(SpecieType.LAND_FLORA)){

                    totalLF++;
                }
                if(species[i].getSpecieType().equals(SpecieType.MAMMAL)){

                 totalM++;
                }
                if(species[i].getSpecieType().equals(SpecieType.BIRD)){

                 totalB++;
                }
                if(species[i].getSpecieType().equals(SpecieType.AQUATIC_FAUNA)){

                 totalA++;
                }  
            }
        }

        return "This wetland has: \n"+totalAF+ " aquatic flora species."
        +"\n"+totalLF+ " land flora species."+
        "\n" + totalM + " mammal species."+
        "\n" + totalB + " bird species."
        + "\n" + totalA + " Aquatic fauna species.";
    }

    public int getLessFlora(){

        int totalAF = 0;
        int totalLF = 0;

        for(int i = 0;i<maxSpecies;i++){
            if(species[i]!=null){
                if(species[i].getSpecieType().equals(SpecieType.AQUATIC_FLORA)){

                    totalAF++;
                }
                if(species[i].getSpecieType().equals(SpecieType.LAND_FLORA)){

                    totalLF++;
                }
            }
        }

        int out= totalAF + totalLF;

        return out;
    }

    public String numMaintenance(int y){

        int count=0;

        for(int i=0;i<maxEvents;i++){
            if(events[i]!=null){
                if(events[i].getEventType().equals(EventType.MAINTENANCE)){
                    if(events[i].bringYear()==y){
                       count++; 
                    }
                }
            }
        }

        return "Number of maintenances:" + count;
    }

    public int emptyPosE(){

		int emptyPositionES= -1;
        boolean stop = false;
		for (int i=0; i<maxEvents & !stop; i++){

			if(events[i] == null){
				emptyPositionES= i;
                stop = true;
			}

		}
		return emptyPositionES;

	}

    public int emptyPosS(){

		int emptyPositionES= -1;
        boolean stop = false;
		for (int i=0; i<maxEvents & !stop; i++){

			if(species[i] == null){
				emptyPositionES= i;
                stop = true;
			}

		}
		return emptyPositionES;

	}

	public String toString(){

		String lt = null;
		String t = null;
		String p = null;

		if(locationType == true){
			lt = "Urban";
		}else{
			lt = "Rural";
		}
		if(type == true){
			t = "Private";
		}else{
			t = "Public";
		}
		if(protectedArea==true){
			p = "Yes";
		}else{
			p = "No";
		}

		return "Wetland's name: "+name
		+"\nLocation type: "+lt
		+"\nLocation name: "+locationName
		+"\nType of wetland: "+t
		+"\nArea: "+area+"km2"
		+"\nPicture URL: "+pictureURL
		+"\nProtected: "+p+"\n";
	}

    public String organizeEvents(){

        String out = "";

        for(int i=0; i<maxEvents;i++){
			if(events[i]!=null){
				out += i+1 + ". " + events[i].toString() + "\n\n";
			}
		}

        return out;
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
     * @return Specie[] return the species
     */
    public Specie[] getSpecies() {
        return species;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return boolean return the locationType
     */
    public boolean isLocationType() {
        return locationType;
    }

    /**
     * @param locationType the locationType to set
     */
    public void setLocationType(boolean locationType) {
        this.locationType = locationType;
    }

    /**
     * @return boolean return the type
     */
    public boolean isType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(boolean type) {
        this.type = type;
    }

    /**
     * @return double return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return String return the pictureURL
     */
    public String getPictureURL() {
        return pictureURL;
    }

    /**
     * @param pictureURL the pictureURL to set
     */
    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    /**
     * @return boolean return the protectedArea
     */
    public boolean isProtectedArea() {
        return protectedArea;
    }

    /**
     * @param protectedArea the protectedArea to set
     */
    public void setProtectedArea(boolean protectedArea) {
        this.protectedArea = protectedArea;
    }

    /**
     * @return String return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName the locationName to set
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @param species2 the species to set
     */
    public void setSpecies(Specie[] species) {
        this.species = species;
    }

    /**
     * @return Event[] return the events
     */
    public Event[] getEvents() {
        return events;
    }

}