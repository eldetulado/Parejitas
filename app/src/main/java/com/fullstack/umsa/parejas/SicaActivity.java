package com.fullstack.umsa.parejas;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SicaActivity extends AppCompatActivity {

    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_sica_friendzone);
        final String [] questionsSica = getResources().getStringArray(R.array.list_question_sica);
        final String [] answersSica = getResources().getStringArray(R.array.list_answer_sica);
        final TextView textQuestion = findViewById(R.id.text_question);
        final RadioButton opOne = findViewById(R.id.answer_one);
        final RadioButton opTwo = findViewById(R.id.answer_two);
        final RadioButton opThree = findViewById(R.id.answer_three);
        final RadioButton opFour = findViewById(R.id.answer_four);
        Button btnNext = findViewById(R.id.btn_send_sica);

        String [] tempAnswers = answersSica[counter].split("-");
        textQuestion.setText(questionsSica[counter]);
        opOne.setText(tempAnswers[0]);
        opTwo.setText(tempAnswers[1]);
        opThree.setText(tempAnswers[2]);
        opFour.setText(tempAnswers[3]);

        Log.d("datos",String.valueOf(tempAnswers.length));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < 5){
                    counter++;
                    textQuestion.setText(questionsSica[counter]);
                    String [] temp = answersSica[counter].split("-");
                    opOne.setText(temp[0]);
                    opTwo.setText(temp[1]);
                    opThree.setText(temp[2]);
                    opFour.setText(temp[3]);
                }else {
                    Toast.makeText(SicaActivity.this, "Final del juego", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
