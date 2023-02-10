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

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder>{

    // 1- Data
    private Context context;
    private ArrayList<Team> teamList;

    // 2- Constructor


    public TeamAdapter(Context context, ArrayList<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }



    // 3- View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageTeam;
        private TextView teamName;
        private TextView teamPoints;
        private TextView drivers;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageTeam = itemView.findViewById(R.id.imageViewTeam);
            teamName = itemView.findViewById(R.id.teamName_txtView);
            teamPoints = itemView.findViewById(R.id.teamPoints_txtView);
            drivers = itemView.findViewById(R.id.drivers_textView);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        Team model = teamList.get(position);

        holder.teamName.setText(model.getConstructorId());
        holder.teamPoints.setText(model.getPoints());
        holder.drivers.setText(model.getConstructorId());
        holder.drivers.setText(model.getDrivers().get(0) + " | "+ model.getDrivers().get(1));

        //Handle the click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose: "+teamList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

}