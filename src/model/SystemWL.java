package model;

import java.lang.StackWalker.Option;
import java.sql.Blob;

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
        
		if(emptyPosWetlands() == -1){ 

			out = "Array is full.";

		}else{ 
			
			wetlands[emptyPosWetlands()] =  new Wetland(n, lt, ln, t, a, purl, pa);
			out = "New wetland added.";

		}

		return out;

	}

    public String addEvent(String n, String et, DateA ed, String h, double c, String d){

        

        String out = "";
        int select;

        for(int i = 0; i<maxWetlands;i++){

            if(wetlands[i].getName().equals(n)){
                select = i;
            }
        }

        if (emptyPosES() == -1){

            out = "Array is full.";
        }else{

            events[emptyPosES()] = new Event(et, ed, h, c, d);
         
            out = "New event added";
        }

        return out;

    }

 public String addSpecie(String n, String en, String esn, boolean m, int t){

        String out = "";
        int select;
        SpecieType specieSelect = null;
        boolean ok = true;

        for(int i = 0; i<maxWetlands; i++){
            if(species[i]!=null){
                if(species[i].getSpecieName().equals(en)){
                ok = false;
                }
            }
        }
        if(ok == true){
            for(int i = 0; i<maxWetlands; i++){
                if(wetlands[i]!=null){
                    if(wetlands[i].getName().equals(n)){
                    select = i;
                    }
                }
        }
			
			switch(t){
				case 1:
					specieSelect = SpecieType.AQUATIC_FLORA;
					break;
				case 2:
					specieSelect = SpecieType.LAND_FLORA;
					break;
				case 3:
					specieSelect = SpecieType.MAMMAL;
					break;
				case 4:
					specieSelect = SpecieType.BIRD;
					break;
				case 5:
					specieSelect = SpecieType.AQUATIC_FAUNA;
					break;

			}		

        if (emptyPosES() == -1){

            out = "Array is full.";
        }else{

            species[emptyPosES()] = new Specie(en, esn, m, specieSelect);
            
            out = "New Specie added";
        }
        }else{
            out = "Specie already exists";
        }

        return out;
    }

    public void associateSpecie2Wetland(){

        
    }

    public String displayWetlands(){

		String totalWetlandsInfo="";

		for(int i=0; i<maxWetlands;i++){
			if(wetlands[i]!=null){
				totalWetlandsInfo += i+1 + ". " + wetlands[i].toString() + "\n\n";
			}
		}
		return totalWetlandsInfo;
	}

    public boolean checkForWetlandName(String wName){

        boolean ok = true;

        for(int i = 0; i<maxWetlands; i++){
            if(wetlands[i]!=null){
                if(wetlands[i].getName().equals(wName)){
                ok = false;
                System.out.println("\nWetland name already exists.");
                }
            }
        }

        return ok;
    }

    public boolean checkFor12(int opt){

        boolean ok = false;
        do{
        if(opt!=2 & opt!=1){
            System.out.println("Enter a valid option.");
            break;
            }else{
                ok = true;
            }
        }while(opt!=2 & opt!=1);

        return ok;
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


    /**
     * @return Specie[] return the species
     */
    public Specie[] getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(Specie[] species) {
        this.species = species;
    }

}