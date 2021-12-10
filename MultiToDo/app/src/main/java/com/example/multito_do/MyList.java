package com.example.multito_do;
public class MyList {
  
    
    private String note;
    private int id;
  
    // creating getter and setter methods
    public String getNote() {
        return note;
    }
  
    public void setNote(String note) {
        this.note = note;
    }
  
   
  

  
    public int getId() {
        return id;
    }
  
    public void setId(int id) {
        this.id = id;
    }
  
    // constructor
    public MyList(String note) {

        this.note = note;
    }
}