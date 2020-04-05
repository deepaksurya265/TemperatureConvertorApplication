package com.wiates.temperatureconvertorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton ftoc,ctof;
    EditText tempInput;
    TextView result;
    Button convertButton;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ftoc = findViewById(R.id.ftoc);
        ctof = findViewById(R.id.ctof);

        rg = findViewById(R.id.rg);

        tempInput = findViewById(R.id.tempInput);
        result = findViewById(R.id.result);
        convertButton = findViewById(R.id.convertButton);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(ftoc.isChecked()){
                    tempInput.setHint("Enter Temperature in Farenheit");
                }
                else if (ctof.isChecked()){
                    tempInput.setHint("Enter Temperature in Celcius");
                }
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ftoc.isChecked()){
                    Double temp = (Float.parseFloat(tempInput.getText().toString()) - 32) * (5/9.0);
                    result.setText(temp.toString()+" Degree Celcius");
                }
                else if (ctof.isChecked()){
                    Double temp = (Float.parseFloat(tempInput.getText().toString()) * (9/5.0)) + 32;
                    result.setText(temp.toString()+" Degree Farenheit");
                }
            }
        });

    }
}
