package ui;
import java.util.Scanner;

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
        +"\n(2) To register a new specie"
        +"\n(3) To add a specie to a wetland."
        +"\n(4) To register an event in a wetland."
        +"\n(5) To get specific year maintenance number on every wetland."
        +"\n(6) To display the wetland with less flora species."
        +"\n(7) To search every wetland that contains the wished specie."
        +"\n(8) To display every wetland info."
        +"\n(9) To display the wetland with most animals.");

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
                registerSpecie();
                break;
            case 3:
                registerSpecieToWetland();
                break;
            case 4:
                registerEvent();
                break;
            case 5:
                showMaintenance();
                break;
            case 6:
                System.out.println(system.lessFloraWetland());
                break;
            case 7:
                searchWetlandsFromSpecie();
                break;
            case 8:
                System.out.println(system.displayWetlands());;
                break;
            case 9:
                System.out.println(system.mostFaunaWetland());
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
        int eType;
        DateA eDate;
        String eHost;
        double eCost;
        String eDescription;
        int eDay;
        int eMonth;
        int eYear;

        System.out.println("Please type the name of the wetland where you want to create the event: ");
        eName = sc.nextLine();
        do{
        System.out.println("Please select the event type: \n(1)Maintenance."+
        "\n(2)School visit."+
        "\n(3)Improvement activity."+
        "\n(4)Celebrations.");
        eType = sc.nextInt();
        }while(!system.checkFor1234(eType));

        System.out.println("Please type the event date... \nDay: ");
        eDay = sc.nextInt();

        System.out.println("Month: ");
        eMonth = sc.nextInt();

        System.out.println("Year: ");
        eYear = sc.nextInt();
        sc.nextLine();

        eDate = new DateA(eDay, eMonth, eYear);

        System.out.println("Please type the name of the event's host:");
        eHost = sc.nextLine();

        System.out.println("Please type the cost of the event: ");
        eCost = sc. nextDouble();
        sc.nextLine();

        System.out.println("Please type the event description: ");
        eDescription = sc.nextLine();

        System.out.println(system.addEvent(eName, eType, eDate, eHost, eCost, eDescription));
    }

    public void registerSpecie(){

        String name;
        String sciName;
        int migOpt;
        boolean mig;
        int option;
        do{
        System.out.println("Please enter the type of the specie: \n(1)Acuatic Flora."+
        "\n(2)Land Flora."+
        "\n(3)Mammal."+
        "\n(4)Bird."+
        "\n(5)Acuatic Fauna");
        option = sc.nextInt();
        }while(!system.checkFor12345(option));
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

        System.out.println(system.addSpecie(name, sciName, mig, option));

    }

    public void registerSpecieToWetland(){

        String wName;
        String specie;

        System.out.println("Please type the specie to add: ");
        specie = sc.nextLine();

        System.out.println("Please type the wetland to add the specie: ");
        wName = sc.nextLine();

        System.out.println(system.addSpecieToWetland(specie, wName));

    }

    public void showMaintenance(){
        int year;

        System.out.println("Please type the year to know the maintenances done.");
        year = sc.nextInt();

        System.out.println(system.numberMaintenances(year));
    }

    public void searchWetlandsFromSpecie(){

        String search;

        System.out.println("Please type the specie to find the wetlands where it lives:");
        search = sc.nextLine();
        System.out.println(system.searchWetlands(search));
    }

}


