package id.teambantu.bcmodel.helper;

public class Review {
    private String id = "";
    private String userId = "";
    private String mitraId = "";
    private String orderId = "";
    private String review = "";
    private int rating = 0 ;
    private long createdAt = System.currentTimeMillis();

    public Review() {
    }

    public Review(String id, String userId, String mitraId, String orderId, String review, int rating, long createdAt) {
        this.id = id;
        this.userId = userId;
        this.mitraId = mitraId;
        this.orderId = orderId;
        this.review = review;
        this.rating = rating;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", mitraId='" + mitraId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                '}';
    }
}
