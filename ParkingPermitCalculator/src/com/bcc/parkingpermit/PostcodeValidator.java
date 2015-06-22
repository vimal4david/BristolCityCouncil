/*
 * Coding test for Bristol City Council
 */

package com.bcc.parkingpermit;

/**
 *
 * @author vimaldavid
 * 
 * Class to validate the postcode and no of permits
 */


public class PostcodeValidator {

    public static String errorMessage;
    public static int noOfPermits;
    public static int postcodeNumber;
    public static int spaceIndex;

    public static boolean validatePostcode(String postcode) {

        //Removing leading spaces,trailing spaces and covert multiple spaces to single space. 
        postcode = postcode.replaceAll("^\\s+", "").replaceAll("\\s+$", "").replaceAll("[ ]+", " ");;

        //Checking input length
        if ((postcode.length() < 4)) {
            errorMessage = "** Invalid Postcode&permit : Entered value is too short **";
            return false;
        } else if (postcode.length() > 6) {
            errorMessage = "** Invalid Postcode&permit : Entered value is too long **";
            return false;
        }

        //Getting space index
        spaceIndex = postcode.indexOf(' ');
        if ((spaceIndex != 3 && spaceIndex != 4)) {
            errorMessage = "** Invalid Postcode&permit : No space between postcode and no of permits **";
            return false;
        }

        //Checking BS
        String postcode1 = postcode.substring(0, spaceIndex);
        if (!postcode1.substring(0, 2).equalsIgnoreCase("BS")) {
            errorMessage = "** The postcode must start with \"BS\" ** ";
            return false;
        }

        //Checking out code number
        try {
            postcodeNumber = Integer.parseInt(postcode.substring(2, spaceIndex));
            if (postcodeNumber < 1 || postcodeNumber > 19) {
                errorMessage = "** The out code number must be less than 19 **";
                return false;
            }
        } catch (Exception NumberFormatException) {
            errorMessage = "** The out code number must be less than 19 **";
            return false;
        }

        //Checking no of permits
        try {
            noOfPermits = Integer.parseInt(postcode.substring(spaceIndex + 1, postcode.length()));
            if (noOfPermits < 1 || noOfPermits > 3) {
                errorMessage = "** Maximum number of permits allowed is 3 **";
                return false;
            }
        } catch (Exception NumberFormatException) {
            errorMessage = "** Maximum number of permits allowed is 3 **";
            return false;
        }

        return true;
    }

}
