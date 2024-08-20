//package net.engineeringdigest.journalApp.controller;
//
//import net.engineeringdigest.journalApp.entry.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/journal")
//public class JournalController {
//    private Map<String, JournalEntry> JournalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> showJournals(){
//        return new ArrayList<>(JournalEntries.values());
//    }
//
//    @PostMapping
//    public boolean addJournal(@RequestBody JournalEntry myEntry){
//        JournalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{id}")
//    public JournalEntry giveOneEntry(@PathVariable Long id){
//
//        return JournalEntries.get(id);
//    }
//
//    @PutMapping("id/{id}")
//    public JournalEntry updateJournal(@PathVariable String id, @RequestBody JournalEntry tobeUpdatedEntry){
//        return JournalEntries.put(id, tobeUpdatedEntry);
//
//    }
//
//
//    @DeleteMapping("id/{id}")
//    public boolean deleteJournal(@PathVariable Long id){
//        JournalEntries.remove(id);
//        return true;
//    }
//}
