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

    public String addEvent(String n, int et, DateA ed, String h, double c, String d){

        EventType eventSelect = null;

        String out = "";

        switch(et){
            case 1:
                eventSelect = EventType.MAINTENANCE;
                break;
            case 2:
                eventSelect = EventType.SCHOOL_VISIT;
                break;
            case 3:
                eventSelect = EventType.IMPROVEMENT_ACTIVITY;
                break;
            case 4:
                eventSelect = EventType.CELEBRATION;
                break;
        }
       

        if (emptyPosE() == -1){

            out = "\nArray is full.";
        }else{

            events[emptyPosE()] = new Event(eventSelect, ed, h, c, d);

            wetlands[getWetlandSpace(n)].addEventToWetland(events[emptyPosE()-1]);
         
            out = "\nNew event added";
        }

        return out;

    }

    public String addSpecie(String en, String esn, boolean m, int t){

        String out = "";
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

        if (emptyPosS() == -1){

            out = "Array is full.";
        }else{

            species[emptyPosS()] = new Specie(en, esn, m, specieSelect);
            
            out = "New Specie added";
        }
        }else{
            out = "Specie already exists";
        }

        return out;
    }

    public String addSpecieToWetland(String en, String wn){

        String out = "";
        int a=0;
        if(searchSpecie(en)==-1){

            out = "\nSpecie doesn't exist.";
            a++;
        }
            
        if(getWetlandSpace(wn)==-1){
            out = "\nWetland doesn't exist.";
            a++;
            }
        if(a<1){
            Specie specie = species[searchSpecie(en)];
            Wetland wetland = wetlands[getWetlandSpace(wn)];
            wetlands[getWetlandSpace(wn)].addSpecieToWetland(specie);
            species[searchSpecie(en)].addWetlandToSpecie(wetland);
            out = "\nSpecie added successfully.";
            }
        

        if(a==2){
            out = "\nSpecie and wetland don't exist.";
        }

        return out;
    }

    public int searchSpecie(String n){

        int out = -1;

        for(int i = 0;i<maxSpecies;i++){
            if(species[i]!=null){
                if(species[i].getSpecieName().equals(n)){
                    out = i;
                }
            }
        }
        
        return out;
    }

    public String numberMaintenances(int year){

        String out = "";
        for(int i=0; i<maxWetlands;i++){
			if(wetlands[i]!=null){
				out += i+1 + ". Wetland name: "+ wetlands[i].getName()+ "\nNumber of maintenances: "+ wetlands[i].numMaintenance(year) + "\n\n";
			}
		}

        return out;
    }

    public String displayWetlands(){

		String totalWetlandsInfo="";

		for(int i=0; i<maxWetlands;i++){
			if(wetlands[i]!=null){
				totalWetlandsInfo += i+1 + ". " + wetlands[i].toString() + wetlands[i].calculateTotalSpecies() + "\n\n";
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
                System.out.println("\nWetland name already exists.\n");
                }
            }
        }

        return ok;
    }

    public int getWetlandSpace(String n){

        int out = -1;

        for(int i = 0; i<maxWetlands; i++){
            if(wetlands[i]!=null){
                if(wetlands[i].getName().equals(n)){
                    out = i;
                }
            }
        }

        return out;
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

    public boolean checkFor1234(int opt){

        boolean ok = false;
        do{
        if(opt!=2 & opt!=1 & opt!=3 & opt!=4){
            System.out.println("Enter a valid option.");
            break;
            }else{
                ok = true;
            }
        }while(opt!=2 & opt!=1 & opt!=3 & opt!=4);

        return ok;
    }

    public boolean checkFor12345(int opt){

        boolean ok = false;
        do{
        if(opt!=2 & opt!=1 & opt!=3 & opt!=4 & opt!=5){
            System.out.println("Enter a valid option.");
            break;
            }else{
                ok = true;
            }
        }while(opt!=2 & opt!=1 & opt!=3 & opt!=4 & opt!=5);

        return ok;
    }
	
    public String lessFloraWetland(){

        String out = "";
        int less = wetlands[0].getLessFlora();
        int index = 0;
        for(int i = 0;i<maxWetlands; i++){
            if(wetlands[i]!=null){
                if(wetlands[i].getLessFlora()<=less){
                    less = wetlands[i].getLessFlora();
                    index = i;
                }
            }
        }
        out = "\nThe wetland with less flora species is: "+wetlands[index].getName();
        
        return out;
    }
    
    public String mostFaunaWetland(){

        String out = "";
        int less = wetlands[0].getMostFauna();
        int index = 0;
        for(int i = 0;i<maxWetlands; i++){
            if(wetlands[i]!=null){
                if(wetlands[i].getMostFauna()>=less){
                    less = wetlands[i].getMostFauna();
                    index = i;
                }
            }
        }
        out = "\nThe wetland with most fauna species is: "+wetlands[index].getName();
        if(less==0){
            out = "\nThere are no fauna in any wetland.";
        }
        return out;
    }
   
    public String searchWetlands(String n){

        String out = "";

        if(searchSpecie(n)==-1){
            out = "Specie doesn't exist in any wetland";
        }else{
            out = species[searchSpecie(n)].searchWets();
        }
        return out;
   }
   
   public boolean wetlandExists(String wName){

    boolean ok = true;

    for(int i = 0; i<maxWetlands; i++){
        if(wetlands[i]!=null){
            if(wetlands[i].getName().equals(wName)){
            ok = false;
            }
        }
    }
    if(ok){
        System.out.println("\nWetlant doesn't exist.\n");
    }
    return ok;
}
}
