package id.teambantu.bcmodel.collections;

import id.teambantu.bcmodel.helper.Location;
import id.teambantu.bcmodel.type.StatusType;

public class Order {
    private String id = "";
    private String userId = "";
    private String mitraId = "";
    private String promoId = "";
    private String chatId = "";
    private StatusType orderStatus = StatusType.NONE;
    private long pickupDate = 0;
    private Location pickupLocation = new Location();
    private String notes = "";
    private double deliveryCost = 0;
    private double totalCost = 0;
    private long createdAt = System.currentTimeMillis();

    public Order() {
    }

    public Order(String id, String userId, String mitraId, String promoId, String chatId, StatusType orderStatus, long pickupDate, Location pickupLocation, String notes, double deliveryCost, double totalCost, long createdAt) {
        this.id = id;
        this.userId = userId;
        this.mitraId = mitraId;
        this.promoId = promoId;
        this.chatId = chatId;
        this.orderStatus = orderStatus;
        this.pickupDate = pickupDate;
        this.pickupLocation = pickupLocation;
        this.notes = notes;
        this.deliveryCost = deliveryCost;
        this.totalCost = totalCost;
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

    public String getPromoId() {
        return promoId;
    }

    public void setPromoId(String promoId) {
        this.promoId = promoId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public StatusType getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(StatusType orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(long pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", mitraId='" + mitraId + '\'' +
                ", promoId='" + promoId + '\'' +
                ", chatId='" + chatId + '\'' +
                ", orderStatus=" + orderStatus +
                ", pickupDate=" + pickupDate +
                ", pickupLocation=" + pickupLocation +
                ", notes='" + notes + '\'' +
                ", deliveryCost=" + deliveryCost +
                ", totalCost=" + totalCost +
                ", createdAt=" + createdAt +
                '}';
    }
}
