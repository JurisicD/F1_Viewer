package com.example.f1_viewer.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.f1_viewer.Activites.PointAdministrationActivity;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.R;

import java.util.ArrayList;

public class AdapterPoints extends RecyclerView.Adapter<AdapterPoints.ViewHolder>{

    // 1- Data
    private Context context;
    private ArrayList<Team> teamList;

    private ArrayList<Driver> driverList;

    // 2- Constructor


    public AdapterPoints(Context context, ArrayList<Team> teamList, ArrayList<Driver> driverList) {
        this.context = context;
        this.teamList = teamList;
        this.driverList = driverList;
    }



    // 3- View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageTeam2;
        private TextView teamName2;
        private TextView teamPoints2;
        private TextView drivers2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageTeam2 = itemView.findViewById(R.id.imageViewTeam);
            teamName2 = itemView.findViewById(R.id.teamName_txtView);
            teamPoints2 = itemView.findViewById(R.id.teamPoints_txtView);
            drivers2 = itemView.findViewById(R.id.drivers_textView);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPoints.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Team model = teamList.get(position);

        holder.teamName2.setText("" + model.getName());
        holder.teamPoints2.setText("" + model.getPoints());
        holder.drivers2.setText("" + model.getDrivers().get(0) + " | " + model.getDrivers().get(1));

        Glide.with(holder.itemView.getContext())
                .load(model.getTeamLogoImg())
                .into(holder.imageTeam2);

        //Handle the click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose: " + teamList.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, PointAdministrationActivity.class);
                intent.putExtra("constructorId", teamList.get(position).getConstructorId());
                intent.putStringArrayListExtra("drivers", (ArrayList<String>) teamList.get(position).getDrivers());
                intent.putExtra("name", teamList.get(position).getName());
                intent.putExtra("nationality", teamList.get(position).getNationality());
                intent.putExtra("points", teamList.get(position).getPoints());
                intent.putExtra("teamCarImg", teamList.get(position).getTeamCarImg());
                intent.putExtra("teamLogoImg", teamList.get(position).getTeamLogoImg());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public void clearData() {
        teamList.clear();
        notifyDataSetChanged();
    }

}