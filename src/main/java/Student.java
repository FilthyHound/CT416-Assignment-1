import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * @author FilthyHound
 * @id 18321516
 * @date 29/09/2021
 */

public class Student {
    @Getter @Setter private String studentName;
    @Getter @Setter private int studentAge;
    @Getter @Setter private DateTime studentDob;
    @Getter @Setter private long studentId;
    private String userName;
    @Getter @Setter private ArrayList<Module> studentModules;
    @Getter @Setter private ArrayList<Course> studentCourses;

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

    public String getUserName(){
        return getStudentName() + getStudentAge();
    }
}
