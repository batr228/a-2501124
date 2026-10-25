package com.example.report5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import java.util.Locale;

public class TemperatureActivity extends Activity {
    SeekBar cSeek, fSeek;
    TextView cText, fText, result;
    RadioGroup source;
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_temperature);
        cSeek=findViewById(R.id.seekCelsius);
        fSeek=findViewById(R.id.seekFahrenheit);
        cText=findViewById(R.id.txtCelsius);
        fText=findViewById(R.id.txtFahrenheit);
        result=findViewById(R.id.txtResult);
        source=findViewById(R.id.radioInput);
        cSeek.setEnabled(true);
        fSeek.setEnabled(false);
        cSeek.setOnSeekBarChangeListener(watcher());
        fSeek.setOnSeekBarChangeListener(watcher());
        source.setOnCheckedChangeListener((g, id)-> {
            boolean c=id==R.id.radioCelsius;cSeek.setEnabled(c);fSeek.setEnabled(!c);
        });
        findViewById(R.id.btnConvert).setOnClickListener(v->convert());
        findViewById(R.id.btnReset).setOnClickListener(v->reset());
        
    }
    private SeekBar.OnSeekBarChangeListener watcher() {
        return new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar s, int p, boolean u) {
                if(s.getId()==R.id.seekCelsius)cText.setText(String.format(Locale.US, "섭씨온도(°C): %.1f", p-100.0));
                else fText.setText(String.format(Locale.US, "화씨온도(°F): %.1f", p-100.0));
                
            }
            public void onStartTrackingTouch(SeekBar s) {
                
            }
            public void onStopTrackingTouch(SeekBar s) {
                
            }
            
        };
        
    }
    private void convert() {
        if(source.getCheckedRadioButtonId()==R.id.radioCelsius) {
            double c=cSeek.getProgress()-100.0;
            double f=c*1.8+32;
            fText.setText(String.format(Locale.US, "화씨온도(°F): %.2f", f));
            result.setText(String.format(Locale.US, "섭씨온도: %.2f °C\n화씨온도: %.2f °F", c, f));
            
        } else {
            double f=fSeek.getProgress()-100.0;
            double c=(f-32)/1.8;
            cText.setText(String.format(Locale.US, "섭씨온도(°C): %.2f", c));
            result.setText(String.format(Locale.US, "섭씨온도: %.2f °C\n화씨온도: %.2f °F", c, f));
            
        }
        
    }
    private void reset() {
        cSeek.setProgress(100);
        fSeek.setProgress(100);
        source.check(R.id.radioCelsius);
        result.setText("");
        
    }
    
}
