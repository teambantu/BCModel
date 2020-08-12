package id.teambantu.bcmodel;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import id.teambantu.bcmodel.collections.Chat;
import id.teambantu.bcmodel.collections.Driver;
import id.teambantu.bcmodel.collections.Mitra;
import id.teambantu.bcmodel.collections.News;
import id.teambantu.bcmodel.collections.Notification;
import id.teambantu.bcmodel.collections.Order;
import id.teambantu.bcmodel.collections.Owner;
import id.teambantu.bcmodel.collections.Promo;
import id.teambantu.bcmodel.collections.Slider;
import id.teambantu.bcmodel.collections.User;
import id.teambantu.bcmodel.handler.BCBoolean;
import id.teambantu.bcmodel.handler.BCDocumentReference;
import id.teambantu.bcmodel.handler.BCDocumentSnapshot;
import id.teambantu.bcmodel.handler.BCGetWithId;
import id.teambantu.bcmodel.handler.BCNearby;
import id.teambantu.bcmodel.handler.BCQuerySnapshot;
import id.teambantu.bcmodel.handler.BCUploadFile;
import id.teambantu.bcmodel.handler.OnGetPromoLocalListener;
import id.teambantu.bcmodel.handler.OnSavePromoLocalListener;
import id.teambantu.bcmodel.helper.Complain;
import id.teambantu.bcmodel.helper.DriverMitra;
import id.teambantu.bcmodel.helper.Facilities;
import id.teambantu.bcmodel.helper.Favorite;
import id.teambantu.bcmodel.helper.Invoice;
import id.teambantu.bcmodel.helper.Items;
import id.teambantu.bcmodel.helper.Location;
import id.teambantu.bcmodel.helper.Messages;
import id.teambantu.bcmodel.helper.Open;
import id.teambantu.bcmodel.helper.Review;
import id.teambantu.bcmodel.helper.Wallet;

import static android.content.Context.MODE_PRIVATE;

public class Database {

    private static final String USER = "USERS";
    private static final String MITRA = "MITRAS";
    private static final String CHAT = "CHATS";
    private static final String DRIVER = "DRIVERS";
    private static final String NEWS = "NEWS";
    private static final String NOTIF = "NOTIFICATIONS";
    private static final String ORDER = "ORDERS";
    private static final String PROMO = "PROMOS";
    private static final String OWNER = "OWNERS";
    private static final String SLIDER = "SLIDER";
    private static final String MESSAGE = "MESSAGES";
    private static final String COMPLAIN = "COMPLAIN";
    private static final String FAVORITE = "FAVORITE";
    private static final String FACILITIES = "FACILITIES";
    private static final String WALLET = "WALLET";
    private static final String INVOICE = "INVOICE";
    private static final String REVIEW = "REVIEW";
    private static final String OPEN = "OPEN";
    private static final String ITEMS = "ITEMS";


    public static class Local {
        private static SharedPreferences db(Activity activity) {
            return activity.getPreferences(MODE_PRIVATE);
        }

        private static void setStringData(Activity activity, String[][] data) {
            SharedPreferences.Editor editor = db(activity).edit();
            for (String[] s : data
            ) {
                editor.putString(s[0], s[1]);
            }
            editor.apply();
        }

        private static String getData(Activity activity, String key) {
            return db(activity).getString(key, "");
        }

        private static boolean isKey(Activity activity, String key) {
            return db(activity).contains(key);
        }

        private static void removeKey(Activity activity, String[] keys) {
            SharedPreferences.Editor editor = db(activity).edit();
            for (String s : keys
            ) {
                editor.remove(s);
            }
            editor.apply();
        }

        public static void savePromo(Activity activity, String id, OnSavePromoLocalListener listener) {
            setStringData(activity, new String[][]{{PROMO, id}});
            listener.onSaved(id);
        }

        public static void getPromoSaved(Activity activity, OnGetPromoLocalListener listener) {
            listener.onGet(getData(activity, PROMO));
        }
    }

    public static class Firebase {

        public static FirebaseAuth auth() {
            return FirebaseAuth.getInstance();
        }

        public static FirebaseUser currentUser() {
            return auth().getCurrentUser();
        }

        public static void addDocumentChangeListener(DocumentReference ref, final BCDocumentSnapshot listener) {
            ref.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                    if (error == null) {
                        listener.onDocumentChange(value);
                    } else Log.d("BCError", "onEvent: " + error.getMessage());
                }
            });
        }

        public static void addQueryChangeListener(CollectionReference ref, final BCQuerySnapshot listener) {
            ref.addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    if (error == null) {
                        listener.onQueryChange(value);
                    } else Log.d("BCError", "onEvent: " + error.getMessage());
                }
            });
        }

        public static void addQueryChangeListener(Query ref, final BCQuerySnapshot listener) {
            ref.addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                    if (error == null) {
                        listener.onQueryChange(value);
                    } else Log.d("BCError", "onEvent: " + error.getMessage());
                }
            });
        }

        public enum DBType {
            MITRA, PROMO, DRIVER, USER, NEWS, CHAT, NOTIF, ORDER, SLIDER
        }

        public static void getWithStringID(final List<String> ids, DocumentReference ref, final BCGetWithId listener){
            final List<DocumentSnapshot>[] result = new List[]{new ArrayList<>()};
            for (String id:
                    ids) {
                addDocumentChangeListener(ref, new BCDocumentSnapshot() {
                    @Override
                    public void onDocumentChange(DocumentSnapshot snapshot) {
                        List<DocumentSnapshot> tmp = new ArrayList<>();
                        for (DocumentSnapshot ds:
                                result[0]) {
                            if(!ds.getId().equals(snapshot.getId())){
                                tmp.add(ds);
                            }
                        }
                        result[0] = tmp;
                        result[0].add(snapshot);
                        if(result[0].size() == ids.size()){
                            listener.onGetAll(result[0]);
                        }
                    }
                });
            }
        }

        public static class Firestore {

            public final static String TAG = Firestore.class.getSimpleName();

            private static FirebaseFirestore db() {
                return FirebaseFirestore.getInstance();
            }

            public static CollectionReference user() {
                return db().collection(USER);
            }

            public static DocumentReference user(String id) {
                return user().document(id);
            }

            public static void addUser(User user, final BCBoolean listener) {
                user.setId(user.getPhoneNumber());
                user(user.getId()).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        listener.onSuccess(task.isSuccessful());
                    }
                });
            }

            public static CollectionReference mitra() {
                return db().collection(MITRA);
            }

            public static DocumentReference mitra(String id) {
                return mitra().document(id);
            }

            public static void addMitra(Mitra mitra, final BCBoolean listener) {
                mitra.setId(currentUser().getUid());
                mitra(mitra.getId()).set(mitra).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        listener.onSuccess(task.isSuccessful());
                    }
                });
            }

            public static CollectionReference owner() {
                return db().collection(OWNER);
            }

            public static DocumentReference owner(String id) {
                return owner().document(id);
            }

            public static void addOwner(Owner owner, final BCBoolean listener) {
                owner.setId(owner.getPhoneNumber());
                owner(owner.getId()).set(owner).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        listener.onSuccess(task.isSuccessful());
                    }
                });
            }

            public static CollectionReference driver() {
                return db().collection(DRIVER);
            }

            public static DocumentReference driver(String id) {
                return owner().document(id);
            }

            public static void addDriver(Driver driver, final BCBoolean listener) {
                driver.setId(driver.getPhoneNumber());
                owner(driver.getId()).set(driver).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        listener.onSuccess(task.isSuccessful());
                    }
                });
            }


            public static CollectionReference notification(String id, DBType type) {
                if (type.equals(DBType.USER)) return user(id).collection(NOTIF);
                else if (type.equals(DBType.DRIVER)) return driver(id).collection(NOTIF);
                else return owner(id).collection(NOTIF);
            }

            public static DocumentReference notification(String id, String idNotif, DBType type) {
                return notification(id, type).document(idNotif);
            }

            public static void addNotification(final String id, final Notification notification, final DBType type, final BCDocumentReference listener) {
                notification(id, type).add(notification).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            notification(id, task.getResult().getId(), type).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addNotification: " + task.getException());
                            listener.onDocumentChange(null);
                        }

                    }
                });
            }

            public static CollectionReference slider() {
                return db().collection(SLIDER);
            }

            public static DocumentReference slider(String id) {
                return slider().document(id);
            }

            public static void addSlider(final Slider slider, final BCDocumentReference listener) {
                slider().add(slider).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            slider(task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addSlider: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference news() {
                return db().collection(NEWS);
            }

            public static DocumentReference news(String id) {
                return news().document(id);
            }

            public static void addNews(final News news, final BCDocumentReference listener) {
                news().add(news).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            news(task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addNews: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference chat() {
                return db().collection(CHAT);
            }

            public static DocumentReference chat(String id) {
                return chat().document(id);
            }

            public static void addChat(final Chat chat, final BCDocumentReference listener) {
                news().add(chat).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            news(task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addChat: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference messages(String id) {
                return chat(id).collection(MESSAGE);
            }

            public static DocumentReference messages(String id, String idMessage) {
                return messages(id).document(idMessage);
            }

            public static void addMessages(final String id, final Messages messages, final BCDocumentReference listener) {
                messages(id).add(messages).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            messages(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addMessages: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference order() {
                return db().collection(ORDER);
            }

            public static DocumentReference order(String id) {
                return order().document(id);
            }

            public static void addOrder(final Order order, final BCDocumentReference listener) {
                order().add(order).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            order(task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addOrder: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference promo() {
                return db().collection(PROMO);
            }

            public static DocumentReference promo(String id) {
                return promo().document(id);
            }

            public static void addPromo(final Promo promo, final BCDocumentReference listener) {
                promo().add(promo).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            promo(task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addPromo: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference complain(String id, DBType type) {
                return type.equals(DBType.USER) ? user(id).collection(COMPLAIN) : mitra(id).collection(COMPLAIN);
            }

            public static DocumentReference complain(String id, String idComplain, DBType type) {
                return complain(id, type).document(idComplain);
            }

            public static void addComplain(final String id, Complain complain, final DBType type, final BCDocumentReference listener) {
                complain(id, type).add(complain).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            complain(id, task.getResult().getId(), type).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addComplain: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference favorite(String id) {
                return user(id).collection(FAVORITE);
            }

            public static DocumentReference favorite(String id, String idFavorite) {
                return favorite(id).document(idFavorite);
            }

            public static void addFavorite(final String id, Favorite favorite, final BCDocumentReference listener) {
                favorite(id).add(favorite).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            favorite(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addFavorite: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference driverMitra(String id) {
                return mitra(id).collection(DRIVER);
            }

            public static DocumentReference driverMitra(String id, String idDriverMitra) {
                return driverMitra(id).document(idDriverMitra);
            }

            public static void addDriverMitra(final String id, DriverMitra driverMitra, final BCDocumentReference listener) {
                driverMitra(id).add(driverMitra).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            driverMitra(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addDriverMitra: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference facilities(String id) {
                return mitra(id).collection(FACILITIES);
            }

            public static DocumentReference facilities(String id, String idFacilities) {
                return facilities(id).document(idFacilities);
            }

            public static void addFacilities(final String id, Facilities facilities, final BCDocumentReference listener) {
                facilities(id).add(facilities).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            facilities(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addFacilities: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference orderFacilities(String id) {
                return order(id).collection(FACILITIES);
            }

            public static DocumentReference orderFacilities(String id, String idOrderFacilities) {
                return orderFacilities(id).document(idOrderFacilities);
            }

            public static void addOrderFacilities(final String id, Facilities facilities, final BCDocumentReference listener) {
                orderFacilities(id).add(facilities).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            orderFacilities(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addOrderFacilities: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference orderItemsFacilities(String id, String idFacilities) {
                return orderFacilities(id, idFacilities).collection(ITEMS);
            }

            public static DocumentReference orderItemsFacilities(String id, String idFacilities, String idItems) {
                return orderItemsFacilities(id, idFacilities).document(idItems);
            }

            public static void addOrderItemsFacilities(final String id, final String idFacilities, Items items, final BCDocumentReference listener) {
                orderItemsFacilities(id,idFacilities).add(items).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            orderItemsFacilities(id, idFacilities, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addOrderItemsFacilities: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference wallet(String id) {
                return mitra(id).collection(WALLET);
            }

            public static DocumentReference wallet(String id, String idWallet) {
                return wallet(id).document(idWallet);
            }

            public static void addWallet(final String id, Wallet wallet, final BCDocumentReference listener) {
                wallet(id).add(wallet).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            wallet(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addWallet: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference invoice(String id) {
                return mitra(id).collection(INVOICE);
            }

            public static DocumentReference invoice(String id, String idInvoice) {
                return invoice(id).document(idInvoice);
            }

            public static void addInvoice(final String id, Invoice invoice, final BCDocumentReference listener) {
                invoice(id).add(invoice).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            invoice(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addInvoice: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference review(String id) {
                return mitra(id).collection(REVIEW);
            }

            public static DocumentReference review(String id, String idInvoice) {
                return review(id).document(idInvoice);
            }

            public static void addReview(final String id, Review review, final BCDocumentReference listener) {
                review(id).add(review).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            review(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addReview: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

            public static CollectionReference open(String id) {
                return mitra(id).collection(OPEN);
            }

            public static DocumentReference open(String id, String idOpen) {
                return open(id).document(idOpen);
            }

            public static void addOpen(final String id, Open open, final BCDocumentReference listener) {
                open(id).add(open).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful()) {
                            open(id, task.getResult().getId()).update("id", task.getResult().getId());
                            listener.onDocumentChange(task.getResult());
                        } else {
                            Log.d(TAG, "addOpen: " + task.getException());
                            listener.onDocumentChange(null);
                        }
                    }
                });
            }

        }

        public static class Realtime{
            private static FirebaseDatabase db(){return FirebaseDatabase.getInstance();}
            public static DatabaseReference availableMitra(){return db().getReference(MITRA);}
            public static DatabaseReference availableDriver(){return db().getReference(DRIVER);}
        }

        public static class Storage{
            private static FirebaseStorage db(){return FirebaseStorage.getInstance();}
            public static StorageReference storageRef() {return  db().getReference();}
            public static StorageReference ktp(){return storageRef().child("KTP");}
            public static StorageReference mitraImage(){return storageRef().child(MITRA);}
            public static StorageReference complain(){return storageRef().child(COMPLAIN);}
            public static StorageReference chat(){return storageRef().child(CHAT);}
            public static StorageReference invoice(){return storageRef().child(INVOICE);}
            public static StorageReference notification(){return storageRef().child(NOTIF);}
            public static StorageReference promo(){return storageRef().child(PROMO);}
            public static StorageReference news(){return storageRef().child(NEWS);}
            public static StorageReference slider(){return storageRef().child(SLIDER);}
            public static void upload(byte[] file, StorageReference ref, final BCUploadFile listener){
                UploadTask uploadTask = ref.putBytes(file);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        listener.onFailure(e);
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot snapshot) {
                        listener.onSuccess(snapshot);
                    }
                });
            }

            public static void upload(InputStream stream, StorageReference ref, final BCUploadFile listener){
                UploadTask uploadTask = ref.putStream(stream);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        listener.onFailure(e);
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot snapshot) {
                        listener.onSuccess(snapshot);
                    }
                });
            }

            public static void upload(Uri uri, StorageReference ref, final BCUploadFile listener){
                UploadTask uploadTask = ref.putFile(uri);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        listener.onFailure(e);
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot snapshot) {
                        listener.onSuccess(snapshot);
                    }
                });
            }

            public static void delete(StorageReference ref, final BCBoolean listener){
                ref.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        listener.onSuccess(true);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        listener.onSuccess(false);
                    }
                });
            }

        }
    }

    public static class Maps{
        private static GeoFire fire(DatabaseReference ref){return new GeoFire(ref);}
        public static void searchNearby(DatabaseReference ref, GeoLocation center, double radius, final BCNearby nearby){
            fire(ref).queryAtLocation(center, radius).addGeoQueryEventListener(new GeoQueryEventListener() {
                HashMap<String, String> data = new HashMap<>();
                @Override
                public void onKeyEntered(String key, GeoLocation location) {
                    data.put(key, key);
                }

                @Override
                public void onKeyExited(String key) {
                    data.remove(key);
                }

                @Override
                public void onKeyMoved(String key, GeoLocation location) {

                }

                @Override
                public void onGeoQueryReady() {
                    List<String> near = new ArrayList<>(data.values());
                    nearby.onNearby(near);
                }

                @Override
                public void onGeoQueryError(DatabaseError error) {

                }
            });
        }
        public static void addMitraMaps(String id, Location location){
            fire(Firebase.Realtime.availableMitra()).setLocation(id, new GeoLocation(location.getLatitude(), location.getLongitude()));
        }
        public static void addDriverMaps(String id, Location location){
            fire(Firebase.Realtime.availableDriver()).setLocation(id, new GeoLocation(location.getLatitude(), location.getLongitude()));
        }
    }
}
