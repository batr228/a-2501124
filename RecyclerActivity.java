package com.example.report12;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerActivity extends Activity {
    @Override protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_recycler);
        RecyclerView recycler=findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Animal> animals=new ArrayList<>();
        String[] names= {
            "강아지", "고양이", "토끼", "사자", "호랑이", "코끼리", "기린", "원숭이", "펭귄", "여우", "곰", "돌고래"
        };
        for(int i=0;i<names.length;i++)animals.add(new Animal(names[i], "Item "+(i+1)));
        recycler.setAdapter(new AnimalAdapter(animals));
        
    }
    
}
