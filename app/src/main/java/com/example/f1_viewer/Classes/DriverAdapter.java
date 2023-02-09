package com.example.f1_viewer.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.R;

import java.util.List;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.DriverViewHolder> {

    private Context context;
    private List<Driver> drivers;
    private List<String> keys;

    public DriverAdapter(List<Driver> drivers) {
        this.context = context;
        this.drivers = drivers;
        this.keys = keys;
    }

    @NonNull
    @Override
    public DriverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.driver_list_item, parent, false);
        return new DriverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverViewHolder holder, int position) {
        Driver driver = drivers.get(position);
        holder.textViewName.setText(driver.getGivenName());
        holder.textViewNationality.setText(driver.getNationality());
        holder.textViewDob.setText(driver.getDateOfBirth());
    }

    @Override
    public int getItemCount() {
        return drivers.size();
    }

    public void updateData(List<Driver> drivers, List<String> keys) {
        this.drivers = drivers;
        this.keys = keys;
        notifyDataSetChanged();
    }



    public class DriverViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewNationality, textViewDob;

        public DriverViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name_txtView);
            textViewNationality = itemView.findViewById(R.id.textViewTeamName);
            textViewDob = itemView.findViewById(R.id.number_txtView);
        }
    }
}