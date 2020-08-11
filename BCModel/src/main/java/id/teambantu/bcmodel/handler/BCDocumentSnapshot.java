package id.teambantu.bcmodel.handler;

import com.google.firebase.firestore.DocumentSnapshot;

public abstract class BCDocumentSnapshot {
    public abstract void onDocumentChange(DocumentSnapshot snapshot);
}
