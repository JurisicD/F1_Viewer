package com.example.f1_viewer.Adapter;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.f1_viewer.Activites.DriverDetailActivity;
import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Classes.Team;
import com.example.f1_viewer.Fragments.ChampionshipFragment;
import com.example.f1_viewer.Fragments.ScheduleFragment;
import com.example.f1_viewer.MainActivity;
import com.example.f1_viewer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilteredDriversAdapter extends RecyclerView.Adapter<FilteredDriversAdapter.ViewHolder> {
    private List<Driver> filteredDriverList;
    private Context context;

    String holder_points;


    public FilteredDriversAdapter(List<Driver> filteredDriverList, Context context) {
        this.filteredDriverList = filteredDriverList;
        this.context = context;
    }
    public void clearData() {
        filteredDriverList.clear();
        notifyDataSetChanged();
    }
    public void addData(ArrayList<Driver> driversList) {
        this.filteredDriverList.addAll(driversList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView pointsText;
        private EditText points;
        private Button trigger;
        private ImageView dirver_image_view;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.driver_name_points);
            pointsText = itemView.findViewById(R.id.driver_points_points);
            points = itemView.findViewById(R.id.editText);
            trigger = itemView.findViewById(R.id.btn_save_points);
            dirver_image_view = itemView.findViewById(R.id.imageView_drivers_points);
        }
        public void bind(Driver filteredDriver) {
            nameTextView.setText(filteredDriver.getGivenName() + " " + filteredDriver.getFamilyName());
            pointsText.setText(""+filteredDriver.getPoints());




            trigger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform the action here when the button is clicked
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Driver filteredDriver = filteredDriverList.get(position);
                        // Do something with the driver object, e.g. update the points
                    }
                }
            });

        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.points_list_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Driver model = filteredDriverList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(model.getPicture())
                .into(holder.dirver_image_view);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Driver");
        DatabaseReference myRefTeam = database.getReference("Team");
        Driver filteredDriver = filteredDriverList.get(position);

        holder.bind(filteredDriver);

        holder.trigger.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String pointsString = holder.points.getText().toString();
                if (pointsString.isEmpty()) {
                    Toast.makeText(context, "Points field is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                int points;
                try {
                    points = Integer.parseInt(pointsString);  //uneseni bodovi
                } catch (NumberFormatException e) {
                    Toast.makeText(context, "Invalid input, only numbers are allowed", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(points == 0 ){
                    Toast.makeText(context, "Points can't be 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (points > 30) {
                    Toast.makeText(context, "Points can't be greater than 30", Toast.LENGTH_SHORT).show();
                    return;
                }
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Driver filteredDriver = filteredDriverList.get(position);

                    // Do something with the points

                    Toast.makeText(context, "You Choose: " + filteredDriverList.get(position).getPoints()+ "po"+points, Toast.LENGTH_SHORT).show();
                    int newPoints = Integer.parseInt(holder.points.getText().toString());
                    filteredDriver.setPoints(filteredDriver.getPoints() + newPoints);
                    int updatedPoints = filteredDriver.getPoints();

                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            int totalPoints = 0;
                            for (DataSnapshot driverSnapshot : dataSnapshot.getChildren()) {
                                Driver driver = driverSnapshot.getValue(Driver.class);
                                if (driver.getConstructorId().equals(filteredDriver.getConstructorId())) {
                                    totalPoints += driver.getPoints();
                                }
                            }
                            holder_points = String.valueOf(totalPoints);
                            // Update the driver's points in the "Driver" reference
                            for (DataSnapshot driverSnapshot : dataSnapshot.getChildren()) {
                                Driver driver = driverSnapshot.getValue(Driver.class);
                                if (driver.getFamilyName().equals(filteredDriver.getFamilyName())) {
                                    DatabaseReference verstappenRef = driverSnapshot.getRef();
                                    verstappenRef.child("points").setValue(updatedPoints);
                                    break;
                                }
                            }
                        }
                        @Override
                        public void onCancelled
                                (DatabaseError databaseError) {
                            Log.e(TAG, "onCancelled: ", databaseError.toException());
                        }
                    });
                }
                // Update the team's total points in the "Team" reference
                int finalTotalPoints =  filteredDriverList.get(0).getPoints() + filteredDriverList.get(1).getPoints();
                myRefTeam.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot teamSnapshot : dataSnapshot.getChildren()) {
                            if (teamSnapshot.child("name").getValue(String.class).equals(filteredDriver.getConstructorId())) {
                                DatabaseReference teamRef = teamSnapshot.getRef();
                                teamRef.child("points").setValue(finalTotalPoints);
                                break;
                            }
                        }
                        notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled: ", databaseError.toException());
                    }
                });

            }
        });
    }







    @Override
    public int getItemCount() {
        return filteredDriverList.size();
    }
}

