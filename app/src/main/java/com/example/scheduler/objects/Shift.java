package com.example.scheduler.objects;

/*****
 * Class: Shift
 *
 * Purpose: This class is to check the free of each day, each time slot
 *
 * Parameters:
 *             1. int: time, the time of the slot, morning, afternoon, or night
 *             2. boolean: checked, free of slot
 *
 *******/
public class Shift {
    private int id;
    private int am_pm_night;// 0 = am, 1 = pm, 2 = night
    private boolean busy;//free or busy, to show the status of the shift


    public Shift(int icon_number, int time) {
        id = icon_number;
        am_pm_night = time;
        busy = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAm_pm_night() {
        return am_pm_night;
    }

    public void setAm_pm_night(int am_pm_night) {
        this.am_pm_night = am_pm_night;
    }

    public boolean isChecked() {
        return busy;
    }

    public void setStatus(boolean free) {
        this.busy = free;
    }
}
