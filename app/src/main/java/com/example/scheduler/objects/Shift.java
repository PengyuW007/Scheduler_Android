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

    private int pos;
    private int am_pm_night;// 0 = am, 1 = pm, 2 = night
    private int day;

    public Shift(int icon_number, int pos) {
        id = icon_number;
        busy = false;
    }

    public int getAm_pm_night() {
        int res = 0;
        if (pos % 3 == 0) {
            
        }

        return res;
    }


    public int getDay() {
        int res = 0;
        if (pos == 0 || pos == 1 || pos == 2) {
            res = 1;
        } else if (pos == 3 || pos == 4 || pos == 5) {
            res = 2;
        } else if (pos == 6 || pos == 7 || pos == 8) {
            res = 3;
        } else if (pos == 9 || pos == 10 || pos == 11) {
            res = 4;
        } else if (pos == 12 || pos == 13 || pos == 14) {
            res = 5;
        } else if (pos == 15 || pos == 16 || pos == 17) {
            res = 6;
        } else if (pos == 18 || pos == 19 || pos == 20) {
            res = 7;
        }
        return res;
    }//end getDay

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
}
