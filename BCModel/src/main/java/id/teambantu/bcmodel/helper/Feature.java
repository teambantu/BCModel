package id.teambantu.bcmodel.helper;

import id.teambantu.bcmodel.type.FeatureType;

public class Feature {
    private String id = "";
    private String name= "";
    private FeatureType type = FeatureType.NONE;
    private long finishAt = 0;
    private double minOrder = 0;
    private long cost = 0;
    private long createdAt = System.currentTimeMillis();

    public Feature() {
    }

    public Feature(String id, String name, FeatureType type, long finishAt, double minOrder, long cost, long createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.finishAt = finishAt;
        this.minOrder = minOrder;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeatureType getType() {
        return type;
    }

    public void setType(FeatureType type) {
        this.type = type;
    }

    public long getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(long finishAt) {
        this.finishAt = finishAt;
    }

    public double getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(double minOrder) {
        this.minOrder = minOrder;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", finishAt=" + finishAt +
                ", minOrder=" + minOrder +
                ", cost=" + cost +
                ", createdAt=" + createdAt +
                '}';
    }
}
