/*
 * Coding test for Bristol City Council
 */

package com.bcc.parkingpermit;

/**
 *
 * @author vimaldavid
 *
 * Class to print supporting information.
 */

public class SupportingInformation {

    public static String printSupporintInformation() {
        String s = "------ HELP ---------\n"
                + "* Permits are only available for out codes starting with letters BS .\n"
                + "* Permits are only available for out codes with numbers less than 20.\n"
                + "* Standard permit is priced at £100.\n"
                + "* Additional premium charge of £25 will be added to out codes BS1, BS2 and BS3.\n"
                + "* Maximum of 3 permits available at a time.\n"
                + "* Additional (ie: second and third) permits have a 25% reduction in price.\n"
                + "* To calculate the permit charges enter out code and quantity as \"BS1 2\".\n";
        return s;
    }

}
