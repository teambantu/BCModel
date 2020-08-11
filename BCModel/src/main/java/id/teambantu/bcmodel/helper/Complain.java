package id.teambantu.bcmodel.helper;

import id.teambantu.bcmodel.type.ComplainStatusType;
import id.teambantu.bcmodel.type.ComplainType;

public class Complain {
    private String id = "";
    private String userId = "";
    private String mitraId= "";
    private String orderId= "";
    private String message= "";
    private String imageUrl= "";
    private ComplainType type = ComplainType.NONE;
    private ComplainStatusType status = ComplainStatusType.NONE;
    private long createdAt = System.currentTimeMillis();


    public Complain() {
    }

    public Complain(String id, String userId, String mitraId, String orderId, String message, String imageUrl, ComplainType type, ComplainStatusType status, long createdAt) {
        this.id = id;
        this.userId = userId;
        this.mitraId = mitraId;
        this.orderId = orderId;
        this.message = message;
        this.imageUrl = imageUrl;
        this.type = type;
        this.status = status;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public ComplainType getType() {
        return type;
    }

    public void setType(ComplainType type) {
        this.type = type;
    }

    public ComplainStatusType getStatus() {
        return status;
    }

    public void setStatus(ComplainStatusType status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Complain{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", mitraId='" + mitraId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", message='" + message + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
