import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author FilthyHound
 * @id 18321516
 */

public class Module {
    @Getter @Setter private String moduleName, moduleId;
    @Getter @Setter private ArrayList<Student> moduleStudents = new ArrayList<>();
    @Getter @Setter private ArrayList<Course> moduleCourses = new ArrayList<>();

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

    public void addStudent(Student s){
        if(!moduleStudents.contains(s)) {
            moduleStudents.add(s);
            s.addModule(this);
        }
    }

    public void removeStudent(Student s){
        if(moduleStudents.contains(s)){
            moduleStudents.remove(s);
            s.removeModule(this);
        }
    }

    public void addCourse(Course c){
        if(!moduleCourses.contains(c)) {
            moduleCourses.add(c);
            c.addModule(this);
        }
    }

    public void removeCourse(Course c){
        if(moduleCourses.contains(c)){
            moduleCourses.remove(c);
            c.removeModule(this);
        }
    }

    @Override
    public String toString(){
        return "{Name: " + getModuleName() + ", ID: " + getModuleId() +"},\n";
    }
}
