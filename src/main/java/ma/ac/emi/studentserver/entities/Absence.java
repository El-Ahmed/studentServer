package ma.ac.emi.studentserver.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("absence")
public class Absence {

    @Id
    private String id;

    @DBRef
    @JsonBackReference
    private Student student;

    @DBRef
    private Session session;

    private Boolean isAbsent;


    public Absence(String id, Student student, Session session, Boolean isAbsent) {
        this.id = id;
        this.student = student;
        this.session = session;
        this.isAbsent = isAbsent;
    }

    public Boolean getIsAbsent() {
        return isAbsent;
    }

    public Session getSession() {
        return session;
    }

    public Student getStudent() {
        return student;
    }

    public void setAbsent(Boolean absent) {
        this.isAbsent = absent;
    }
}
