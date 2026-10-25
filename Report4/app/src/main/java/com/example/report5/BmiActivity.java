package com.example.report5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import java.util.Locale;

public class BmiActivity extends Activity {
    TextView weightText, heightText, result;
    SeekBar weightSeek, heightSeek;
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_bmi);
        weightText=findViewById(R.id.txtWeight);
        heightText=findViewById(R.id.txtHeight);
        result=findViewById(R.id.txtBmi);
        weightSeek=findViewById(R.id.seekWeight);
        heightSeek=findViewById(R.id.seekHeight);
        weightSeek.setOnSeekBarChangeListener(listener());
        heightSeek.setOnSeekBarChangeListener(listener());
        
    }
    private SeekBar.OnSeekBarChangeListener listener() {
        return new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar bar, int value, boolean fromUser) {
                update();
                
            }
            public void onStartTrackingTouch(SeekBar bar) {
                
            }
            public void onStopTrackingTouch(SeekBar bar) {
                
            }
            
        };
        
    }
    private void update() {
        double kg=35.0+weightSeek.getProgress()*0.5, cm=90.0+heightSeek.getProgress()*0.5;
        weightText.setText(String.format(Locale.US, "몸무게(Kg): %.1f", kg));
        heightText.setText(String.format(Locale.US, "키(Cm): %.1f", cm));
        if(weightSeek.getProgress()>0||heightSeek.getProgress()>0) {
            double bmi=kg/Math.pow(cm/100.0, 2);
            String category=bmi<18.5?"저체중":bmi<25?"정상":bmi<30?"과체중":"비만";
            result.setText(String.format(Locale.US, "BMI: %.2f\n%s", bmi, category));
            
        }
        
    }
    
}
