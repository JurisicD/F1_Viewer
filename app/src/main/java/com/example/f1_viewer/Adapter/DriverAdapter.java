package com.example.f1_viewer.Adapter;

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
import com.example.f1_viewer.Activites.DriverDetailActivity;
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

        private  ImageView driverImg;
        private TextView name_text;
        private TextView team_text;
        private TextView number_text;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name_text = itemView.findViewById(R.id.name_txtView);
            team_text = itemView.findViewById(R.id.textViewTeamName);
            number_text = itemView.findViewById(R.id.number_txtView);
            driverImg = itemView.findViewById((R.id.driverImageView));

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

        Glide.with(holder.itemView.getContext())
                .load(model.getPicture())
                .into(holder.driverImg);

        holder.name_text.setText(model.getGivenName()+ " "+model.getFamilyName());
        holder.team_text.setText(model.getConstructorId());
        holder.number_text.setText(""+model.getPermanentNumber());




        //Handle the click events
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose: "+driverList.get(position).getCode(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DriverDetailActivity.class);
                intent.putExtra("code", driverList.get(position).getCode());
                intent.putExtra("constructorId", driverList.get(position).getConstructorId());
                intent.putExtra("dateOfBirth", driverList.get(position).getDateOfBirth());
                intent.putExtra("familyName", driverList.get(position).getFamilyName());
                intent.putExtra("givenName", driverList.get(position).getGivenName());
                intent.putExtra("nationality", driverList.get(position).getNationality());
                intent.putExtra("permanentNumber", driverList.get(position).getPermanentNumber());
                intent.putExtra("wins", driverList.get(position).getWins());
                intent.putExtra("podiums", driverList.get(position).getPodiums());
                intent.putExtra("poles", driverList.get(position).getPoles());
                intent.putExtra("firstEntry", driverList.get(position).getFirstEntry());
                intent.putExtra("firstWin", driverList.get(position).getFirstWin());
                intent.putExtra("numberOfTitles", driverList.get(position).getNumberOfTitles());
                intent.putExtra("picture", driverList.get(position).getPicture());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

}

