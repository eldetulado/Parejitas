package com.fullstack.umsa.parejas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String point = getIntent().getExtras().getString("puntaje","error");
        int p = Integer.valueOf(point);
        String m = setMsg(p);
        TextView txtPoint = findViewById(R.id.text_point);
        TextView msg = findViewById(R.id.msg_result);
        Button btn = findViewById(R.id.btnAgain);

        txtPoint.setText(point);
        msg.setText(m);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private String setMsg(int p) {
        String m = "";
        if (p >= 75) m = getString(R.string.text_one);
        if (p >= 50 && p <= 74) m = getString(R.string.text_two);
        if (p >= 25 && p <= 49) m = getString(R.string.text_three);
        if (p <= 24) m = getString(R.string.text_four);
        return m;
    }
}
