package com.gbcontest.gbcontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private RadioGroup radioOptionGroup;
    private RadioButton radioOptionButton, rbtn1, rbtn2, rbtn3;
    private Button btnSubmit, btnStop;
    private TextView questionTextView, finalScoreTextView;
    private int x, countScore = 0;
    private TextView timerTextView;

    ArrayList<String> quesList;
    ArrayList<String> AList;
    ArrayList<String> BList;
    ArrayList<String> CList;
    ArrayList<String> CorrectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        radioOptionGroup = (RadioGroup) findViewById(R.id.radioGroup);
        finalScoreTextView = findViewById(R.id.score);

        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnStop = findViewById(R.id.btn_stop);

        rbtn1 = findViewById(R.id.radioButton1);
        rbtn2 = findViewById(R.id.radioButton2);
        rbtn3 = findViewById(R.id.radioButton3);
        questionTextView = findViewById(R.id.tv_question);


        quesList = new ArrayList<String>();
        quesList.add("Q1. Question A");
        quesList.add("Q2. Question B");
        quesList.add("Q3. Question C");

        AList = new ArrayList<String>();
        AList.add("A1");
        AList.add("A2");
        AList.add("A3");

        BList = new ArrayList<String>();
        BList.add("B1");
        BList.add("B2");
        BList.add("B3");

        CList = new ArrayList<String>();
        CList.add("C1");
        CList.add("C2");
        CList.add("C3");

        CorrectList = new ArrayList<String>();
        CorrectList.add("1");
        CorrectList.add("3");
        CorrectList.add("2");

        Random rand = new Random();
        x = 0 + rand.nextInt((2 - 0) + 1);

        questionTextView.setText(quesList.get(x).toString());
        rbtn1.setText(AList.get(x).toString());
        rbtn2.setText(BList.get(x).toString());
        rbtn3.setText(CList.get(x).toString());

/*
        new CountDownTimer(5000, 100){
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(Long.toString(millisUntilFinished/1000));
            }

            public void onFinish() {
                timerTextView.setText("Expired");
            }
        }.start();
*/

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioOptionGroup.getCheckedRadioButtonId();
                radioOptionButton = (RadioButton) findViewById(selectedId);
                //Toast.makeText(PlayActivity.this, radioOptionButton.getText(), Toast.LENGTH_SHORT).show();

                if (Integer.parseInt(CorrectList.get(x).toString()) == (selectedId)) {
                    countScore++;
                    finalScoreTextView.setText("" + countScore);
                }

                Random rand = new Random();
                x = 0 + rand.nextInt((2 - 0) + 1);

                questionTextView.setText(quesList.get(x).toString());
                rbtn1.setText(AList.get(x).toString());
                rbtn2.setText(BList.get(x).toString());
                rbtn3.setText(CList.get(x).toString());

            }
        });


    }
}
