package id.teambantu.bcmodel.handler;

import com.google.firebase.firestore.QuerySnapshot;

public abstract class BCQuerySnapshot {
    public abstract void onQueryChange(QuerySnapshot value);
}
