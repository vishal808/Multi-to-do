package com.example.multito_do;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
  
import java.util.ArrayList;
  
public class DBHandler extends SQLiteOpenHelper {
  
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "notedb";
  
    // below int is our database version
    private static final int DB_VERSION = 1;
  
    // below variable is for our table name.
    private static final String TABLE_NAME = "todonote";
  
    
    private static final String ID_COL = "id";
  
    
    private static final String NOTE_COL = "note";
  
   
    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
  
    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NOTE_COL +  " TEXT)";
  
        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }
  
    // this method is use to add new course to our sqlite database.
    public void addNewNote(String note) {
  
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
  
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
  
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NOTE_COL, note);
            db.insert(TABLE_NAME, null, values);
  
        // at last we are closing our
        // database after adding database.
        db.close();
    }
  
    // we have created a new method for reading all the courses.
    public ArrayList<MyList> readNote() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();
  
        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorNote = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
  
        // on below line we are creating a new array list.
        ArrayList<MyList> noteArrayList = new ArrayList<>();
  
        // moving our cursor to first position.
        if (cursorNote.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                noteArrayList.add(new MyList(cursorNote.getString(1),
                       ));
            } while (cursorNote.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorNote.close();
        return noteArrayList;
    }
  

   
    // below is the method for deleting our course.
    public void deleteNote(String note) {
          
        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();
  
        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "name=?", new String[]{note});
        db.close();
    }
  
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}