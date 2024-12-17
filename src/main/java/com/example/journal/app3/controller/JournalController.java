package com.example.journal.app3.controller;

import com.example.journal.app3.entry.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/journal")
public class JournalController {

    Map<Long, JournalEntry> entries = new HashMap<>();

    @GetMapping
    public ArrayList<JournalEntry> getEntries(){
        return new ArrayList<>(entries.values());
    }

    @PostMapping
    public boolean postEntry(@RequestBody JournalEntry myEntry){
        entries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getById(@PathVariable long myId){
        return entries.get(myId);
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateById(@PathVariable long myId, @RequestBody JournalEntry myEntry){
        return entries.put(myId,myEntry);
    }

    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteById(@PathVariable long myId){
        return entries.remove(myId);
    }
}
