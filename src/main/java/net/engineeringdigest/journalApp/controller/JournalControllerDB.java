package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.services.JournalServices;
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

    @PostMapping
    public ResponseEntity<String> saveJournalEntry(@RequestBody JournalEntry journalEntry){
        journalServices.saveJournal(journalEntry);
        return ResponseEntity.status(HttpStatus.CREATED).body("new journal is created");
    }

    @GetMapping
    public List<JournalEntry> getAllEntry(){
        return journalServices.allJournal();
    }

    @GetMapping("id/{journalId}")
    public Optional<JournalEntry> oneEntry(@PathVariable String journalId ){
        return journalServices.oneJournal(journalId);
    }

    @DeleteMapping("id/{journalId}")
    public ResponseEntity deleteJournal(@PathVariable String journalId){

        ResponseEntity responseEntity=  journalServices.deleteJournal(journalId);
        return  responseEntity;
    }

    @PutMapping("id/{journalId}")
    public JournalEntry updateJournal(@PathVariable String journalId,@RequestBody JournalEntry journalEntry){
        return journalServices.updateJournal(journalEntry);
    }


}
