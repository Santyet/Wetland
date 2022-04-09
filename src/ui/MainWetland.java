package ui;
import java.util.Scanner;

import javax.swing.border.EtchedBorder;
import javax.swing.text.AsyncBoxView;

import model.SystemWL;
import model.DateA;


public class MainWetland {

    private Scanner sc = new Scanner (System.in);
    private SystemWL system = new SystemWL();	
    
    public static void main(String[] args){		

        System.out.println("##################");
        System.out.println("WETLAND MANAGEMENT");
        System.out.println("##################");

        MainWetland objMain = new MainWetland();

        int option=0;

        do {
		    option = objMain.showMenu();
		    objMain.answerOption(option);
		}while (option !=0);


    }

    public int showMenu(){
        int input;

        System.out.println("\n\nPlease select an option:"
        +"\n(0) To exit."
        +"\n(1) To create a wetland."
        +"\n(2) To register a new specie in a wetland."
        +"\n(3) To register an event in a wetland."
        +"\n(4) To get specific year maintenance number on every wetland."
        +"\n(5) To display the wetland with less flora species."
        +"\n(6) To search every wetland containing the wished specie."
        +"\n(7) To display every wetland info."
        +"\n(8) To display the wetland with most animals.");

        input=sc.nextInt();
        sc.nextLine();

        return input;
    }

    public void answerOption(int option){

        switch(option){

            case 0:
                System.out.println("\nExiting app, goodbye :)");
                break;
            case 1:
                registerWetland();
                break;
            case 2:
                addSpecie();
                break;
            case 3:
            
                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:
                System.out.println(system.displayWetlands());;
                break;
            case 8:

                break;
            default:
                System.out.println("\nPlease type a valid option.");
        }
    }

    public void registerWetland(){

        String wName;
        int option;
        boolean wLocationType;
        boolean wType;
        double wArea;
        String wPictureURL;
        boolean wProtectedArea;
        String wLocationName;
        int maxWetlands = system.getMaxWetlands();

        do{
        System.out.println("Registering wetland...\nPlease enter the name of the wetland: ");
        wName = sc.nextLine();
        }while(!system.checkForWetlandName(wName));
        
       
        do{
        System.out.println("Please enter the location type of the wetland (1) for urban and (2) for rural: ");
        option = sc.nextInt();
        sc.nextLine();
        }while(!system.checkFor12(option));

        if(option==1){
            wLocationType = true;
        }else{
            wLocationType = false;
        }
        

        System.out.println("Please enter the location name of the wetland: ");
        wLocationName = sc.nextLine();
    
        do{
        System.out.println("Please enter the type of the wetland (1) for public and (2) for private: ");
        option = sc.nextInt();
            
        system.checkFor12(option);
        }while(option!=2 & option!=1);
        if(option==1){
            wType = true;
        }else{
            wType = false;
        }
        do{
        System.out.println("Please enter the area of the wetland: ");
        wArea = sc.nextDouble();
        sc.nextLine();
        if(wArea<1){
            System.out.println("Enter a valid option");
        }
        }while(wArea<1);

        System.out.println("Please enter te image URL of the wetland: ");
        wPictureURL = sc.nextLine();

        do{
        System.out.println("Enter (1) if the wetland is a protected area, (2) if not: ");
        option = sc.nextInt();
        
        system.checkFor12(option);
        }while(option!=2 & option!=1);
        if(option==1){
            wProtectedArea = true;
        }else{
            wProtectedArea = false;
        }

        System.out.println(system.addWetland(wName, wLocationType, wLocationName, wType, wArea, wPictureURL, wProtectedArea));
    }

    public void registerEvent(){

        String eName;
        String eType;
        DateA eDate;
        String eHost;
        double eCost;
        String eDescription;
        int eDay;
        int eMonth;
        int eYear;

        System.out.println("Please type the name of the wetland where you want to create the event: ");
        eName = sc.nextLine();

        System.out.println("Please type the event type: ");
        eType = sc.nextLine();

        System.out.println("Please type the event date... \nDay: ");
        eDay = sc.nextInt();

        System.out.println("Month: ");
        eMonth = sc.nextInt();

        System.out.println("Year: ");
        eYear = sc.nextInt();

        eDate = new DateA(eDay, eMonth, eYear);

        System.out.println("Please type the name of the event's host:");
        eHost = sc.nextLine();

        System.out.println("Please type the cost of the event: ");
        eCost = sc. nextDouble();
        
        System.out.println("Please type the event description: ");
        eDescription = sc.nextLine();

        System.out.println(system.addEvent(eName, eType, eDate, eHost, eCost, eDescription));
    }

    public void addSpecie(){

        String name;
        String sciName;
        String wetName;
        int migOpt;
        boolean mig;
        int option;

        System.out.println("Please enter the wetland to add the specie: ");
        wetName = sc.nextLine();

        System.out.println("Please enter the type of the specie: \n(1)Acuatic Flora."+
        "\n(2)Land Flora."+
        "\n(3)Mammal."+
        "\n(4)Bird."+
        "\n(5)Acuatic Fauna");

        option = sc.nextInt();
        sc.nextLine();

        System.out.println("Please enter the name of the specie: ");
        name = sc.nextLine();

        System.out.println("please enter the scientific name of the specie: ");
        sciName = sc.nextLine();

        System.out.println("Is the specie migratory? "+
        "\n(1)Yes.\n(2)No.");
        migOpt = sc.nextInt();
        if(migOpt==1){
            mig=true;
        }else{
            mig=false;
        }

        System.out.println(system.addSpecie(wetName, name, sciName, mig, option));

    }


    /**
     * @return Scanner return the sc
     */
    public Scanner getSc() {
        return sc;
    }

    /**
     * @param sc the sc to set
     */
    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    /**
     * @return SystemWL return the system
     */
    public SystemWL getSystem() {
        return system;
    }

    /**
     * @param system the system to set
     */
    public void setSystem(SystemWL system) {
        this.system = system;
    }

}


