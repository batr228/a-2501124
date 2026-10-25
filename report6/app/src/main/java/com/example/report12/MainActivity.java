package com.example.report12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnMembers).setOnClickListener(v->startActivity(new Intent(this, MemberListActivity.class)));
        findViewById(R.id.btnRecycler).setOnClickListener(v->startActivity(new Intent(this, RecyclerActivity.class)));
        findViewById(R.id.btnSpinner).setOnClickListener(v->startActivity(new Intent(this, SpinnerActivity.class)));
        
    }
    
}
