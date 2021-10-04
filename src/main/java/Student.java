import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * @author FilthyHound
 * @id 18321516
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
        return StringUtils.deleteWhitespace(getStudentName()) + "_" + getStudentAge();
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

    @Override
    public String toString(){
        return "{Name: " + getStudentName() + ", Age: " + getStudentAge() + ", ID: " + getStudentId()
                + ", User Name: "+ getUserName() + ", DOB: " + getStudentDob() + "},\n";
    }
}
