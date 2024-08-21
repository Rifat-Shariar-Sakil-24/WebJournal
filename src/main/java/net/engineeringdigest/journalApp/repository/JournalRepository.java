package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalRepository extends MongoRepository<JournalEntry, ObjectId> {

}
