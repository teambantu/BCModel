package id.teambantu.bcmodel.collections;

import id.teambantu.bcmodel.type.SenderType;
import id.teambantu.bcmodel.type.SliderType;
import id.teambantu.bcmodel.type.TargetType;

public class Slider {
    private String id = "";
    private String imageUrl = "";
    private String idTarget = "";
    private boolean active = false;
    private SliderType type = SliderType.NONE;
    private long createdTime = System.currentTimeMillis();

    public Slider() {
    }

    public Slider(String id, String imageUrl, String idTarget, boolean active, SliderType type, long createdTime) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.idTarget = idTarget;
        this.active = active;
        this.type = type;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIdTarget() {
        return idTarget;
    }

    public void setIdTarget(String idTarget) {
        this.idTarget = idTarget;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public SliderType getType() {
        return type;
    }

    public void setType(SliderType type) {
        this.type = type;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Slider{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", idTarget='" + idTarget + '\'' +
                ", active=" + active +
                ", type=" + type +
                ", createdTime=" + createdTime +
                '}';
    }
}
