package ma.ac.emi.studentserver.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("session")
public class Session {

    @Id
    private String id;
    private String qrCode;
    private Date date;

    @DBRef
    private Subject subject;


    public Session(String id, String qrCode, Date date, Subject subject){
        this.id = id;
        this.qrCode = qrCode;
        this.date = date;
        this.subject = subject;
    }
    public String getId() { return id; }

    public Date getDate() {
        return date;
    }

    public Subject getSubject() {
        return subject;
    }
}
