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
import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.R;

import java.util.ArrayList;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder>{

    // 1- Data
    private Context context;
    private ArrayList<Driver> driverList;

    // 2- Constructor
    public DriverAdapter(Context context, ArrayList<Driver> driverList) {
        this.context = context;
        this.driverList = driverList;
    }


    // 3- View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name_text;
        private TextView team_text;
        private TextView number_text;


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

        Driver model = driverList.get(position);
        holder.name_text.setText(model.getGivenName()+ " "+model.getFamilyName());
        holder.team_text.setText(model.getConstructorId());
        holder.number_text.setText(model.getPermanentNumber());


        //Handle the click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose: "+driverList.get(position).getCode(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

}

