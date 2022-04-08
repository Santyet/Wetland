package model;

public class Specie {

	private String specieName;
	private String scientificName;
	private boolean migratory;
	private String specieType;
	private Wetland[] wetlands;
	private static final int maxWetlands=79;

	/**
	 * 
	 * @param specieName
	 * @param scientificName
	 * @param migratory
	 * @param type
	 */

	public Specie(String specieName, String scientificName, boolean migratory, String specieType) {
		this.specieName = specieName;
		this.scientificName = scientificName;
		this.migratory = migratory;
		this.specieType = specieType;
		wetlands = new Wetland[maxWetlands];
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
     * @return String return the specieType
     */
    public String getSpecieType() {
        return specieType;
    }

    /**
     * @param specieType the specieType to set
     */
    public void setSpecieType(String specieType) {
        this.specieType = specieType;
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
