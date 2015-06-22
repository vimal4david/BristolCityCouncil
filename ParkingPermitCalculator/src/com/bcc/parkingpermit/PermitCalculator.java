/*
 * Coding test for Bristol City Council
 */
package com.bcc.parkingpermit;

/**
 *
 * @author vimaldavid
 *
 * Class to calculate the permit.
 */
public class PermitCalculator {

    private static double standardPermitAmount;
    private static double finalPermitAmount;
    public static String parkingPermitSummary;
    private static final String singleLine = "---------------------------------";
    private static final String doubleLine = "=================================";

    public static double calculateParkingPermit(int postcodeNumber, int noOfPermits) {
        System.out.println(" \n---- PARKING PERMIT CHARGES -----");

        if ((postcodeNumber >= 1 && postcodeNumber <= 19) && (noOfPermits >= 1 && noOfPermits <= 3)) {
            standardPermitAmount = 100;
            finalPermitAmount = 0;
            System.out.println("Standard Permit Amount      : " + standardPermitAmount);

            //Add Premium Charges 
            if (postcodeNumber >= 1 && postcodeNumber <= 3) {
                System.out.println("Additional Premium Charge   : 25");
                standardPermitAmount = standardPermitAmount + 25.0;
                System.out.println("New Standard Permit Amount  : " + standardPermitAmount);
            }
            System.out.println(singleLine);

            //Calculate Parking Permit
            for (int i = 1; i <= noOfPermits; i++) {
                finalPermitAmount = finalPermitAmount + standardPermitAmount;
                //Add Discount
                if (i == 2 || i == 3) {
                    finalPermitAmount = finalPermitAmount - (standardPermitAmount * 0.25);
                }
                System.out.println((i == 2 || i == 3) ? i + " Permit Charge :" + (standardPermitAmount * 0.75) + "( 25% reduction )" : i + " Permit Charge :" + standardPermitAmount);

            }
            System.out.println(doubleLine + "\nTotal Charges : " + finalPermitAmount + "\n" + doubleLine);

        } else {
            System.out.println("Entered value is invalid");
        }
        return finalPermitAmount;

    }

}
