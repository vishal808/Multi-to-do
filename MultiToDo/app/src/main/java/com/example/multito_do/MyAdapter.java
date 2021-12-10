package com.example.multito_do;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
  
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
  
import java.util.ArrayList;
  
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
  
    // variable for our array list and context
    private ArrayList<MyList> noteArrayList;
    private Context context;
  
    // constructor
    public MyAdapter(ArrayList<MyList> noteArrayList, Context context) {
        this.noteArrayList = noteArrayList;
        this.context = context;
    }
  
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_todolist, parent, false);
        return new ViewHolder(view);
    }
  
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data 
        // to our views of recycler view item.
        MyList modal = noteArrayList.get(position);
        holder.noteTV.setText(modal.getNote());
        }
  
    @Override
    public int getItemCount() {
        // returning the size of our array list
        return noteArrayList.size();
    }
  
    public class ViewHolder extends RecyclerView.ViewHolder {
          
        // creating variables for our text views.
        private TextView noteTV;
  
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            noteTV = itemView.findViewById(R.id.idTVnote);
            
        }
    }
}