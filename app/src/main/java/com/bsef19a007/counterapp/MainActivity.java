package com.bsef19a007.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int counter;
    private TextView counterTxt;

    @SuppressLint("NonConstantResourceId")
    private final View.OnClickListener clickListener = view -> {
        switch (view.getId()) {
            case R.id.decrease:
                minusCounter();
                break;
            case R.id.increase:
                plusCounter();
                break;
            case R.id.reset:
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


        counterTxt = findViewById(R.id.resultsTextView);
        Button btnPlus = findViewById(R.id.increase);
        btnPlus.setOnClickListener(clickListener);
        Button btnMinus = findViewById(R.id.decrease);
        btnMinus.setOnClickListener(clickListener);
        Button btnReset = findViewById(R.id.reset);
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