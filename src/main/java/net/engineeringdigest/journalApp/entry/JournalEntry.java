package net.engineeringdigest.journalApp.entry;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("journal_entries")
@Getter
@Setter
public class JournalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String content;
}
