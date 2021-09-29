import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author FilthyHound
 * @id 18321516
 * @date 29/09/2021
 */

public class Module {
    @Getter @Setter private String moduleName, moduleId;
    @Getter @Setter private ArrayList<Student> moduleStudents;
    @Getter @Setter private ArrayList<Course> moduleCourses;

    public Module() {
    }

    public Module(String moduleName, String moduleId) {
        this.moduleName = moduleName;
        this.moduleId = moduleId;
    }

    public Module(String moduleName, String moduleId, ArrayList<Student> moduleStudents, ArrayList<Course> moduleCourses) {
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.moduleStudents = moduleStudents;
        this.moduleCourses = moduleCourses;
    }
}
