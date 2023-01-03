package ma.ac.emi.studentserver.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    public Teacher(String id, String firstName, String lastName) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
