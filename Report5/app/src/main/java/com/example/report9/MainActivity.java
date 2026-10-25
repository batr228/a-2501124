package com.example.report9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnReport1).setOnClickListener(v->startActivity(new Intent(this, GradeActivity.class)));
        findViewById(R.id.btnReport2).setOnClickListener(v->startActivity(new Intent(this, ButtonsActivity.class)));
        findViewById(R.id.btnHobby).setOnClickListener(v->startActivityForResult(new Intent(this, HobbyActivity.class), 9));
        findViewById(R.id.btnReport3).setOnClickListener(v->startActivity(new Intent(this, ReportThreeActivity.class)));
        
    }
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==9&&resultCode==RESULT_OK&&data!=null)((TextView)findViewById(R.id.txtHobbies)).setText(data.getStringExtra("hobbies"));
        
    }
    
    
}
