package org.schedulerjms.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by dSklyarenko on 14.05.14.
 */
public class TestPeriodicRule {

    @Test
    public void testSetUniqueId() {
        PeriodicRule periodicRule = new PeriodicRule();
        periodicRule.setID(1);
        periodicRule.setCategory("testCategory");
        String expected = "testCategory1";
        periodicRule.setUniqueId();
        String actual = periodicRule.getUniqueId();
        assertTrue(expected.equals(actual));
    }

}
