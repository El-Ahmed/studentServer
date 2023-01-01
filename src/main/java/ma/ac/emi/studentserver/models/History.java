package ma.ac.emi.studentserver.models;

import ma.ac.emi.studentserver.entities.Absence;
import ma.ac.emi.studentserver.entities.Session;
import ma.ac.emi.studentserver.entities.Subject;
import ma.ac.emi.studentserver.entities.Teacher;

import java.util.Date;

public class History {
    private String courseName;
    private Date date;
    private String teacherName;
    private boolean presence;

    public History(Absence absence) {
        Session session = absence.getSession();
        Subject subject = session.getSubject();
        Teacher teacher = subject.getTeacher();
        this.teacherName = teacher.getFirstName()+ " " + teacher.getLastName();
        this.date = session.getDate();
        this.courseName = subject.getName();
        this.presence = !absence.getIsAbsent();
    }
    public History(Session session) {
        Subject subject = session.getSubject();
        Teacher teacher = subject.getTeacher();
        this.teacherName = teacher.getFirstName()+ " " + teacher.getLastName();
        this.date = session.getDate();
        this.courseName = subject.getName();
        this.presence = true;
    }

    public String getCourseName() {
        return courseName;
    }

    public Date getDate() {
        return date;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public boolean isPresent() {
        return presence;
    }
}
