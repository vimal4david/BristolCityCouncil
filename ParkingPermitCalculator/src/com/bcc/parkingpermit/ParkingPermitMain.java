/*
 * Coding test for Bristol City Council
 */

package com.bcc.parkingpermit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author vimaldavid
 * 
 * Main Class
 */
public class ParkingPermitMain {

    private static int choice = 0;
    private static String postcode = "";
    private static String choiceOption;
    private static final String postcodeQuestion = "\nEnter the outcode and no of permits(Eg: CalculatePermit BS1 2) ? \n"
                                             + "CALCULATE PERMIT : ";

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("**** BRISTOL CITY COUNCIL ****");

        while (choice <= 3) {
            System.out.println("\n---- LIST OF OPERATIONS ----"
                    + "\n1. Calculate Parking Permit"
                    + "\n2. Help"
                    + "\n3. Exit");

            System.out.println("Enter your choice : ");
            //Validating the choice
            choiceOption = reader.readLine();
            String regex = "^[1-3]";
            while (!choiceOption.matches(regex)) {
                System.out.println("Choice should be a number between 1 and 3");
                choiceOption = reader.readLine();
            }
            choice = Integer.parseInt(choiceOption);

            switch (choice) {
                case 1:
                    System.out.println("\n---- CALCULATING PARKING PERMIT ----");
                    //GETTING THE POSTCODE
                    System.out.print(postcodeQuestion);
                    postcode = reader.readLine();

                    //VALIDATE POSTCODE
                    while (!PostcodeValidator.validatePostcode(postcode)) {
                        System.out.print("\n"+PostcodeValidator.errorMessage + postcodeQuestion);
                        postcode = reader.readLine();
                    }
                    
                    //CALCULATE PERMIT
                    PermitCalculator.calculateParkingPermit(PostcodeValidator.postcodeNumber, PostcodeValidator.noOfPermits);
                    break;
                case 2:
                    //GETTING SUPPORTING INFORMATION
                    System.out.println(SupportingInformation.printSupporintInformation());
                    break;
                case 3:
                    //EXIT
                    System.out.println("Exit");
                default:
                    return;
            }

        }

    }

}
