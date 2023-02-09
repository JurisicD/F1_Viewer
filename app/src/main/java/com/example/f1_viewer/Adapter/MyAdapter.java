package com.example.f1_viewer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Vozac;
import com.example.f1_viewer.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    // 1- Data
    private Context context;
    private ArrayList<Driver> driversList;

    // 2- Constructor
    public MyAdapter(Context context, ArrayList<Driver> driversList) {
        this.context = context;
        this.driversList = driversList;
    }

    // 3- View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name_text;
        private TextView team_text;

        private TextView number_text;

        //private TextView gameTitle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_text = itemView.findViewById(R.id.name_txtView);
            team_text = itemView.findViewById(R.id.textViewTeamName);
            number_text = itemView.findViewById(R.id.number_txtView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Driver model = driversList.get(position);
        holder.name_text.setText(model.getGivenName()+ " "+model.getFamilyName());
        holder.team_text.setText(model.getConstructorId());
        holder.number_text.setText(model.getPermanentNumber());


        //Handle the click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose: "+driversList.get(position).getCode(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return driversList.size();
    }

}
