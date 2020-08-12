package id.teambantu.bcmodel.handler;

import android.net.Uri;

import com.google.firebase.storage.UploadTask;

public abstract class BCUploadFile {
    public abstract void onFailure(Exception e);
    public abstract void onSuccess(Uri uri);
}
