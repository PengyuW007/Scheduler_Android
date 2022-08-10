package com.example.scheduler.business;

public class Checked {
    private boolean isChecked;

    public Checked(boolean isChecked){
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked){
        isChecked = checked;
    }
}
