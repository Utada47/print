package com.example.mid13120240038;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    RadioGroup radioGroup;
    TextView txtHasil;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        radioGroup = findViewById(R.id.radioGroup);
        txtHasil = findViewById(R.id.txtHasil);
        btnClear = findViewById(R.id.btnClear);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hitung();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        edt1.addTextChangedListener(textWatcher);
        edt2.addTextChangedListener(textWatcher);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> hitung());

        btnClear.setOnClickListener(v -> {
            edt1.setText("");
            edt2.setText("");
            radioGroup.clearCheck();
            txtHasil.setText("Hasil Perhitungan");
        });
    }

    private void hitung() {

        String a = edt1.getText().toString();
        String b = edt2.getText().toString();

        if (a.isEmpty() || b.isEmpty()) {
            return;
        }

        double nilai1 = Double.parseDouble(a);
        double nilai2 = Double.parseDouble(b);

        double hasil = 0;

        int selected = radioGroup.getCheckedRadioButtonId();

        if (selected == R.id.rbTambah) {
            hasil = nilai1 + nilai2;
        }

        else if (selected == R.id.rbKurang) {
            hasil = nilai1 - nilai2;
        }

        else if (selected == R.id.rbKali) {
            hasil = nilai1 * nilai2;
        }

        else if (selected == R.id.rbBagi) {
            hasil = nilai1 / nilai2;
        }

        txtHasil.setText(String.valueOf(hasil));
    }
}