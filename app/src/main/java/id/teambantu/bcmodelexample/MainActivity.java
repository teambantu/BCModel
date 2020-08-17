package id.teambantu.bcmodelexample;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import id.teambantu.bcmodel.Search;
import id.teambantu.bcmodel.collections.Mitra;
import id.teambantu.bcmodel.handler.BCMitraSearchListener;
import id.teambantu.bcmodelexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Search.Mitras.query(binding.search.getText().toString(), new BCMitraSearchListener() {
                    @Override
                    public void onSuccess(List<Mitra> mitras) {
                        binding.result.setText(mitras.toString());
                    }

                    @Override
                    public void onFailed(String message) {
                        binding.result.setText(message);
                    }
                });
            }
        });
    }
}