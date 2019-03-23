package com.example.discountcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;
import android.view.WindowManager;
import java.lang.*;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    EditText orgAmtEditText;
    TextView percentTextView;
    SeekBar percentSeekBar;
    Button calcButton;
    Button resetButton;
    TextView amtSavedTextView;
    TextView salePriceTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        orgAmtEditText = (EditText) findViewById(R.id.orgAmtEditText);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        calcButton = (Button) findViewById(R.id.calcButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        amtSavedTextView = (TextView) findViewById(R.id.amtSavedTextView);
        salePriceTextView = (TextView) findViewById(R.id.salePriceTextView);
        percentSeekBar=(SeekBar)findViewById(R.id.percentSeekBar);

        //Seek Bar
        percentSeekBar.setProgress(0);
        percentSeekBar.setMax(100);

        percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentTextView.setText(String.valueOf(progress));
                //percentTextView.setSelection(percentTextView.getText().length());
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            //    Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
            //            Toast.LENGTH_SHORT).show();
            }
        });

        //Calculate Button
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (orgAmtEditText.getText().toString().length() == 0 || orgAmtEditText.getText().toString().equals(".")) {
                    //Text Fields are empty.
                    Log.d("Error", "Fields are empty");
                    Toast.makeText(getApplicationContext(), "Please enter a numeric value!",
                            Toast.LENGTH_LONG).show();
                } else {

                    //Get Original Price
                    Double orgAmt = Double.valueOf(orgAmtEditText.getText().toString());

                    //Get Discount Percentage
                    Double disPercent = Double.valueOf(percentTextView.getText().toString());

                    //Calculate Discount Amount
                    Double percentDecimal = disPercent / 100;
                    Double disAmt = percentDecimal * orgAmt;
                    amtSavedTextView.setText("£" + String.format("%.2f", disAmt));

                    //Calculate Sale Price
                    Double salePrice = orgAmt - disAmt;
                    salePriceTextView.setText("£" + String.format("%.2f", salePrice));

                    //Hide Vitural Keyboard
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        });

        //Reset Button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Reset values to 0 or blank
                orgAmtEditText.setText("");
                percentTextView.setText("0");
                amtSavedTextView.setText("£0.00");
                salePriceTextView.setText("£0.00");
                percentSeekBar.setProgress(0);

                //Hide Vitural Keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });
    }
}
