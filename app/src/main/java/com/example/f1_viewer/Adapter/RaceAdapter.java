package com.example.f1_viewer.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Activites.RaceDetailActivity;
import com.example.f1_viewer.Classes.Race;
import com.example.f1_viewer.R;

import java.util.ArrayList;

public class RaceAdapter extends RecyclerView.Adapter<RaceAdapter.ViewHolder>{

    // 1- Data
    private Context context;
    private ArrayList<Race> raceList;

    // 2- Constructor


    public RaceAdapter(Context context, ArrayList<Race> raceList) {
        this.context = context;
        this.raceList = raceList;
    }

    // 3- View Holder
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView dateText;
        private TextView roundText;
        private TextView cityText;
        private TextView trackNameText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            dateText = itemView.findViewById(R.id.dateTextView);
            roundText = itemView.findViewById(R.id.roundTextView);
            cityText = itemView.findViewById(R.id.trackCityTextView);
            trackNameText = itemView.findViewById(R.id.trackNameTextView);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scedule_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RaceAdapter.ViewHolder holder, int position) {
        Race model = raceList.get(position);
        holder.dateText.setText(model.getDateFromTo());
        holder.roundText.setText(model.getRound());
        holder.cityText.setText(model.getCountry());
        holder.trackNameText.setText(model.getCircuitName());

        //Handle the click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose: "+raceList.get(position).getCircuitName(), Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(context, RaceDetailActivity.class);
                Race race = raceList.get(position);
                intent.putExtra("circuitName", race.getCircuitName());
                intent.putExtra("country", race.getCountry());
                intent.putExtra("dateFromTo", race.getDateFromTo());
                intent.putExtra("lapRecord", race.getLapRecord());
                intent.putExtra("numberOfLaps", race.getNumberOfLaps());
                intent.putExtra("raceDistance", race.getRaceDistance());
                intent.putExtra("round", race.getRound());
                intent.putExtra("trackDistance", race.getTrackDistance());
                intent.putExtra("trackImg", race.getTrackImg());
                intent.putExtra("trackName", race.getTrackName());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return raceList.size();
    }

}