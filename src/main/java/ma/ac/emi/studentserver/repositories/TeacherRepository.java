package ma.ac.emi.studentserver.repositories;

import ma.ac.emi.studentserver.entities.Absence;
import ma.ac.emi.studentserver.entities.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher, String > {

}
