package id.teambantu.bcmodel.handler;

import com.google.firebase.firestore.DocumentSnapshot;

public abstract class BCDBTask {
    public abstract void onSuccess(DocumentSnapshot document);
}
