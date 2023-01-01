package ma.ac.emi.studentserver.repositories;

import ma.ac.emi.studentserver.entities.Absence;
import ma.ac.emi.studentserver.entities.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubjectRepository extends MongoRepository<Subject, String > {

}
