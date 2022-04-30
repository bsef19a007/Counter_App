package com.bsef19a007.bsef19a007_counter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView counterTxt;
    private int counter;

    @SuppressLint("NonConstantResourceId")
    private final View.OnClickListener clickListener = view -> {
        switch (view.getId()) {
            case R.id.btnMinus:
                minusCounter();
                break;
            case R.id.btnPlus:
                plusCounter();
                break;
            case R.id.btnReset:
                initCounter();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTxt = findViewById(R.id.counterTxt);
        Button btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(clickListener);
        Button btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(clickListener);
        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(clickListener);

        initCounter();

    }

    @SuppressLint("SetTextI18n")
    private void initCounter() {
        counter = 0;
        counterTxt.setText(counter + "");
    }

    @SuppressLint("SetTextI18n")
    private void plusCounter() {
        counter++;
        counterTxt.setText(counter + "");
    }

    @SuppressLint("SetTextI18n")
    private void minusCounter() {
        counter--;
        counterTxt.setText(counter + "");
    }

}