package id.teambantu.bcmodel.helper;

public class Location {
    private String name = "";
    private String address = "";
    private String detailAddress = "";
    private double latitude = 0;
    private double longitude = 0;
    private long createdAt = System.currentTimeMillis();

    public Location() {
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(String name, String address, String detailAddress, double latitude, double longitude, long createdAt) {
        this.name = name;
        this.address = address;
        this.detailAddress = detailAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", createdAt=" + createdAt +
                '}';
    }
}
