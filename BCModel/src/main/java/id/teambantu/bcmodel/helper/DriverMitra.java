package id.teambantu.bcmodel.helper;

public class DriverMitra {
    private String id = "";
    private String driverId = "";
    private boolean active = true;
    private long createdAt = System.currentTimeMillis();

    public DriverMitra() {
    }

    public DriverMitra(String id, String driverId, boolean active, long createdAt) {
        this.id = id;
        this.driverId = driverId;
        this.active = active;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "DriverMitra{" +
                "id='" + id + '\'' +
                ", driverId='" + driverId + '\'' +
                ", active=" + active +
                ", createdAt=" + createdAt +
                '}';
    }
}
