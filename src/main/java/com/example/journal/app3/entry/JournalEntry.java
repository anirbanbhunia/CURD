package com.example.journal.app3.entry;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Collections;

@Document(collection = "journal_entry_main")
@Data
public class JournalEntry {

    private ObjectId id;
    private String title;
    private String description;
    private LocalDate date;

}
