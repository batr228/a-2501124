package com.example.report5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class GcdActivity extends Activity {
    EditText first, second;
    TextView result;
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_gcd);
        first=findViewById(R.id.inputFirst);
        second=findViewById(R.id.inputSecond);
        result=findViewById(R.id.txtResult);
        findViewById(R.id.btnCalculate).setOnClickListener(v->calculate());
        
    }
    private void calculate() {
        try {
            int a=Integer.parseInt(first.getText().toString().trim()), b=Integer.parseInt(second.getText().toString().trim());
            if(a<1||a>100||b<1||b>100)throw new NumberFormatException();
            int x=a, y=b;
            while(y!=0) {
                int r=x%y;
                x=y;
                y=r;
                
            }
            result.setText("최대공약수: "+x+"\n최소공배수: "+(a/x*b));
            
        } catch(NumberFormatException e) {
            Toast.makeText(this, "1에서 100 사이의 자연수 두 개를 입력하세요", Toast.LENGTH_SHORT).show();
            
        }
        
    }
    
}
