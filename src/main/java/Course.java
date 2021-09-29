import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * @author FilthyHound
 * @id 18321516
 * @date 29/09/2021
 */

public class Course {
    @Getter @Setter private String courseName;
    @Getter @Setter private ArrayList<Student> courseStudents;
    @Getter @Setter private ArrayList<Module> courseModules;
    @Getter @Setter private DateTime academicStartDate, academicEndDate;

    public Course() {
    }

    public Course(String courseName, ArrayList<Student> courseStudents, ArrayList<Module> courseModules, DateTime academicStartDate, DateTime academicEndDate) {
        this.courseName = courseName;
        this.courseStudents = courseStudents;
        this.courseModules = courseModules;
        this.academicStartDate = academicStartDate;
        this.academicEndDate = academicEndDate;
    }
}
