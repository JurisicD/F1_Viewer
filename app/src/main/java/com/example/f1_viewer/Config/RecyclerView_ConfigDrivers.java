package com.example.f1_viewer.Config;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.f1_viewer.Classes.Driver;
import com.example.f1_viewer.Fragments.ChampionshipFragment;
import com.example.f1_viewer.R;

import java.util.List;

public class RecyclerView_ConfigDrivers {

    private Context mContext;
    private DriversAdapter mDraversAdapter;


    public void setConfig(RecyclerView recyclerView, Context context, List<Driver> drivers, List<String> keys){
        mContext = context;
        mDraversAdapter = new DriversAdapter(drivers, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mDraversAdapter);
    }



    class DriverItemView extends RecyclerView.ViewHolder {
        private TextView name, code, team, permanentNumber;

        private String key;
        public DriverItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.driver_list_item, parent, false));

            name = (TextView) itemView.findViewById(R.id.name_txtView);
            code = (TextView) itemView.findViewById(R.id.code_txtView);
            team = (TextView) itemView.findViewById(R.id.textViewTeamName);
            permanentNumber = (TextView) itemView.findViewById(R.id.number_txtView);
        }
        public void bind(Driver driver , String key){
            name.setText(driver.getGivenName() + " " + driver.getFamilyName());
            code.setText(driver.getCode());
            permanentNumber.setText(driver.getPermanentNumber());
            team.setText(driver.getConstructorId());
            this.key = key;
        }
    }
    class DriversAdapter extends RecyclerView.Adapter<DriverItemView>{
        private List<Driver> mDriverList;
        private List<String> mKeys;

        public DriversAdapter(List<Driver> mDriverList, List<String> mKeys) {
            this.mDriverList = mDriverList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public DriverItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DriverItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DriverItemView holder, int position) {
            holder.bind(mDriverList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mDriverList.size();
        }
    }

}
