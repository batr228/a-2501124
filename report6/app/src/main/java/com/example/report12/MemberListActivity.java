package com.example.report12;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

public class MemberListActivity extends Activity {
    private final ArrayList<Member> members=new ArrayList<>();
    private MemberAdapter adapter;
    private EditText input;
    private ListView list;
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_members);
        members.add(new Member("홍길동"));
        members.add(new Member("이영희"));
        members.add(new Member("박민수"));
        input=findViewById(R.id.inputMember);
        list=findViewById(R.id.memberList);
        adapter=new MemberAdapter();
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id)-> {
            members.get(position).selected=!members.get(position).selected;adapter.notifyDataSetChanged();
        });
        findViewById(R.id.btnAdd).setOnClickListener(v->addMember());
        findViewById(R.id.btnDelete).setOnClickListener(v->deleteSelected());
        findViewById(R.id.btnResult).setOnClickListener(v->showSelected());
        
    }
    private void addMember() {
        String name=input.getText().toString().trim();
        if(name.isEmpty()) {
            Toast.makeText(this, "이름을 입력하세요", Toast.LENGTH_SHORT).show();
            return;
            
        }
        members.add(new Member(name));
        input.setText("");
        adapter.notifyDataSetChanged();
        
    }
    private void deleteSelected() {
        boolean removed=false;
        for(int i=members.size()-1;i>=0;i--)if(members.get(i).selected) {
            members.remove(i);
            removed=true;
            
        }
        adapter.notifyDataSetChanged();
        if(!removed)Toast.makeText(this, "삭제할 회원을 선택하세요", Toast.LENGTH_SHORT).show();
        
    }
    private void showSelected() {
        StringBuilder text=new StringBuilder();
        for(Member member:members)if(member.selected) {
            if(text.length()>0)text.append("\n");
            text.append(member.name);
            
        }
        if(text.length()==0) {
            Toast.makeText(this, "회원 목록을 선택하세요", Toast.LENGTH_SHORT).show();
            return;
            
        }
        new AlertDialog.Builder(this).setTitle("선택한 회원 목록").setMessage(text.toString()).setNegativeButton("삭제", (d, w)->deleteSelected()).setPositiveButton("확인", (d, w)-> {
            
        }).show();
        
    }
    private class MemberAdapter extends android.widget.BaseAdapter {
        public int getCount() {
            return members.size();
            
        }
        public Object getItem(int position) {
            return members.get(position);
            
        }
        public long getItemId(int position) {
            return position;
            
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            if(row==null)row=LayoutInflater.from(MemberListActivity.this).inflate(R.layout.member_row, parent, false);
            Member member=members.get(position);
            TextView name=row.findViewById(R.id.memberName);
            CheckBox check=row.findViewById(R.id.memberChecked);
            name.setText(member.name);
            check.setOnCheckedChangeListener(null);
            check.setChecked(member.selected);
            check.setOnCheckedChangeListener((button, checked)->member.selected=checked);
            return row;
            
        }
        
    }
    
}
