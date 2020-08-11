package id.teambantu.bcmodel.handler;

import com.google.firebase.storage.UploadTask;

public abstract class BCUploadFile {
    public abstract void onFailure(Exception e);
    public abstract void onSuccess(UploadTask.TaskSnapshot snapshot);
}
