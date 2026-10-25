package com.example.report12;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    public final TextView name;
    
    public AnimalViewHolder(View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.itemName);
        
        
    }
    
}
