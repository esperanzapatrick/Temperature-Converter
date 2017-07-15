package com.example.dianne.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;



public class MainActivity extends AppCompatActivity {
    private EditText Temp_Value;
    private Button Temp_Celsius;
    private Button Temp_Fahrenheit;
    private TextView Temp_Result;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link the code to the xml interface
        Temp_Value = (EditText) findViewById(R.id.Temp_ValueId);
        Temp_Celsius = (Button) findViewById(R.id.Temp_CelsiusId);
        Temp_Fahrenheit = (Button) findViewById(R.id.Temp_FahrenheitId);
        Temp_Result = (TextView) findViewById(R.id.Temp_ResultId);

        //set event listener for c
        Temp_Celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //call FtoC()
                String tValue = Temp_Value.getText().toString();

                //conditional statement
                if (tValue.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Temperature",Toast.LENGTH_LONG).show();
                }else {
                    double doubleTemp = Double.parseDouble(tValue);

                    double convertedValue = FtoC(doubleTemp);

                    String sResult = String.valueOf(round.format(convertedValue));
                    Temp_Result.setText(sResult + " C ");


                    //call FtoC function
                    FtoC(doubleTemp);
                }
            }
        });

        //set event listener for f
        Temp_Fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //call CtoF()
                String tValue = Temp_Value.getText().toString();

                //conditional statement
                if (tValue.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Temperature",Toast.LENGTH_LONG).show();
                }else{
                    double doubleTemp = Double.parseDouble(tValue);

                    double convertedValue = CtoF(doubleTemp);

                    String sResult = String.valueOf(round.format(convertedValue));
                    Temp_Result.setText(sResult + " F ");
                    //call CtoF function
                    CtoF(doubleTemp);
                }

            }
        });

    }
    public double FtoC(double fValue){
        double resultC;
        resultC = (fValue - 32) * 5/9;
        return resultC;
    }
    public double CtoF(double cValue){
        double resultF;
        resultF = (cValue * 9/5) + 32;
        return resultF;
    }
}

