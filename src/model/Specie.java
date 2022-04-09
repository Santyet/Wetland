package model;

public class Specie {

	private String specieName;
	private String scientificName;
	private boolean migratory;
	private Wetland[] wetlands;
    private SpecieType specieType;
	private static final int maxWetlands=79;

	/**
	 * 
	 * @param specieName
	 * @param scientificName
	 * @param migratory
	 * @param type
	 */

	public Specie(String specieName, String scientificName, boolean migratory, SpecieType specieType) {
		this.specieName = specieName;
		this.scientificName = scientificName;
		this.migratory = migratory;
		wetlands = new Wetland[maxWetlands];
        this.specieType= specieType;
	}
	
	public String toString(){
		
		return "Specie Name: "+specieName
		+"Scientific name: "+scientificName
		+"Migratory: "+migratory
		+"Specie type: "+specieType;
	}

	public String organizeWetlands(){

		String totalWetlandsInfo="";

		for(int i=0; i<maxWetlands;i++){
			if(wetlands[i]!=null){
				totalWetlandsInfo+=i + ". " + wetlands[i] + "\n";
			}
		}
		return totalWetlandsInfo;
	}

    /**
     * @return String return the specieName
     */
    public String getSpecieName() {
        return specieName;
    }

    /**
     * @param specieName the specieName to set
     */
    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }

    /**
     * @return String return the scientificName
     */
    public String getScientificName() {
        return scientificName;
    }

    /**
     * @param scientificName the scientificName to set
     */
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    /**
     * @return boolean return the migratory
     */
    public boolean isMigratory() {
        return migratory;
    }

    /**
     * @param migratory the migratory to set
     */
    public void setMigratory(boolean migratory) {
        this.migratory = migratory;
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
