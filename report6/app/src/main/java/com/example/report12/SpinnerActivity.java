package com.example.report12;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class SpinnerActivity extends Activity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_spinner);
        Spinner spinner=findViewById(R.id.fruitSpinner);
        TextView result=findViewById(R.id.selectedFruit);
        String[] fruits= {
            "과일을 고르세요", "사과", "배", "딸기", "수박", "바나나", "감", "복숭아", "자두"
        };
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fruits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                result.setText(fruits[position]);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                result.setText("");
            }
            
        });
        findViewById(R.id.btnFruit).setOnClickListener(v->Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show());
        
    }
    
}
