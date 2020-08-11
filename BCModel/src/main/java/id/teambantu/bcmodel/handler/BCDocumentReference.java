package id.teambantu.bcmodel.handler;

import com.google.firebase.firestore.DocumentReference;

public abstract class BCDocumentReference {
    public abstract void onDocumentChange(DocumentReference document);
}
