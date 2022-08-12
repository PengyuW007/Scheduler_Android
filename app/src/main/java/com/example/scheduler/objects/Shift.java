package com.example.scheduler.objects;

//3
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
