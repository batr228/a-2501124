package com.example.report12;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private final List<Animal> animals;
    public AnimalAdapter(List<Animal> animals) {
        this.animals=animals;
        
    }
    @Override public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false));
        
    }
    @Override public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal item=animals.get(position);
        holder.name.setText(item.getName());
        holder.itemView.setOnClickListener(v->android.widget.Toast.makeText(v.getContext(), item.getDetails(), android.widget.Toast.LENGTH_SHORT).show());
        
    }
    @Override public int getItemCount() {
        return animals.size();
        
    }
    
}
