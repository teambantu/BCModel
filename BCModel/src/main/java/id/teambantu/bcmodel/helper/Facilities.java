package id.teambantu.bcmodel.helper;

import java.util.List;

import id.teambantu.bcmodel.type.FeatureType;

public class Facilities {
    private String id = "";
    private String featureId = "";
    private double weight;
    private long totalCost;

    public Facilities() {
    }

    public Facilities(String id, String featureId, double weight, long totalCost) {
        this.id = id;
        this.featureId = featureId;
        this.weight = weight;
        this.totalCost = totalCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String featureId) {
        this.featureId = featureId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Facilities{" +
                "id='" + id + '\'' +
                ", featureId='" + featureId + '\'' +
                ", weight=" + weight +
                ", totalCost=" + totalCost +
                '}';
    }
}
