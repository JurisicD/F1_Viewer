package com.example.f1_viewer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.R;

import java.util.ArrayList;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder> {
    private ArrayList<Driver> drivers;

    public DriverAdapter(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Driver driver = drivers.get(position);
        holder.name.setText(driver.getFamilyName());
        holder.number.setText(driver.getCode());
        holder.teamName.setText(driver.getConstructorId());
        holder.code.setText(driver.getCode());
    }

    @Override
    public int getItemCount() {
        return drivers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, number, teamName, code;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_txtView);
            number = itemView.findViewById(R.id.number_txtView);
            teamName = itemView.findViewById(R.id.textViewTeamName);
            code = itemView.findViewById(R.id.code_txtView);
        }
    }
}

