import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author FilthyHound
 * @id 18321516
 */

public class ModuleTest {
    private static final String tempModuleName = "Test Module", tempModuleId = "MOD101";
    private static final ArrayList<Student> tempStudentList = new ArrayList<>();
    private static final ArrayList<Course> tempCourseList = new ArrayList<>();
    private Module target;
    private AutoCloseable closeable;

    @Mock
    private Student mockStudent;

    @Mock
    private Course mockCourse;

    @BeforeEach
    public void prepareTest(){
        closeable = MockitoAnnotations.openMocks(this);
        target = spy(new Module());
    }

    @AfterEach
    public void concludeTest() throws Exception {
        target = null;
        tempStudentList.clear();
        tempCourseList.clear();
        closeable.close();
    }

    @Test
    public void testModule_RemoveStudentsAndCourses(){
        target.addStudent(mockStudent);
        target.addCourse(mockCourse);

        assertTrue(target.getModuleStudents().contains(mockStudent));
        assertTrue(target.getModuleCourses().contains(mockCourse));

        target.removeStudent(mockStudent);
        target.removeCourse(mockCourse);

        assertFalse(target.getModuleStudents().contains(mockStudent));
        assertFalse(target.getModuleCourses().contains(mockCourse));
    }

    @Test
    public void testModule_RemoveModulesAndCourses_NotFound(){
        assertFalse(target.getModuleStudents().contains(mockStudent));
        assertFalse(target.getModuleCourses().contains(mockCourse));

        target.removeStudent(mockStudent);
        target.removeCourse(mockCourse);

        verify(target, times(1)).removeStudent(eq(mockStudent));
        verify(target, times(1)).removeCourse(eq(mockCourse));
    }

    @Test
    public void testModuleConstructor_NoArrayListParameters(){
        tempStudentList.add(mockStudent);
        tempCourseList.add(mockCourse);
        ArrayList<Course> tempCourseList = new ArrayList<>(List.of(mockCourse));
        target = new Module(tempModuleName, tempModuleId);
        target.setModuleStudents(tempStudentList);
        target.setModuleCourses(tempCourseList);

        constructorAssertions();
    }

    @Test
    public void testModuleContsructor_AllParametersInParenthesis(){
        initialiseArrayLists();
        target = new Module(tempModuleName, tempModuleId, tempStudentList, tempCourseList);

        constructorAssertions();
    }

    @Test
    public void testModulePrintOutput(){
        target.setModuleName(tempModuleName);
        target.setModuleId(tempModuleId);
        target.addStudent(mockStudent);
        target.addCourse(mockCourse);

        System.out.println(target.toString());
        System.out.println(target.getModuleStudents().toString());
        System.out.println(target.getModuleCourses().toString());

        verify(target, times(1)).getModuleName();
        verify(target, times(1)).getModuleId();
        verify(target, times(1)).getModuleStudents();
        verify(target, times(1)).getModuleCourses();
    }

    private void initialiseArrayLists(){
        tempStudentList.add(mockStudent);
        tempCourseList.add(mockCourse);
    }

    private void constructorAssertions(){
        assertNotNull(target.getModuleName());
        assertNotNull(target.getModuleId());
        assertTrue(target.getModuleStudents().contains(mockStudent));
        assertTrue(target.getModuleCourses().contains(mockCourse));
        assertEquals(tempModuleName, target.getModuleName());
        assertEquals(tempModuleId, target.getModuleId());
    }
}
