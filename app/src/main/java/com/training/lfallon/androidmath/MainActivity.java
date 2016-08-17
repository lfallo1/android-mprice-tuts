package com.training.lfallon.androidmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String MAINACTIVITY_EXTRA_ANSWER = "MAINACTIVITY_EXTRA_ANSWER";
    private TextView mResult;
    private EditText mPercentage;
    private EditText mNumber;
    private Button mCalculateButton;

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
            Double answer;
            if((answer = calculate()) != null){
                mResult.setText(String.valueOf(answer));
                showAnswer(answer);
            }
        }
    }

    public Double calculate(){
        double number = 0;
        double pct = 0;
        try{
            number = Double.parseDouble(mNumber.getText().toString());
            pct = Double.parseDouble(mPercentage.getText().toString());

            if(pct < 0 || pct > 100 || number < 0){
                throw new Exception();
            }
        } catch(NumberFormatException e){
            Toast.makeText(this, "Please enter two valid numbers", Toast.LENGTH_SHORT).show();
            return null;
        } catch(Exception e){
            Toast.makeText(this, "Please enter a percentage between 0 and 100, and a positive number", Toast.LENGTH_SHORT).show();
            return null;
        }
        return number * pct / 100;
    }

    public void showAnswer(double answer){
        Intent intent = new Intent(this, AnswerActivity.class);
        intent.putExtra(MAINACTIVITY_EXTRA_ANSWER, answer);
        startActivity(intent);
    }
}
