package com.example.journal.app3.repo;

import com.example.journal.app3.entry.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepo extends MongoRepository<JournalEntry, ObjectId> {
}
