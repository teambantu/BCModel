package id.teambantu.bcmodel.collections;

import id.teambantu.bcmodel.helper.Location;

public class Driver {
    private String id = "";
    private String name = "";
    private String phoneNumber = "";
    private String phoneToken = "";
    private String mitraId = "";

    private Location location = new Location();

    private boolean active = false;     // status for picking an order
    private boolean enabled = false;    // status for using application
    private long createdAt = System.currentTimeMillis();

    public Driver() {
    }

    public Driver(String id, String name, String phoneNumber, String phoneToken, String mitraId, Location location, boolean active, boolean enabled, long createdAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.phoneToken = phoneToken;
        this.mitraId = mitraId;
        this.location = location;
        this.active = active;
        this.enabled = enabled;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneToken() {
        return phoneToken;
    }

    public void setPhoneToken(String phoneToken) {
        this.phoneToken = phoneToken;
    }

    public String getMitraId() {
        return mitraId;
    }

    public void setMitraId(String mitraId) {
        this.mitraId = mitraId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneToken='" + phoneToken + '\'' +
                ", mitraId='" + mitraId + '\'' +
                ", location=" + location +
                ", active=" + active +
                ", enabled=" + enabled +
                ", createdAt=" + createdAt +
                '}';
    }
}
