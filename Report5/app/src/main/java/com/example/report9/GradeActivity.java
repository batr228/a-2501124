package com.example.report9;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class GradeActivity extends Activity {
    private final String[] grades= {
        "1학년", "2학년", "3학년", "4학년"
    };
    private int selected=-1;
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_grade);
        EditText value=findViewById(R.id.gradeValue);
        value.setOnClickListener(v->showGrades(value));
        
    }
    private void showGrades(EditText value) {
        selected=-1;
        new AlertDialog.Builder(this).setTitle("몇 학년 입니까?").setIcon(android.R.drawable.ic_dialog_info).setSingleChoiceItems(grades, -1, (d, which)->selected=which).setPositiveButton("닫기", (d, w)-> {
            if(selected>=0)value.setText(grades[selected]);else Toast.makeText(this, "학년을 선택해주세요", Toast.LENGTH_SHORT).show();
        }).show();
        
    }
    
}
