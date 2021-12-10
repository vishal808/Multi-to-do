package com.example.multito_do;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
public class MainEditor extends AppCompatActivity {
  
    // creating variables for our edittext, button and dbhandler
    private EditText noteEdt;
    private Button addBtn;
    private DBHandler dbHandler;
   private ArrayList<MyList> noteList;
  
    private MyAdapter myAdapter;
    private RecyclerView noteRV;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
	noteEdt = findViewById(R.id.editText);
	addBtn = findViewById(R.id.idBtnAdd);
 dbHandler = new DBHandler(MainEditor.this);
          
        // below line is to add on click listener for our add course button.
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  
                // below line is to get data from all edit text fields.
               
                String note = noteEdt.getText().toString();
                 
                // validating if the text fields are empty or not.
                if (note.isEmpty()) {
                    Toast.makeText(MainEditor.this, "Please enter note..", Toast.LENGTH_SHORT).show();
                    return;
                }
                  
                // on below line we are calling a method to add new 
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewNote(note);
                  
                // after adding the data we are displaying a toast message.
                Toast.makeText(MainEditor.this, "Note has been added.", Toast.LENGTH_SHORT).show();
               noteEdt.setText("");
                }
        });
}

}