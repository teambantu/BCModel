package id.teambantu.bcmodel.handler;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public abstract class BCGetWithId {
    public abstract void onGetAll(List<DocumentSnapshot> documentSnapshots);
}
