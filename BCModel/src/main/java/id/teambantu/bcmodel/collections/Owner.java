package id.teambantu.bcmodel.collections;

import id.teambantu.bcmodel.helper.Location;

public class Owner {
    private String id = "";
    private String mitraId ="";
    private String name = "";
    private String email = "";
    private String phoneNumber = "";
    private String phoneToken = "";
    private Location location;
    private boolean active = true; // status for using application
    private long createdAt = System.currentTimeMillis();

    public Owner() {}

    public Owner(String id, String mitraId, String name, String email, String phoneNumber, String phoneToken, Location location, boolean active, long createdAt) {
        this.id = id;
        this.mitraId = mitraId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.phoneToken = phoneToken;
        this.location = location;
        this.active = active;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMitraId() {
        return mitraId;
    }

    public void setMitraId(String mitraId) {
        this.mitraId = mitraId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", mitraId='" + mitraId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneToken='" + phoneToken + '\'' +
                ", location=" + location +
                ", active=" + active +
                ", createdAt=" + createdAt +
                '}';
    }
}
