package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.services.JournalServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalControllerDB {


    @Autowired
    JournalServices journalServices;

    @GetMapping
    public ResponseEntity<List<JournalEntry>> getAllEntry(){
        List<JournalEntry> journalEntries = journalServices.allJournal();
        return new ResponseEntity<>(journalEntries,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveJournalEntry(@RequestBody JournalEntry journalEntry){
        journalServices.saveJournal(journalEntry);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("id/{journalId}")
    public ResponseEntity<?> oneEntry(@PathVariable ObjectId journalId ){
        Optional<JournalEntry> journalEntry = journalServices.oneJournal(journalId);
        if(journalEntry.isPresent()) return new ResponseEntity<>(journalEntry,HttpStatus.FOUND);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("id/{journalId}")
    public ResponseEntity<?> deleteJournal(@PathVariable ObjectId journalId){
        Optional<JournalEntry> journalEntry = journalServices.oneJournal(journalId);
        if(journalEntry.isPresent()){
            journalServices.deleteJournal(journalId);
            return  new ResponseEntity<>(HttpStatus.OK);
        }

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("id/{journalId}")
    public ResponseEntity<JournalEntry> updateJournal(@PathVariable ObjectId journalId,@RequestBody JournalEntry journalEntry){

        Optional<JournalEntry> journalEntryOld = journalServices.oneJournal(journalId);
        if(journalEntryOld.isPresent()){
            journalServices.updateJournal(journalId,journalEntry);
            return  new ResponseEntity<>(HttpStatus.OK);
        }

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
