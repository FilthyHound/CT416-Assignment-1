import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * @author FilthyHound
 * @id 18321516
 * @date 29/09/2021
 */

public class Student {
    @Getter
    @Setter
    private String studentName;
    @Getter
    @Setter
    private int studentAge;
    @Getter
    @Setter
    private DateTime studentDob;
    @Getter
    @Setter
    private long studentId;
    private String userName;
    @Getter
    @Setter
    private ArrayList<Module> studentModules = new ArrayList<>();
    @Getter
    @Setter
    private ArrayList<Course> studentCourses = new ArrayList<>();

    public Student() {
    }

    public Student(String studentName, int age, DateTime dob, long studentId) {
        this.studentName = studentName;
        this.studentAge = age;
        this.studentDob = dob;
        this.studentId = studentId;
    }

    public Student(String studentName, int age, DateTime dob, long studentId, ArrayList<Module> modules, ArrayList<Course> courses) {
        this.studentName = studentName;
        this.studentAge = age;
        this.studentDob = dob;
        this.studentId = studentId;
        this.studentModules = modules;
        this.studentCourses = courses;
    }

    public String getUserName() {
        return getStudentName() + getStudentAge();
    }

    public void addModule(Module m) {
        if (!studentModules.contains(m)) {
            studentModules.add(m);
            m.addStudent(this);
        }
    }

    public void removeModule(Module m) {
        if (studentModules.contains(m)) {
            studentModules.remove(m);
            m.removeStudent(this);
        }
    }

    public void addCourse(Course c) {
        if (!studentCourses.contains(c)) {
            studentCourses.add(c);
            c.addStudent(this);
        }
    }

    public void removeCourse(Course c) {
        if (studentCourses.contains(c)) {
            studentCourses.remove(c);
            c.removeStudent(this);
        }
    }
}
