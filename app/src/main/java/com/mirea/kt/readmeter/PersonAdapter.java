package com.mirea.kt.readmeter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    interface OnPersonClickListener{
        void onPersonClick(Person person, int position);
    }
    private ArrayList<Person> persons;
    private OnPersonClickListener onPersonClickListener;

    public PersonAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }
    public PersonAdapter(ArrayList<Person> persons, OnPersonClickListener onPersonClickListener){
        this.persons = persons;
        this.onPersonClickListener = onPersonClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameView;
        private final TextView ageView;

        ViewHolder(View view) {
            super(view);
            nameView = view.findViewById(R.id.tvPersonName);
            ageView = view.findViewById(R.id.tvPersonAge);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.nameView.setText(String.format("%s %s", person.getFirstName(),person.getLastName()));
        holder.ageView.setText(String.format("%d Кв/ч", person.getAge()));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onPersonClickListener.onPersonClick(person, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
