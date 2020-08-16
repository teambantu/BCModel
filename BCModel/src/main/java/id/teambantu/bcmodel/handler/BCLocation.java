package id.teambantu.bcmodel.handler;

import id.teambantu.bcmodel.helper.Location;

public abstract class BCLocation {
    public abstract void onGetLocation(Location location);
    public abstract void onFailded(String message);
}
