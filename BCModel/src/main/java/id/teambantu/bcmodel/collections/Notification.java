package id.teambantu.bcmodel.collections;

import id.teambantu.bcmodel.type.SenderType;
import id.teambantu.bcmodel.type.TargetType;

public class Notification {
    private String id = "";
    private String title = "";
    private String message = "";
    private String imageUrl = "";

    private SenderType senderType = SenderType.NONE;
    private String senderData = "";

    private TargetType targetType = TargetType.NONE;
    private String targetData = "";

    private boolean enabled = true; // is can read again
    private boolean read = false; // status read
    private long createdAt = System.currentTimeMillis();

    public Notification() {
    }

    public Notification(String id, String title, String message, String imageUrl, SenderType senderType, String senderData, TargetType targetType, String targetData, boolean enabled, boolean read, long createdAt) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.imageUrl = imageUrl;
        this.senderType = senderType;
        this.senderData = senderData;
        this.targetType = targetType;
        this.targetData = targetData;
        this.enabled = enabled;
        this.read = read;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public SenderType getSenderType() {
        return senderType;
    }

    public void setSenderType(SenderType senderType) {
        this.senderType = senderType;
    }

    public String getSenderData() {
        return senderData;
    }

    public void setSenderData(String senderData) {
        this.senderData = senderData;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public String getTargetData() {
        return targetData;
    }

    public void setTargetData(String targetData) {
        this.targetData = targetData;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", senderType=" + senderType +
                ", senderData='" + senderData + '\'' +
                ", targetType=" + targetType +
                ", targetData='" + targetData + '\'' +
                ", enabled=" + enabled +
                ", read=" + read +
                ", createdAt=" + createdAt +
                '}';
    }
}
