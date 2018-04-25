package com.fullstack.umsa.parejas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSica = findViewById(R.id.btn_sica);
        btnSica.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sica:
                Intent i = new Intent(this, SicaActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btn_friendzone:
                Toast.makeText(this, "Falta preguntas", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_one_year:
                Toast.makeText(this, "En desarrollo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_three_year:
                Toast.makeText(this, "En desarrollo", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
