package id.teambantu.bcmodel.collections;

public class Chat {
    private String id = "";
    private String userId = "";
    private String mitraId = "";
    private String driverId = " ";
    private long createdAt = System.currentTimeMillis();

    public Chat() {
    }

    public Chat(String id, String userId, String mitraId, String driverId, long createdAt) {
        this.id = id;
        this.userId = userId;
        this.mitraId = mitraId;
        this.driverId = driverId;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMitraId() {
        return mitraId;
    }

    public void setMitraId(String mitraId) {
        this.mitraId = mitraId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", mitraId='" + mitraId + '\'' +
                ", driverId='" + driverId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
