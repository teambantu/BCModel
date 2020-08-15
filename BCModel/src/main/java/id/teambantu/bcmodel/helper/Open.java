package id.teambantu.bcmodel.helper;

import id.teambantu.bcmodel.type.DayType;

public class Open {
    private String id = "";
    private DayType day = DayType.NONE;
    private Time openTime = new Time();
    private Time closeTime = new Time();

    public Open() {
    }

    public Open(String id, DayType day, Time openTime, Time closeTime) {
        this.id = id;
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
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

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "Open{" +
                "id='" + id + '\'' +
                ", day=" + day +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}
