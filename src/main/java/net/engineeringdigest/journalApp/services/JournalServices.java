package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalServices {

    @Autowired
    private JournalRepository journalRepository;

    public void saveJournal(JournalEntry journalEntry){
        journalRepository.save(journalEntry);
    }

    public List<JournalEntry> allJournal(){
        return journalRepository.findAll();
    }

    public Optional<JournalEntry> oneJournal(ObjectId journalId){
        return journalRepository.findById(journalId);
    }

    public void deleteJournal(ObjectId journalId){
        journalRepository.deleteById(journalId);

//        try {
//            if(journalRepository.existsById(journalId)){
//
//                return ResponseEntity.status(HttpStatus.OK).body("journal is deleted");
//            }
//            else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no such journal found to be deleted");
//            }
//
//        }
//        catch (Exception e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Occurred");
//        }

    }

//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public void updateJournal(ObjectId journalId, JournalEntry journalEntry) {
//
//        Query query = new Query(Criteria.where("_id").is(journalId));
//        Update update = new Update();
//        update.set("title", journalEntry.getTitle());
//        update.set("content", journalEntry.getContent());
//        mongoTemplate.findAndModify(query, update, JournalEntry.class);
//    }
    public void updateJournal(ObjectId journalId, JournalEntry journalEntry){
        JournalEntry oldJournalEntry = journalRepository.findById(journalId).orElse(null);
        oldJournalEntry.setContent(journalEntry.getContent());
        oldJournalEntry.setTitle(journalEntry.getTitle());

        journalRepository.save(oldJournalEntry);
    }

}
