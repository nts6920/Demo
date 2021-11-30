package com.nts.demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // declare
    TextView tvNumber;
    Button btnRandom;
    EditText etMin, etMax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Finds view
        tvNumber = (TextView) findViewById(R.id.tvNumber);
        btnRandom = (Button) findViewById(R.id.btnRandom);
        etMin = (EditText) findViewById(R.id.etMin);
        etMax = (EditText) findViewById(R.id.etMax);

        // code
        btnRandom.setOnClickListener(v -> {
            // check null
            String strMin = etMin.getText().toString().trim();
            String strMax = etMax.getText().toString().trim();
            // check null
            if (strMin.isEmpty() || strMax.isEmpty()){
                Toast.makeText(MainActivity.this,"Please, Enter number!",Toast.LENGTH_SHORT).show();
            }else {
                // string -> int
                int parMin = Integer.parseInt(strMin);
                int parMax = Integer.parseInt(strMax);
                // check max < min
                if (parMax < parMin){
                    Toast.makeText(MainActivity.this,"Max > Min",Toast.LENGTH_SHORT).show();
                }else {
                    // random
                    Random random = new Random();
                    int number = random.nextInt(parMax - parMin + 1) + parMin;
                    tvNumber.setText(String.valueOf(number));
                }
            }
        });
    }
}