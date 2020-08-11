package id.teambantu.bcmodel.helper;

import id.teambantu.bcmodel.type.FeatureType;
import id.teambantu.bcmodel.type.ItemType;

public class Items {
    private String id = "";
    private ItemType type = NONE;
    private int count;

    public Items() {
    }

    public Items(String id, ItemType type, int count) {
        this.id = id;
        this.type = type;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", count=" + count +
                '}';
    }
}
