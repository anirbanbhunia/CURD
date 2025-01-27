package com.example.journal.app3.service;

import com.example.journal.app3.entry.JournalEntry;
import com.example.journal.app3.repo.JournalRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalServices {

    @Autowired
    private JournalRepo repo;

    public List<JournalEntry> getAll(){
        return repo.findAll();
    }

    public JournalEntry addEntry(JournalEntry e){
        return repo.save(e);
    }

    public Optional<JournalEntry> getById(ObjectId id){
        return repo.findById(id);
    }

    public void deleteById(ObjectId id){
        repo.deleteById(id);
    }
}
