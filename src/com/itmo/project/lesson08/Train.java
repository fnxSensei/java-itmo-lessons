package com.itmo.project.lesson08;

public class Train extends Vehicle{
    private int countVagon;
    private boolean isClimateСontrol;

    public Train(String number, int maxSpeed, int countVagon, boolean isClimateСontrol ) {
        super(number, maxSpeed);
        this.countVagon=countVagon;
        this.isClimateСontrol=isClimateСontrol;
    }

    public int getCountVagon() {
        return countVagon;
    }

    public void setCountVagon(int countVagon) {
        this.countVagon = countVagon;
    }

    public boolean isClimateСontrol() {
        return isClimateСontrol;
    }
    public void changeClimateСontrol(){
       isClimateСontrol=!isClimateСontrol;
    }

    @Override
    public void repair() {
        if(countVagon<7 && countVagon>0) {
            if (wear>=2) wear-=2;
        } else {
            super.repair();
        }
    }
}
