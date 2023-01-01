package ma.ac.emi.studentserver.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("student")
public class Student {
    @Id
    private String id;

    private String userName;
    private String passWord;

    public Student(String id, String userName, String passWord) {
        this.id = id;
        this.userName=userName;
        this.passWord=passWord;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
