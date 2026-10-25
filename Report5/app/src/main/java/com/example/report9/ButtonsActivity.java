package com.example.report9;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.widget.*;

public class ButtonsActivity extends Activity {
    private final String[] grades= {
        "1학년", "2학년", "3학년", "4학년"
    };
    private int selected=-1;
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_buttons);
        findViewById(R.id.btnConfirm).setOnClickListener(v->new AlertDialog.Builder(this).setTitle("확인").setMessage("확인하시겠습니까?").setNegativeButton("취소", (d, w)-> {
            
        }).setPositiveButton("확인", (d, w)->Toast.makeText(this, "확인했습니다", Toast.LENGTH_SHORT).show()).show());
        findViewById(R.id.btnName).setOnClickListener(v->showNameDialog());
        findViewById(R.id.btnGrade).setOnClickListener(v->showGradeDialog());
        
    }
    private void showNameDialog() {
        EditText input=new EditText(this);
        input.setHint("이름을 입력하세요");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        new AlertDialog.Builder(this).setTitle("이름 입력").setView(input).setNegativeButton("Cancel", (d, w)-> {
            
        }).setPositiveButton("OK", (d, w)-> {
            String name=input.getText().toString().trim();Toast.makeText(this, name.isEmpty()?"입력해주세요":name, Toast.LENGTH_SHORT).show();
        }).show();
        
    }
    private void showGradeDialog() {
        selected=-1;
        new AlertDialog.Builder(this).setTitle("학년 선택").setSingleChoiceItems(grades, -1, (d, which)->selected=which).setNegativeButton("취소", (d, w)-> {
            
        }).setPositiveButton("닫기", (d, w)->Toast.makeText(this, selected<0?"학년을 선택해주세요":"선택한 학년 : "+grades[selected], Toast.LENGTH_SHORT).show()).show();
        
    }
    
}
