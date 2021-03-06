package com.example.ryo.aiscalculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView aAMPSOValue;
    private TextView aFeroValue;
    private TextView bMiliQValue;
    private TextView bAISValue;

    private Button aCalculate;
    private Button bCalculate;

    private EditText aGetTotalValue;
    private EditText aGetFeroValue;
    private EditText bGetTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aAMPSOValue = findViewById(R.id.a_mili_q_value);
        aFeroValue = findViewById(R.id.a_fero_value);
        bMiliQValue = findViewById(R.id.b_mili_q_value);
        bAISValue = findViewById(R.id.b_ais_value);

        aCalculate = findViewById(R.id.a_button);
        aCalculate.setOnClickListener(this);
        bCalculate = findViewById(R.id.b_button);
        bCalculate.setOnClickListener(this);

        aGetTotalValue = findViewById(R.id.get_total_value_a);
        aGetFeroValue = findViewById(R.id.get_fero_value_a);
        bGetTotalValue = findViewById(R.id.get_total_value_b);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (view == aCalculate) {
            double aTotal = Double.parseDouble(aGetTotalValue.getText().toString());
            double aFero = Double.parseDouble(aGetFeroValue.getText().toString());

            double aAMPSOValueDouble = CalculateA(aFero, aTotal);

            aAMPSOValue.setText(Double.toString(aAMPSOValueDouble * 1000));

            aFeroValue.setText(Double.toString((aTotal * 1000) - (aAMPSOValueDouble * 1000)));

        } else if (view == bCalculate) {
            double bTotal = Double.parseDouble(bGetTotalValue.getText().toString());

            double bToMicro = bTotal / 1000;

            double bMiliQValueDouble = CalculateB(bToMicro);

            bMiliQValue.setText(Double.toString(bMiliQValueDouble));

            bAISValue.setText(Double.toString(bTotal - bMiliQValueDouble));

        }

    }

    double CalculateA (double fero, double totalValue) {
        double feroValue = 5 / fero;

        return totalValue - feroValue;
    }

    double CalculateB (double valueOfB) {
        double miliQValue;

        miliQValue = 995.2943 * valueOfB;
        return miliQValue;
    }
}
