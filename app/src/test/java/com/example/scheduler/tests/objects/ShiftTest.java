package com.example.scheduler.tests.objects;

import com.example.scheduler.objects.Shift;

import junit.framework.TestCase;

import org.junit.Test;

public class ShiftTest extends TestCase {
    public ShiftTest(String args){
        super(args);
    }

    @Test
    public void testShiftCreation(){
        Shift s1 = new Shift(0,0);
        assertEquals(0,s1.getAm_pm_night());
    }

    @Test
    public void testShiftGetter(){
        Shift s1 = new Shift(0,0);
        assertEquals(0,s1.getAm_pm_night());
    }
}
