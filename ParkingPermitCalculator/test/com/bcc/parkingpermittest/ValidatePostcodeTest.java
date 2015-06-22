/*
 * Coding test for Bristol City Council
 */
package com.bcc.parkingpermittest;

import com.bcc.parkingpermit.PostcodeValidator;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author vimaldavid
 *
 * Postcode Validator class test
 */

public class ValidatePostcodeTest {

    List<String> postcodes = new ArrayList<>();

    @Test
    //Method to test valid postcode and permit values
    public void PostcodePermitTest() {
        postcodes.add("  BS1   1  ");
        postcodes.add("BS1 1");
        postcodes.add("BS01 1");
        postcodes.add("BS19 3");
        for (String postcode : postcodes) {
            assertEquals(true, PostcodeValidator.validatePostcode(postcode));
        }
        postcodes.clear();
    }

    @Test
    //Method to test invalid postcode and permit values
    public void FailedPostcodePermitTest() {
        postcodes.add("hello");
        postcodes.add("DA1 1");
        postcodes.add("BS 1 1");
        postcodes.add("BS20 1");
        postcodes.add("BS1 4");
        for (String postcode : postcodes) {
            assertEquals(false, PostcodeValidator.validatePostcode(postcode));
        }
        postcodes.clear();
    }

}
