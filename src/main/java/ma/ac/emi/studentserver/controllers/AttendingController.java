package ma.ac.emi.studentserver.controllers;

import ma.ac.emi.studentserver.entities.*;
import ma.ac.emi.studentserver.models.History;
import ma.ac.emi.studentserver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.*;

@RestController
@CrossOrigin
public class AttendingController {

    @Autowired
    AuthenticationManager authenticationManager;
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


    @GetMapping("/populate")
    public String populate() {

        Student student = new Student("ahmed", "ahmed", "pass");
        studentRepository.save(student);

        Teacher teacher = new Teacher("id0", "bah", "bah");
        teacherRepository.save(teacher);
        Subject subject = new Subject("id0", "Math", teacher);
        subjectRepository.save(subject);
        Session session = new Session("id0", "qr1", new Date(), subject);
        sessionRepository.save(session);
        Absence absence = new Absence("id0", student,session,true);

        absenceRepository.save(absence);


        return "done";
    }

    @GetMapping("/attend")
    public ResponseEntity<History> attend(String qrCode, Principal principal) {


        Optional<Student> student = studentRepository.findByUserName(principal.getName());
        Optional<Session> session = sessionRepository.findByQrCode(qrCode);
        if (session.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (student.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Optional<Absence> OAbsence = absenceRepository.findBySessionAndStudent(session.get(), student.get());
        if (OAbsence.isPresent()) {
            Absence absence = OAbsence.get();
            absence.setAbsent(false);
            absenceRepository.save(absence);
        }
        return ResponseEntity.ok(new History(session.get()));
    }

    @GetMapping("/history")
    public List<History> getHistory(Principal principal) throws Exception {

        Optional<Student> student = studentRepository.findByUserName(principal.getName());
        if (student.isEmpty()) {
            throw new Exception("wrong user");
        }
        List<History> histories = absenceRepository.findAllByStudent(student.get()).stream().map(History::new).toList();
        histories = new ArrayList<>(histories);
        Collections.reverse(histories);

        return histories;
    }

    @GetMapping("/lastHistory")
    public ResponseEntity<History> getLastHistory(Principal principal) {
        Optional<Student> student = studentRepository.findByUserName(principal.getName());
        if (student.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<Absence> absence = absenceRepository.findAllByStudent(student.get());

        if (absence.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new History(absence.get(absence.size()-1)));
    }
}
