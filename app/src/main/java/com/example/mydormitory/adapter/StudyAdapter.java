package com.example.mydormitory.adapter;


import static com.example.mydormitory.Room.contextRoom;
import static com.example.mydormitory.Room.id;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mydormitory.R;
import com.example.mydormitory.Room;
import com.example.mydormitory.StudyId;
import com.example.mydormitory.model.Study;

import java.util.List;

public class StudyAdapter extends RecyclerView.Adapter<StudyAdapter.StudyViewHolder> {

    public static Context contextAdapter;
    List<Study> study;

    public StudyAdapter(Context context, List<Study> study) {
        this.contextAdapter = context;
        this.study = study;
    }

    @NonNull
    @Override
    public StudyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View studyItems = LayoutInflater.from(contextAdapter).inflate(R.layout.study_item, parent, false);
        return new StudyAdapter.StudyViewHolder(studyItems);
    }

    @Override
    public void onBindViewHolder(@NonNull StudyAdapter.StudyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.Fio.setText(study.get(position).getFio());
        holder.Number_dog.setText(study.get(position).getNumber_dog());
        holder.Period.setText(study.get(position).getPeriod());
        holder.Group.setText(study.get(position).getGroup());
        holder.Telefon.setText(study.get(position).getTelefon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contextAdapter, StudyId.class);
                intent.putExtra("ID", study.get(position).getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                contextAdapter.startActivity(intent);
            }
        });
    }

    public static final class StudyViewHolder extends RecyclerView.ViewHolder {

        TextView Fio, Number_dog, Period, Group, Telefon;
        private final Context context;

        public StudyViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();

            Fio = itemView.findViewById(R.id.fio_i);
            Number_dog = itemView.findViewById(R.id.number_dog_i);
            Period = itemView.findViewById(R.id.period_prog_i);
            Group = itemView.findViewById(R.id.group_i);
            Telefon = itemView.findViewById(R.id.telefon_i);
        }
    }

    @Override
    public int getItemCount() {
        return study.size();
    }
}