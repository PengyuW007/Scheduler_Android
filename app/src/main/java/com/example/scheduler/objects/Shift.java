package com.example.scheduler.objects;

/*****
 * Class: Shift
 *
 * Purpose: This class is to check the status of each day, each time slot
 *
 * Parameters:
 *             1. int: time, the time of the slot, morning, afternoon, or night
 *             2. boolean: checked, status of slot
 *
 *******/
public class Shift {
    private int am_pm_night;// 0 = am, 1 = pm, 2 = night
    private boolean status;//free or busy, to show the status of the shift

    public Shift(int time,boolean status){
        am_pm_night = time;
        this.status = status;
    }

    public int getAm_pm_night() {
        return am_pm_night;
    }

    public void setAm_pm_night(int am_pm_night) {
        this.am_pm_night = am_pm_night;
    }

    public boolean isChecked() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
