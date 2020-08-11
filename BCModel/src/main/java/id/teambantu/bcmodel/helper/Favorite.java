package id.teambantu.bcmodel.helper;

public class Favorite {
    private String id = "";
    private String mitraId = "";
    private long createdAt = System.currentTimeMillis();

    public Favorite() {
    }

    public Favorite(String id, String mitraId, long createdAt) {
        this.id = id;
        this.mitraId = mitraId;
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

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "id='" + id + '\'' +
                ", mitraId='" + mitraId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
