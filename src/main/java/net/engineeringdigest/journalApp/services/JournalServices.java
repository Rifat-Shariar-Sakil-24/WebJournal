package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public Optional<JournalEntry> oneJournal(String journalId){
        return journalRepository.findById(journalId);
    }

    public ResponseEntity<String> deleteJournal(String journalId){
        try {
            if(journalRepository.existsById(journalId)){
                journalRepository.deleteById(journalId);
                return ResponseEntity.status(HttpStatus.OK).body("journal is deleted");
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no such journal found to be deleted");
            }

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Occurred");
        }

    }

    public JournalEntry updateJournal(JournalEntry journalEntry){

        saveJournal(journalEntry);
        return journalEntry;
    }
}
