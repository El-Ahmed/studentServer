package ma.ac.emi.studentserver.repositories;

import ma.ac.emi.studentserver.entities.Absence;
import ma.ac.emi.studentserver.entities.Session;
import ma.ac.emi.studentserver.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AbsenceRepository extends MongoRepository<Absence, String > {

    Optional<Absence> findBySessionAndStudent(Session session, Student student);

    List<Absence> findAllByStudent(Student student);
    Optional<Absence> findFirstByStudentAndAndIsAbsentIsFalse(Student student);
}
