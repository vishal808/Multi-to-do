package com.example.multito_do;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
public class MainToDo extends AppCompatActivity {
  
    // creating variables for our edittext, button and dbhandler
    private EditText noteEdt;
    private Button addBtn;
    private DBHandler dbHandler;
   private ArrayList<MyList> noteList;
  
    private MyAdapter myAdapter;
    private RecyclerView noteRV;

    MainToDo() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
  
       
        //noteEdt = findViewById(R.id.idEdtNote);
        addBtn = findViewById(R.id.idBtnAdd);
          
        // creating a new dbhandler class 
        // and passing our context to it.
        dbHandler = new DBHandler(MainToDo.this);
          
        // below line is to add on click listener for our add course button.
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

                viewNote();
    }
protected void viewNote()
{
  noteList = new ArrayList<>();
        dbHandler = new DBHandler(MainToDo.this);
          
        // getting our course array 
        // list from db handler class.
        noteList = dbHandler.readNote();
          
        // on below line passing our array lost to our adapter class.
        myAdapter = new MyAdapter(noteList, MainToDo.this);
        noteRV = findViewById(R.id.idRVnote);
          
        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainToDo.this, RecyclerView.VERTICAL, false);
        noteRV.setLayoutManager(linearLayoutManager);
          
        // setting our adapter to recycler view.
        noteRV.setAdapter(myAdapter);
}


}