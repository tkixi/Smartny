package com.example.tkixi.tonyflashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnSubmit;
    private Button btnGenerate;
    private TextView txtDividend;
    private TextView txtDivisor;
    private TextView txtCounter;
    private int dividend;
    private int divisor;
    private int n;
    private int counter;
    private EditText txtUserInput;
    private static final String MyFlag = "FLAG2";
    private static int eventCount = 0;
    private int k;

    Random r = new Random();
    private boolean x = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        txtDividend = (TextView) findViewById(R.id.txtDividend);
        txtDivisor = (TextView) findViewById(R.id.txtDivisor);
        txtUserInput = (EditText) findViewById(R.id.txtUserInput);
        txtCounter = (TextView) findViewById(R.id.txtCounter);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(x) {
                    dividend = r.nextInt(99) + 1;
                    divisor = r.nextInt(99) + 1;
                    if (dividend % divisor == 0) {
                        break;

                    }
                }

                txtDividend.setText(intToStr(dividend));
                txtDivisor.setText(intToStr(divisor));
                counter = 0;
                n = 0;
                txtCounter.setText(intToStr(counter+1) + "/10");

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUserInput.getText().toString().trim().length() == 0) {
                Toast.makeText(getBaseContext(), "Please enter a number", Toast.LENGTH_SHORT).show();
                 }
                else {
                String Input;
                Input = txtUserInput.getText().toString();
                if (strToInt(Input) == (dividend / divisor)) {
                    n++;
                }
                counter++;
                if (counter == 10) {
                    Toast.makeText(getBaseContext(), "You got " + intToStr(n) + " answers right!", Toast.LENGTH_LONG).show();
                }
                while (x) {
                    dividend = r.nextInt(99) + 1;
                    divisor = r.nextInt(99) + 1;
                    if (dividend % divisor == 0) {
                        k = dividend / divisor;
                        break;
                    }
                }

                txtDividend.setText(intToStr(dividend));
                txtDivisor.setText(intToStr(divisor));
                if (counter >= 10){
                    txtCounter.setText(null);
                }
                else{
                    txtCounter.setText(intToStr(counter+1) + "/10");
                }
                txtUserInput.setText(null);
            }
            }
                                     }
        );}

    public String intToStr(Integer i)
    {
        return i.toString();
    }

    public int strToInt(String S)
    {
        return Integer.parseInt(S);
    }
}

