package com.example.report9;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;

public class ReportThreeActivity extends Activity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_report_three);
        findViewById(R.id.btnSpinnerProgress).setOnClickListener(v->showSpinner());
        findViewById(R.id.btnBarProgress).setOnClickListener(v->showHorizontal());
        findViewById(R.id.btnCustom).setOnClickListener(v->showCustom());
        
    }
    private void showSpinner() {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("Progress Dialog");
        dialog.setMessage("진행 중입니다...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.show();
        new Handler(Looper.getMainLooper()).postDelayed(dialog::dismiss, 2500);
        
    }
    private void showHorizontal() {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setTitle("Progress Dialog");
        dialog.setMessage("잠시만 기다려 주세요.");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMax(100);
        dialog.setProgress(0);
        dialog.setCancelable(false);
        dialog.show();
        Handler handler=new Handler(Looper.getMainLooper());
        Runnable[] step=new Runnable[1];
        step[0]=()-> {
            int value=dialog.getProgress()+5;
            dialog.setProgress(value);
            if(value>=100)dialog.dismiss();
            else handler.postDelayed(step[0], 120);
            
        };
        handler.postDelayed(step[0], 120);
        
    }
    private void showCustom() {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog_login);
        dialog.setTitle("Custom Dialog");
        Window window=dialog.getWindow();
        if(window!=null)window.setBackgroundDrawableResource(android.R.color.transparent);
        EditText id=dialog.findViewById(R.id.loginId), password=dialog.findViewById(R.id.loginPassword);
        dialog.findViewById(R.id.btnLogin).setOnClickListener(v-> {
            if(id.getText().toString().trim().isEmpty()||password.getText().toString().isEmpty())Toast.makeText(this, "Enter ID and password", Toast.LENGTH_SHORT).show();else {
                Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();dialog.dismiss();
            }
            
        });
        dialog.show();
        if(window!=null)window.setLayout((int)(getResources().getDisplayMetrics().widthPixels*.88), WindowManager.LayoutParams.WRAP_CONTENT);
        
    }
    
}
