package com.example.miniapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniapplication.Models.Citation;
import com.example.miniapplication.R;

import java.util.List;

public class CitationAdapter extends RecyclerView.Adapter<CitationAdapter.CitationViewHolder>{
    Context context;
    List<Citation> list;

    public CitationAdapter(Context context, List<Citation> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CitationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CitationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CitationViewHolder holder, int position) {

        Citation citation = list.get(position);
        holder.textView.setText(citation.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CitationViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public CitationViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.citation);
        }
    }
}
