package com.example.report5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.btnGcd)).setOnClickListener(v->startActivity(new Intent(this, GcdActivity.class)));
        ((Button)findViewById(R.id.btnBmi)).setOnClickListener(v->startActivity(new Intent(this, BmiActivity.class)));
        ((Button)findViewById(R.id.btnTemp)).setOnClickListener(v->startActivity(new Intent(this, TemperatureActivity.class)));
        
    }
    
}
