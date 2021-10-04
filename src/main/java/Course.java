import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * @author FilthyHound
 * @id 18321516
 */

public class Course {
    @Getter @Setter private String courseName;
    @Getter @Setter private ArrayList<Student> courseStudents = new ArrayList<>();
    @Getter @Setter private ArrayList<Module> courseModules = new ArrayList<>();
    @Getter @Setter private DateTime academicStartDate, academicEndDate;

    public Course() {
    }

    public Course(String courseName, DateTime academicStartDate, DateTime academicEndDate) {
        this.courseName = courseName;
        this.academicStartDate = academicStartDate;
        this.academicEndDate = academicEndDate;
    }

    public Course(String courseName, DateTime academicStartDate, DateTime academicEndDate,
                  ArrayList<Student> courseStudents, ArrayList<Module> courseModules) {
        this.courseName = courseName;
        this.courseStudents = courseStudents;
        this.courseModules = courseModules;
        this.academicStartDate = academicStartDate;
        this.academicEndDate = academicEndDate;
    }

    public void addStudent(Student s){
        if(!courseStudents.contains(s)) {
            courseStudents.add(s);
            s.addCourse(this);
        }
    }

    public void removeStudent(Student s){
        if(courseStudents.contains(s)){
            courseStudents.remove(s);
            s.removeCourse(this);
        }
    }

    public void addModule(Module m){
        if(!courseModules.contains(m)) {
            courseModules.add(m);
            m.addCourse(this);
        }
    }

    public void removeModule(Module m){
        if(courseModules.contains(m)){
            courseModules.remove(m);
            m.removeCourse(this);
        }
    }

    public String toString(){
        return "Name: " + getCourseName() + ", Academic Start Date: " + getAcademicStartDate()
                + ", Academic End Date: " + getAcademicEndDate() + "},\n";
    }
}
