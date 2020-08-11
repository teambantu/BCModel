package id.teambantu.bcmodel.helper;

import android.annotation.SuppressLint;

public class Time {
    private int hour = 0;
    private int minute = 0;

    public Time() {}

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return (hour >= 10 ? hour : ("0" + hour)) + ":" +(minute >= 10 ? minute : ("0" + minute));
    }
}
