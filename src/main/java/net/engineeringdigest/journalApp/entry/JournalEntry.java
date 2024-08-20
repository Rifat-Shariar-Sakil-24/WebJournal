package net.engineeringdigest.journalApp.entry;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("journal_entries")
@Data
public class JournalEntry {
    @Id
    private String id;
    private String title;
    private String content;
}
