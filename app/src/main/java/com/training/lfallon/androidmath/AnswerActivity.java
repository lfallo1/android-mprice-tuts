package com.training.lfallon.androidmath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private TextView mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_activity);
        mAnswer  = (TextView)findViewById(R.id.answer_activity_answer);

        double answer = getIntent().getExtras().getDouble(MainActivity.MAINACTIVITY_EXTRA_ANSWER);
        mAnswer.setText(String.valueOf(answer));
    }

}
