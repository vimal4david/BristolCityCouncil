/*
 * Coding test for Bristol City Council
 */

package com.bcc.parkingpermittest;

import com.bcc.parkingpermit.PermitCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author vimaldavid
 *
 * Permit calculator class test
 */

public class PermitCalulatorTest {

    @Test
    //Method to test permit calculation
    public void PermitCaluculatorTest() {
        for (int noOfPermits = 1; noOfPermits <= 3; noOfPermits++) {
            for (int postcodeNumber = 1; postcodeNumber <= 19; postcodeNumber++) {
                double Amount = PermitCalculator.calculateParkingPermit(postcodeNumber, noOfPermits);
                if (postcodeNumber <= 3) {
                    if (Amount == 125) {
                        assertEquals(1, noOfPermits);
                    } else if (Amount == 218.75) {
                        assertEquals(2, noOfPermits);
                    } else if (Amount == 218.75) {
                        assertEquals(3, noOfPermits);
                    }
                } else {
                    if (Amount == 100) {
                        assertEquals(1, noOfPermits);
                    } else if (Amount == 175) {
                        assertEquals(2, noOfPermits);
                    } else if (Amount == 250) {
                        assertEquals(3, noOfPermits);
                    }

                }
            }
        }

    }

}
