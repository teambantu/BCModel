package id.teambantu.bcmodel.collections;

import java.util.ArrayList;
import java.util.List;

import id.teambantu.bcmodel.helper.Location;
import id.teambantu.bcmodel.helper.Open;

public class Mitra {
    private String id = "";
    private String name = "";
    private String detail = "";
    private String imageUrl = "";
    private String ktpUrl = "";
    private Location location = new Location();
    private long totalIncome = 0;
    private long incomeThisMount = 0;
    private long invoice = 0;
    private int costPerKm = 0 ;
    private float rating = 0;
    private float popularity = 0 ;
    private boolean enabled = false; // status for using application
    private boolean online = false; // status for picking an order
    private long createdAt = System.currentTimeMillis();

    public Mitra() {
    }

    public Mitra(String id, String name, String detail, String imageUrl, String ktpUrl, Location location, long totalIncome, long incomeThisMount, long invoice, int costPerKm, float rating, float popularity, boolean enabled, boolean online, long createdAt) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.imageUrl = imageUrl;
        this.ktpUrl = ktpUrl;
        this.location = location;
        this.totalIncome = totalIncome;
        this.incomeThisMount = incomeThisMount;
        this.invoice = invoice;
        this.costPerKm = costPerKm;
        this.rating = rating;
        this.popularity = popularity;
        this.enabled = enabled;
        this.online = online;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getKtpUrl() {
        return ktpUrl;
    }

    public void setKtpUrl(String ktpUrl) {
        this.ktpUrl = ktpUrl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public long getIncomeThisMount() {
        return incomeThisMount;
    }

    public void setIncomeThisMount(long incomeThisMount) {
        this.incomeThisMount = incomeThisMount;
    }

    public long getInvoice() {
        return invoice;
    }

    public void setInvoice(long invoice) {
        this.invoice = invoice;
    }

    public int getCostPerKm() {
        return costPerKm;
    }

    public void setCostPerKm(int costPerKm) {
        this.costPerKm = costPerKm;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Mitra{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", ktpUrl='" + ktpUrl + '\'' +
                ", location=" + location +
                ", totalIncome=" + totalIncome +
                ", incomeThisMount=" + incomeThisMount +
                ", invoice=" + invoice +
                ", costPerKm=" + costPerKm +
                ", rating=" + rating +
                ", popularity=" + popularity +
                ", enabled=" + enabled +
                ", online=" + online +
                ", createdAt=" + createdAt +
                '}';
    }
}
