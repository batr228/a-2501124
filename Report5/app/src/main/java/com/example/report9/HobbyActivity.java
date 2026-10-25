package com.example.report9;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.*;
import java.util.ArrayList;

public class HobbyActivity extends Activity {
    private final String[] hobbies= {
        "영화", "독서", "수영", "요리", "여행", "축구", "야구"
    };
    private final boolean[] checked=new boolean[hobbies.length];
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_hobby);
        findViewById(R.id.btnChooseHobby).setOnClickListener(v->showHobbies());
        
    }
    private void showHobbies() {
        AlertDialog dialog=new AlertDialog.Builder(this, R.style.HobbyDialogTheme).setTitle("취미를 선택하세요").setMultiChoiceItems(hobbies, checked, (d, which, on)->checked[which]=on).setNegativeButton("취소", (d, w)->finish()).setPositiveButton("닫기", null).create();
        dialog.setOnKeyListener((d, key, event)-> {
            if(key==KeyEvent.KEYCODE_BACK&&event.getAction()==KeyEvent.ACTION_UP) {
                Toast.makeText(this, "Back Button을 눌렀다", Toast.LENGTH_SHORT).show();return true;
            }
            return false;
        });
        dialog.setOnShowListener(d->dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v-> {
            ArrayList<String> values=new ArrayList<>();for(int i=0;i<checked.length;i++)if(checked[i])values.add(hobbies[i]);if(values.isEmpty()) {
                Toast.makeText(this, "취미를 선택해주세요", Toast.LENGTH_SHORT).show();return;
            }
            StringBuilder result=new StringBuilder();for(String value:values) {
                if(result.length()>0)result.append(", ");result.append(value);
            }
            Intent data=new Intent();data.putExtra("hobbies", result.toString());setResult(RESULT_OK, data);EditText field=findViewById(R.id.hobbyValue);field.setText(result.toString());dialog.dismiss();finish();
        }));
        dialog.show();
        
    }
    @Override public void onBackPressed() {
        Toast.makeText(this, "Back Button을 눌렀다", Toast.LENGTH_SHORT).show();
        
    }
    
}
