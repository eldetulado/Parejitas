package com.fullstack.umsa.parejas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class FriendzoneActivity extends AppCompatActivity {
    private int counter = 0;
    private int pointCurrent = 0;
    private RadioButton opOne;
    private RadioButton opTwo;
    private RadioButton opThree;
    private RadioButton opFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_sica_friendzone);
        final String [] questionsFriend = getResources().getStringArray(R.array.list_question_friend);
        final String [] answersFriend = getResources().getStringArray(R.array.list_answer_friend);
        final TextView textQuestion = findViewById(R.id.text_question);
        opOne = findViewById(R.id.answer_one);
        opTwo = findViewById(R.id.answer_two);
        opThree = findViewById(R.id.answer_three);
        opFour = findViewById(R.id.answer_four);
        Button btnNext = findViewById(R.id.btn_send_sica);

        String [] tempAnswers = answersFriend[counter].split("-");
        textQuestion.setText(questionsFriend[counter]);
        opOne.setText(tempAnswers[0]);
        opTwo.setText(tempAnswers[1]);
        opThree.setText(tempAnswers[2]);
        opFour.setText(tempAnswers[3]);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointCurrent += getPoint();
                if (counter < 5){
                    counter++;
                    textQuestion.setText(questionsFriend[counter]);
                    String [] temp = answersFriend[counter].split("-");
                    opOne.setText(temp[0]);
                    opTwo.setText(temp[1]);
                    opThree.setText(temp[2]);
                    opFour.setText(temp[3]);
                }else {
                    Intent i = new Intent(FriendzoneActivity.this, ResultActivity.class);
                    i.putExtra("puntaje", String.valueOf(pointCurrent));
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    private int getPoint() {
        if (opOne.isChecked()) return 20;
        if (opTwo.isChecked()) return 10;
        if (opThree.isChecked()) return 5;
        if (opFour.isChecked()) return 1;
        return 0;
    }
}
