package id.teambantu.bcmodel.handler;

import java.util.List;

import id.teambantu.bcmodel.collections.Mitra;

public abstract class BCMitraSearchListener {
    public abstract void onSuccess(List<Mitra> mitras);

    public abstract void onFailed(String message);
}
