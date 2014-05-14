package org.schedulerjms.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by dSklyarenko on 14.05.14.
 */
public class TestPointRule {

    @Test
    public void testSetUniqueId() {
        PointRule pointRule = new PointRule();
        pointRule.setID(1);
        pointRule.setCategory("testCategory");
        String expected = "testCategory1";
        pointRule.setUniqueId();
        String actual = pointRule.getUniqueId();
        assertTrue(expected.equals(actual));
    }

}
