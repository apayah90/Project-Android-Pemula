package com.example.applicationandroidpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.api.defaults.ButtonMode;
import com.beardedhen.androidbootstrap.api.view.ButtonModeView;
import com.google.android.material.textfield.TextInputLayout;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout edtWidth;
    private TextInputLayout edtLength;
    private TextInputLayout edtHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtLength = findViewById(R.id.edt_length);
        edtHeight = findViewById(R.id.edt_height);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_calculate) {
            String inputlength = edtLength.getEditText().getText().toString().trim();
            String inputwidth = edtWidth.getEditText().getText().toString().trim();
            String inputheight = edtHeight.getEditText().getText().toString().trim();
            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (inputlength.isEmpty()) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }

            if (inputwidth.isEmpty()) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }

            if (inputheight.isEmpty()) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            
            Double length = toDouble(inputlength);
            Double width = toDouble(inputwidth);
            Double height = toDouble(inputheight);
            if (length == null) {
                isInvalidDouble = true;
                edtLength.setError("Field ini harus berupa nomor valid");
            }

            if (width == null) {
                isInvalidDouble = true;
                edtWidth.setError("Field ini harus berupa nomor valid");
            }

            if (height == null) {
                isInvalidDouble = true;
                edtHeight.setError("Field ini harus berupa nomor valid");
            }

            if(!isEmptyFields && !isInvalidDouble) {
                edtWidth.setErrorEnabled(false);
                edtLength.setErrorEnabled(false);
                edtHeight.setErrorEnabled(false);
                double volume = length * width * height;
                tvResult.setText(String.valueOf(volume));
            }
            
        }

    }

    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
