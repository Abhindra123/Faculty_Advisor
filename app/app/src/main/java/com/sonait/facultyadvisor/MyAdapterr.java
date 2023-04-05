package com.sonait.facultyadvisor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterr extends RecyclerView.Adapter<MyAdapterr.MyViewHolder> {
    StudentViewFragment context;
    ArrayList<Userr> userArrayList;
    public MyAdapterr(StudentViewFragment context, ArrayList<Userr> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }
    @NonNull
    @Override
    public MyAdapterr.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemm, parent, false);
        return new MyAdapterr.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterr.MyViewHolder holder, int position) {
        Userr user=userArrayList.get(position);
        holder.sname.setText(user.sname);
        holder.regno.setText(user.regno);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView sname,regno;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sname=itemView.findViewById(R.id.namee);
            regno=itemView.findViewById(R.id.reg);
        }
    }
}
