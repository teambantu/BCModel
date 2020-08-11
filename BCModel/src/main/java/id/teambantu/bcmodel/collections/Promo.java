package id.teambantu.bcmodel.collections;

import id.teambantu.bcmodel.type.DiscountType;
import id.teambantu.bcmodel.type.PromoType;

public class Promo {
    private String id = "";
    private String desc = "";
    private String imageUrl = "";
    private String title = "";
    private int availableCount = 0;
    private int maxDiscount = 0;
    private double discount = 0;
    private int minPurchasing = 0;
    private PromoType promoType = PromoType.NONE;
    private DiscountType discountType = DiscountType.NONE;
    private long dueDate = 0;
    private boolean active = false;
    private long createdTime = System.currentTimeMillis();

    public Promo() {
    }

    public Promo(String id, String desc, String imageUrl, String title, int availableCount, int maxDiscount, double discount, int minPurchasing, PromoType promoType, DiscountType discountType, long dueDate, boolean active, long createdTime) {
        this.id = id;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.title = title;
        this.availableCount = availableCount;
        this.maxDiscount = maxDiscount;
        this.discount = discount;
        this.minPurchasing = minPurchasing;
        this.promoType = promoType;
        this.discountType = discountType;
        this.dueDate = dueDate;
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

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(int maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getMinPurchasing() {
        return minPurchasing;
    }

    public void setMinPurchasing(int minPurchasing) {
        this.minPurchasing = minPurchasing;
    }

    public PromoType getPromoType() {
        return promoType;
    }

    public void setPromoType(PromoType promoType) {
        this.promoType = promoType;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
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

    @Override
    public String toString() {
        return "Promo{" +
                "id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", availableCount=" + availableCount +
                ", maxDiscount=" + maxDiscount +
                ", discount=" + discount +
                ", minPurchasing=" + minPurchasing +
                ", promoType=" + promoType +
                ", discountType=" + discountType +
                ", dueDate=" + dueDate +
                ", active=" + active +
                ", createdTime=" + createdTime +
                '}';
    }
}
