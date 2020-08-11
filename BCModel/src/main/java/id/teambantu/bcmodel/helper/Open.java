package id.teambantu.bcmodel.helper;

import id.teambantu.bcmodel.type.DayType;

public class Open {
    private String id = "";
    private DayType day = DayType.NONE;
    private Time openTime = new Time();

    public Open() {
    }

    public Open(String id, DayType day, Time openTime) {
        this.id = id;
        this.day = day;
        this.openTime = openTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DayType getDay() {
        return day;
    }

    public void setDay(DayType day) {
        this.day = day;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    @Override
    public String toString() {
        return "Open{" +
                "id='" + id + '\'' +
                ", day=" + day +
                ", openTime=" + openTime +
                '}';
    }
}
