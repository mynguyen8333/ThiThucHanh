package com.example.kiemtrathuhanh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Person> mPersons;

    public CustomAdapter(ArrayList<Person> mPersons) {
        this.mPersons = mPersons;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvid,tvname,tvdep,tvage;
        Button btndelete,btnupdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvage = itemView.findViewById(R.id.tvAge);
            tvname = itemView.findViewById(R.id.tvName);
            tvdep = itemView.findViewById(R.id.tvDep);
            tvid = itemView.findViewById(R.id.tvID);
            btndelete = itemView.findViewById(R.id.btndelete);
            btnupdate = itemView.findViewById(R.id.btnupdate);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Person person = mPersons.get(position);
        holder.tvid.setText(person.getId());
        holder.tvname.setText(person.getName());
        holder.tvdep.setText(person.getDep());
        holder.tvage.setText(person.getAge());

    }
}
