package ma.ac.emi.studentserver;

import ma.ac.emi.studentserver.entities.*;
import ma.ac.emi.studentserver.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class StudentServerApplicationTests {
   @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void populate() {
        studentRepository.deleteAll();
        teacherRepository.deleteAll();
        sessionRepository.deleteAll();
        subjectRepository.deleteAll();
        absenceRepository.deleteAll();
        // create 2 students
        Student student = new Student("ahmed", "ahmed", "pass0");
        studentRepository.save(student);
        Student student2 = new Student("ahmed2", "ahmed2", "pass");
        studentRepository.save(student2);

        // create teacher
        Teacher teacher = new Teacher("bah", "Bah", "Teach");
        teacherRepository.save(teacher);

        // create 2 subject
        Subject subject = new Subject("Math", "Math", teacher);
        subjectRepository.save(subject);
        Subject subject2 = new Subject("PC", "PC", teacher);
        subjectRepository.save(subject2);


        //create session
        Session session = new Session("qr1", "qr1", new Date(), subject);
        sessionRepository.save(session);
        Absence absence = new Absence("ahmed", student,session,true);
        Absence absence2 = new Absence("ahmed2", student2,session,true);

        absenceRepository.save(absence);
        absenceRepository.save(absence2);
    }

    @Test
    void addSession() {
        Student student = new Student("ahmed", "ahmed", "pass0");
        Student student2 = new Student("ahmed2", "ahmed2", "pass");
        Teacher teacher = new Teacher("bah", "Bah", "Teach");
        Subject subject2 = new Subject("PC", "PC", teacher);
         //create session
        Session session = new Session("qr2", "qr2", new Date(), subject2);
        sessionRepository.save(session);
        Absence absence = new Absence("ahmeds2", student,session,true);
        Absence absence2 = new Absence("ahmed2s2", student2,session,true);

        absenceRepository.save(absence);
        absenceRepository.save(absence2);

    }

    @Test
    void testLastH() {
//        System.out.println(absenceRepository.findFirstByStudentAndAndIsAbsentIsFalse(new Student("id0","id0", "id0")));

    }
}
