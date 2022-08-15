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
    private int id;//picture's id
    private boolean busy;//free or busy, to show the status of the shift

    private int am_pm_night;// 0 = am, 1 = pm, 2 = night
    private int day;

    public Shift(int icon_number, int pos) {
        id = icon_number;
        busy = false;
        setAm_pm_night(pos);
        setDay(pos);
    }

    public void setAm_pm_night(int pos) {
        if (pos % 3 == 0) {
            am_pm_night = 0;
        } else if (pos % 3 == 1) {
            am_pm_night = 1;
        } else if (pos % 3 == 2) {
            am_pm_night = 2;
        }
    }//end setAm_pm_night

    public void setDay(int pos) {
        if (pos == 0 || pos == 1 || pos == 2) {
            day = 1;
        } else if (pos == 3 || pos == 4 || pos == 5) {
            day = 2;
        } else if (pos == 6 || pos == 7 || pos == 8) {
            day = 3;
        } else if (pos == 9 || pos == 10 || pos == 11) {
            day = 4;
        } else if (pos == 12 || pos == 13 || pos == 14) {
            day = 5;
        } else if (pos == 15 || pos == 16 || pos == 17) {
            day = 6;
        } else if (pos == 18 || pos == 19 || pos == 20) {
            day = 7;
        }
    }//end setDay

    public boolean isChecked() {
        return busy;
    }

    public void setStatus(boolean free) {
        this.busy = free;
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

    public int getDay() {
        return day;
    }
}
