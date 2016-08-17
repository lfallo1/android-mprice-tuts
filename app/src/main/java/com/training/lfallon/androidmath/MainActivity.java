package com.training.lfallon.androidmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.training.lfallon.androidmath.exception.InputException;
import com.training.lfallon.androidmath.model.PercentageInput;
import com.training.lfallon.androidmath.service.ConversionService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MAINACTIVITY_EXTRA_ANSWER = "MAINACTIVITY_EXTRA_ANSWER";
    private TextView mResult;
    private EditText mPercentage;
    private EditText mNumber;
    private Button mCalculateButton;

    private PercentageInput percentageInput;
    private ConversionService conversionService = ConversionService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumber = (EditText)findViewById(R.id.content_main_edit_number);
        mPercentage = (EditText)findViewById(R.id.content_main_enter_pct);
        mCalculateButton = (Button)findViewById(R.id.content_main_calculate_button);
        mResult = (TextView)findViewById(R.id.content_main_answer);

        mCalculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.content_main_calculate_button){

            //Calculate percentage button click-handler
            try{
                Double percentage = conversionService.numberFromEditText(mPercentage);
                Double number = conversionService.numberFromEditText(mNumber);
                percentageInput = new PercentageInput(percentage, number);
                percentageInput.validate();
                Double answer = percentageInput.calculatePercentage();

                mResult.setText(String.valueOf(answer));
                showAnswer(answer);
            } catch(InputException e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void showAnswer(double answer){
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra(MAINACTIVITY_EXTRA_ANSWER, answer);
        startActivity(intent);
    }
}
