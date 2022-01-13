package com.ottoman.ottoman;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WeightOfSteel extends AppCompatActivity {

    private EditText diameter, length, thickness;
    private double dia, len, thick, wt;
    private TextView weight, unit;     //mg to ton
    private final double steelConstant = 0.02467;
    boolean ton = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_of_steel);
        diameter = findViewById(R.id.diameterEntered);
        length = findViewById(R.id.lengthEntered);
        thickness = findViewById(R.id.thicknessEntered);
        weight = findViewById(R.id.weightValue);
        unit = findViewById(R.id.mm4);

        unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (unit.getText().equals(" tonne")) {
                    ton = false;
                    wt *= 1000;
                    weight.setText(String.valueOf(Double.parseDouble(String.format("%.3f", wt))));
                    unit.setText(" kg");
                }
                else {
                    ton = true;
                    wt /= 1000;
                    weight.setText(String.valueOf(Double.parseDouble(String.format("%.3f", wt))));
                    unit.setText(" tonne");
                }
            }
        });

        diameter.addTextChangedListener(new TextWatcher() {    //mm
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            if (String.valueOf(s).equals("")) {
                weight.setText("");
            }
            else {
                dia = Double.parseDouble(String.valueOf(s));
                if (String.valueOf(length.getText()).equals("")) {
                    weight.setText("");
                }
                else {
                    len = Double.parseDouble(String.valueOf(length.getText()));
                    if (String.valueOf(thickness.getText()).equals("")) {
                        weight.setText("");
                    }
                    else {
                        thick = Double.parseDouble(String.valueOf(thickness.getText()));
                        wt = (dia - thick) * thick * len * steelConstant * 0.001;
                        if (ton) {
                            wt /= 1000;
                        }
                        weight.setText(String.valueOf(Double.parseDouble(String.format("%.3f", wt))));

                    }
                }
            }
            }
        });

        length.addTextChangedListener(new TextWatcher() {    //mm
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (String.valueOf(s).equals("")) {
                    weight.setText("");
                }
                else {
                    len = Double.parseDouble(String.valueOf(s));
                    if (String.valueOf(diameter.getText()).equals("")) {
                        weight.setText("");
                    }
                    else {
                        dia = Double.parseDouble(String.valueOf(diameter.getText()));
                        if (String.valueOf(thickness.getText()).equals("")) {
                            weight.setText("");
                        }
                        else {
                            thick = Double.parseDouble(String.valueOf(thickness.getText()));
                            wt = (dia - thick) * thick * len * steelConstant * 0.001;
                            if (ton) {
                                wt /= 1000;
                            }
                            weight.setText(String.valueOf(Double.parseDouble(String.format("%.3f", wt))));
                        }
                    }
                }
            }
        });

        thickness.addTextChangedListener(new TextWatcher() {      //mm
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (String.valueOf(s).equals("")) {
                    weight.setText("");
                }
                else {
                    thick = Double.parseDouble(String.valueOf(s));
                    if (String.valueOf(diameter.getText()).equals("")) {
                        weight.setText("");
                    }
                    else {
                        dia = Double.parseDouble(String.valueOf(diameter.getText()));
                        if (String.valueOf(length.getText()).equals("")) {
                            weight.setText("");
                        }
                        else {
                            len = Double.parseDouble(String.valueOf(length.getText()));
                            wt = (dia - thick) * thick * len * steelConstant * 0.001;
                            if (ton) {
                                wt /= 1000;
                            }
                            weight.setText(String.valueOf(Double.parseDouble(String.format("%.3f", wt))));
                        }
                    }
                }
            }
        });
    }
}