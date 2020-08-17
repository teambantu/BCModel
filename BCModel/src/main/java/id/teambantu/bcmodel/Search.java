package id.teambantu.bcmodel;

import androidx.annotation.Nullable;

import com.algolia.search.saas.AlgoliaException;
import com.algolia.search.saas.Client;
import com.algolia.search.saas.CompletionHandler;
import com.algolia.search.saas.Index;
import com.algolia.search.saas.Query;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.teambantu.bcmodel.collections.Mitra;
import id.teambantu.bcmodel.handler.BCMitraSearchListener;

public class Search {
    private static final String TAG = "Search";

    private static Client client() {
        return new Client("RXE4LY3LGG", "2d59905e8c8b127960644abe53e55031");
    }

    public static class Mitras {
        private static Index index() {
            return client().getIndex("MITRA");
        }

        public static void query(String query, final BCMitraSearchListener listener) {
            index().searchAsync(
                    new Query(query).setHitsPerPage(6),
                    new CompletionHandler() {
                        @Override
                        public void requestCompleted(@Nullable JSONObject jsonObject, @Nullable AlgoliaException e) {
                            if (e == null) {
                                try {
                                    List<Mitra> mitras = new ArrayList<>();
                                    for (int i = 0; i < jsonObject.getJSONArray("hits").length(); i++) {
                                        JSONObject jsonObject1 = jsonObject.getJSONArray("hits").getJSONObject(i);
                                        Gson gson = new Gson();
                                        Mitra mitra = gson.fromJson(jsonObject1.toString(), Mitra.class);
                                        mitras.add(mitra);
                                    }
                                    listener.onSuccess(mitras);
                                } catch (JSONException ex) {
                                    listener.onFailed(ex.getMessage());
                                }

                            } else listener.onFailed(e.getMessage());
                        }
                    });
        }
    }
}
