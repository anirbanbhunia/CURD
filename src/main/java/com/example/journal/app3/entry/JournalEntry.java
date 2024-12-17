package com.example.journal.app3.entry;

public class JournalEntry {

    private long id;
    private String title;
    private String description;

    public long getId(){
        return this.id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String st){
        this.title = st;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String st){
        this.description = st;
    }
}
