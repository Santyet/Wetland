package model;

public class SystemWL {

    private static final int maxWetlands=79;
    private static final int maxEvents=9999999;
    private static final int maxSpecies = 9999999;
    private Event[] events;
    private Wetland[] wetlands;
    private Specie[] species;

    
    public SystemWL(){
        events = new Event[maxEvents];
        wetlands = new Wetland[maxWetlands];
        species = new Specie[maxSpecies];
    }

    public int emptyPosES(){

		int emptyPositionE= -1;
        boolean stop = false;
		for (int i=0; i<maxEvents & !stop; i++){

			if(events[i] == null){
				emptyPositionE= i;
                stop = true;
			}

		}
		return emptyPositionE;

	}

	public int emptyPosWetlands(){

		int emptyPositionW=-1;
        boolean stop = false;
		for (int i=0; i<maxWetlands & !stop; i++){

			if(wetlands[i] == null){
				emptyPositionW= i;
                stop=true;
			}
		}
		return emptyPositionW;

	}



	public String addWetland(String n, boolean lt, String ln, boolean t, double a, String purl, boolean pa) {

		String out = "";

		int emptyPositionW = emptyPosWetlands();

		if(emptyPositionW == -1){ 

			out = "Array is full.";

		}else{ 
			
			wetlands[emptyPositionW] =  new Wetland(n, lt, ln, t, a, purl, pa);
			out = "New wetland added.";

		}

		return out;

	}

    public String addEvent(String n, String et, DateA ed, String h, double c, String d){

        

        String out = "";
        int select;

        int emptyPositionE = emptyPosES();

        for(int i = 0; i<maxWetlands;i++){

            if(wetlands[i].getName().equals(n)){
                select = i;
            }
        }

        if (emptyPositionE == -1){

            out = "Array is full.";
        }else{

            events[emptyPositionE] = new Event(et, ed, h, c, d);
         
            out = "New event added";
        }

        return out;

    }

    public String addSpecie(){

        String out = "";

        return out;
    }

	public int getMaxWetlands(){

		return maxWetlands;
	}

    /**
     * @return Event[] return the events
     */
    public Event[] getEvents() {
        return events;
    }

    /**
     * @param events the events to set
     */
    public void setEvents(Event[] events) {
        this.events = events;
    }

    /**
     * @return Wetland[] return the wetlands
     */
    public Wetland[] getWetlands() {
        return wetlands;
    }

    /**
     * @param wetlands the wetlands to set
     */
    public void setWetlands(Wetland[] wetlands) {
        this.wetlands = wetlands;
    }

}
