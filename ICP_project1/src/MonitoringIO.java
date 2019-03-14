/*
 *A monitoring input/output class that monitors Galamsey objects.
 *@author Michael Dankwah AGYEMAN-PREMPEH
 *@author Alhassan ISSIFU
 *@author Francis AWEENGUA
 *@author Eugenia AKPO
 */

import java.util.Scanner;

public class MonitoringIO {



    public static void main(String[] args) {

        //instantiates two scanners for both String and Int inputs from the user.
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        //Instantiates an observatory.
        Observatory ob1 = null;

        //While look keeps the program running until user inputs 0 in the main menu to close it
        while (true) {
            int chooseInput;  // keeps the users input from the main menu

            // if condition ensures that user can only create an observatory if the Observatory list is empty,
            //that is, when user has no observatory to access data from.
            if (Monitoring.observatories.isEmpty()){
                System.out.println(" ");
                System.out.println("***************************************************************");
                System.out.println("***** Observatory list is empty, Create a new observatory *****");
                System.out.println("***************************************************************");
                System.out.println(" ");
                chooseInput = 1;
            }else {
                // User can now obtain data from existing observatories or create new observatories if there is at least one existing observatory
                System.out.println(" ");
                System.out.println("**************************************************");
                System.out.println("***** Please select a task in the menu below *****");
                System.out.println("**************************************************");
                System.out.println("1 Create Observatory.\n2 to Create 'Galamsay' event.\n3 to provide monitoring statistics.\n0 to Exit");
                chooseInput = scan.nextInt();
                System.out.println(" ");
            }


            //Switch determines next task based on user's input in the main menu.
            switch (chooseInput) {
                case 1:

                    // if user's input in the main menu was 1, user inputs the details of the observatory for it to be created.
                    System.out.println("Input name of Observatory");
                    String obName = scan2.nextLine();
                    ob1 = new Observatory();
                    ob1.setName(obName);

                    System.out.println("Enter Country");
                    String obCountry = scan2.nextLine();
                    ob1.setCountry(obCountry);

                    System.out.println("Enter Year Started");
                    int obYear = scan.nextInt();
                    ob1.setYearStarted(obYear);

                    System.out.println("Enter Area Covered by Observatory In Square Kilometers");
                    double obArea = scan.nextDouble();
                    ob1.setAreaInSquareMeters(obArea);

                    // After spcifying details of observatory, the created observatoru is added to the observatory list.
                    Monitoring.observatories.add(ob1);
                    // A notification is displayed to notify the user that the observatory has been created.
                    System.out.println("\n<<>> Notification: new observatory added <<>>");
                    break;

                case 2:

                    //If user's input in the main menu was 2, user creates new "Galamsey" event
                    System.out.println("\nSelect an Observatory");

                    // All available observatories are shown for user to choose one to add "Galamsey" event to
                    for (Observatory anObservatory: Monitoring.observatories){
                        System.out.println(Monitoring.observatories.indexOf(anObservatory)+1 + " " + anObservatory.getName() + " observatory");
                    }
                    int nameOfob = scan.nextInt();

                    //Shows the oservatory the user is adding the galamsey event to
                    System.out.println("\n[[] Input 'Galamsey' Data for the " + Monitoring.observatories.get(nameOfob-1).getName() + " observatory []]");

                    // User specifies the number of galemsey events he/she intends to record.
                    System.out.println("\nHow many 'Galamsey' activities will you like to record");
                    int numOfevents = scan.nextInt();

                    // user inputs galamsey data for the number of times specified above
                    // user can input 'exit' to end the input if there is a need to halt.
                    for (int i =0; i<numOfevents; i++){
                        System.out.println("\nInput Data for 'Galamsey' event [" + (i+1) +"] for " + Monitoring.observatories.get(nameOfob-1).getName() + " observatory");
                        System.out.println("\nEnter colour of vegetation (Green, Yellow or Brown) or 'exit' to quit");
                        String vegColor = scan2.nextLine();
                        if(vegColor.toLowerCase().equals("exit")) break;
                        Galamsey galamsey = new Galamsey();
                        galamsey.setVegetationColour(vegColor);

                        //the color specified by the user is converted to int and assigned to the vegetation colour value
                        if (vegColor.toLowerCase().equals("green")) galamsey.setVegetationColourValue(1);
                        if (vegColor.toLowerCase().equals("yellow")) galamsey.setVegetationColourValue(2);
                        if (vegColor.toLowerCase().equals("brown")) galamsey.setVegetationColourValue(3);


                        System.out.println("Enter location of 'Galamsey' site in latitude");
                        double siteLat = scan.nextDouble();
                        galamsey.setVegetationLongitude(siteLat);

                        System.out.println("Enter location of 'Galamsey' site in longitude");
                        double siteLong = scan.nextDouble();
                        galamsey.setVegetationLatitude(siteLong);


                        System.out.println("Enter the year this 'Galamsey' event started");
                        int galYear = scan.nextInt();
                        galamsey.setEventYear(galYear);

                        //new galamsey event is added to the galamsey events list for its observatory
                        Monitoring.observatories.get(nameOfob-1).addEvent(galamsey);

                        //user is notified on the successful addition of the galamsey event
                        System.out.println("\n<<>> Notification: 'Galamsey' data added <<>>");
                    }
                    break;
                case 3:
                    //If user's input in the main menu was 3, User can view the data recorded

                    //while loop keeps block running until user inputs 0 to go to the main menu.
                    while (true) {

                        //Asks user to select the type of information user wants to view.
                        System.out.println(" ");
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("++++ Kindly choose one of the following items ++++");
                        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
                        System.out.println("1 For monitoring statistics on largest average 'Galamsey'.\n2 For monitoring statistics on largest 'Galamsey'.\n3 to view 'Galamsey' data based on colour values.\n4 For all observatories under observation \n0 to Go Back");
                        int chooseInfoType = scan.nextInt();

                        //Switch determines next task based on user's input in the sub menu.
                        switch (chooseInfoType) {
                            case 1:
                                // displays observatory with the largest average galamsey
                                try {
                                    System.out.println("\nThe observatory with Largest average 'Galamsey' is\n");
                                    System.out.println(Monitoring.getObservatoryWithLargestAverage().getName());
                                }catch(NullPointerException e){}
                                break;
                            case 2:
                                // displays highest galamsey color value recorded
                                System.out.println("\nHighest 'Galamsey' color value recorded.\n");
                                System.out.println(Monitoring.getLargestGalamseyColourValueEverRecorded());
                                break;
                            case 3:
                                // Filters galamsey events based on the vegetation colour values
                                System.out.println("\nSelect one of the options below");
                                System.out.println("1 view 'Galamsey' activities with color values greater than: ");
                                System.out.println("2 view 'Galamsey' events with color values less than: ");
                                System.out.println("3 view 'Galamsey' events with color values equal to: ");
                                int selectView = scan.nextInt();

                                switch (selectView){
                                    case 1:

                                        // Shows all "galamsey" events with vegetation colour values above a certain arbitrary value specified by the user
                                        do {
                                            System.out.println("\nInput minimum color value: ");
                                            int leastInstances = scan.nextInt();

                                            //If condition ensures that the arbitrary value is 1,2 or 3
                                            if(leastInstances > 0 && leastInstances <4) {
                                                System.out.println("\nThe following has 'Galamsey' values greater than " + leastInstances);
                                                for (Galamsey galam : Monitoring.ListOfGalamseysWithColourValueGreaterThan(leastInstances)) {
                                                    System.out.println(galam.toString());
                                                }
                                                break;
                                            }else {
                                                System.out.println("Invalid input: please input 1,2 or 3");
                                            }
                                        }while (true);

                                        break;
                                    case 2:
                                        // Shows all "galamsey" events with vegetation colour values below a certain arbitrary value specified by the user

                                        System.out.println("\nInput maximum color value: ");
                                        int maxColorValue = scan.nextInt();
                                        System.out.println("\nThe following has 'Galamsey' values less than " + maxColorValue);
                                        for (Galamsey galam : Monitoring.ListOfGalamseysWithColourValueLessThan(maxColorValue)){
                                            System.out.println(galam.toString());
                                        }
                                        break;
                                    case 3:
                                        //Shows all "galamsey" events with vegetation colour values equal to a certain arbitrary value specified by the user

                                        System.out.println("\nInput color value: ");
                                        int colorValue = scan.nextInt();
                                        System.out.println("\nThe following has 'Galamsey' values equal to " + colorValue);
                                        for (Galamsey galam : Monitoring.ListOfGalamseysWithColourValueEqualTo(colorValue)){
                                            System.out.println(galam.toString());
                                        }
                                        break;
                                    default:
                                        //Prints an error if program records wrong input from the user
                                        System.out.println("Invalid input, Please select an item in the menu");
                                        break;
                                }
                                break;
                            case 4:
                                //Shows all the current existing observatories
                                System.out.println("\nThe Current observatories include: ");
                                for (Observatory anObservatory: Monitoring.observatories){
                                    System.out.println(Monitoring.observatories.indexOf(anObservatory)+1 + " " + anObservatory.getName() + " observatory");
                                }

                                // Requests for user to select one of the observatories to view its details
                                System.out.println("\nSelect an observatory to view its details");
                                int selectOb = scan.nextInt();
                                System.out.println(" ");
                                System.out.println(Monitoring.observatories.get(selectOb-1).toString());

                                //Checks if observatory has no galamsey event recorded.
                                if (Monitoring.observatories.get(selectOb-1).getEvents().isEmpty()) {
                                    System.out.println("\nThis Observatory has no recorded 'Galamsey' events'");
                                }else {
                                    //Prints all galamsey events if observatory has galamsey events.
                                    for (Galamsey g : Monitoring.observatories.get(selectOb - 1).getEvents()) {
                                        System.out.println(g.toString());
                                    }
                                }

                            case 0:
                                break;
                            default:
                                //Prints an error if program records wrong input
                                System.out.println("Invalid input, Please select an item in the menu");
                                break;
                        }

                        //breaks while loop if user inputs 0.
                        if (chooseInfoType == 0) {
                            break;
                        }

                    }
                    break;
                case 0:
                    break;
                default:
                    //Prints an error if program records wrong input
                    System.out.println("Invalid input, Please select an item in the menu");
                    break;
            }

            //breaks while loop if user inputs 0.
            if(chooseInput == 0){
                break;
            }

        }
        
        scan.close();
        scan2.close();

    }
}
