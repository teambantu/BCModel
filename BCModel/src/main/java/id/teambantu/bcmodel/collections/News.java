package id.teambantu.bcmodel.collections;

public class News {
    private String id = "";
    private String desc = "";
    private String imageUrl = "";
    private String title = "";
    private boolean active = false;
    private long createdTime = System.currentTimeMillis();

    public News() {
    }

    public News(String id, String desc, String imageUrl, String title, boolean active, long createdTime) {
        this.id = id;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.title = title;
        this.active = active;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
}
