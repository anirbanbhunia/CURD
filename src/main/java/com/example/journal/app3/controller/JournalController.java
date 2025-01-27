package com.example.journal.app3.controller;

import com.example.journal.app3.entry.JournalEntry;
import com.example.journal.app3.service.JournalServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;


@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalServices js;

    @GetMapping
    public ResponseEntity<?> getEntries(){
        List<JournalEntry> j = js.getAll();
        if(j != null){
            return new ResponseEntity<>(j, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> postEntry(@RequestBody JournalEntry myEntry){
       try{
           myEntry.setDate(LocalDate.now());
           js.addEntry(myEntry);
           return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getById(@PathVariable ObjectId myId){
        Optional<JournalEntry> j = js.getById(myId);
        if(j.isPresent()){
            return new ResponseEntity<>(j.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<?> updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry myEntry){
        JournalEntry old = js.getById(myId).orElse(null);
        if(old != null && !old.equals(" ")){
            old.setTitle(myEntry.getTitle() != null && !myEntry.getTitle().equals(" ") ? myEntry.getTitle() : old.getTitle());
            old.setDescription(myEntry.getDescription() != null && !myEntry.getDescription().equals(" ") ? myEntry.getDescription() : old.getDescription());
            js.addEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId myId){
        js.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
