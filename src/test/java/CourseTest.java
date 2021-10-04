import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author FilthyHound
 * @id 18321516
 */

public class CourseTest {
    private static final String tempCourseName = "Test Module";
    private static final DateTime tempStartDate = DateTime.now(), tempEndDate = DateTime.now();
    private static final ArrayList<Student> tempStudentList = new ArrayList<>();
    private static final ArrayList<Module> tempModuleList = new ArrayList<>();
    private Course target;
    private AutoCloseable closeable;

    @Mock
    private Student mockStudent;

    @Mock
    private Module mockModule;

    @BeforeEach
    public void prepareTest(){
        closeable = MockitoAnnotations.openMocks(this);
        target = spy(new Course());
    }

    @AfterEach
    public void concludeTest() throws Exception {
        target = null;
        tempStudentList.clear();
        tempModuleList.clear();
        closeable.close();
    }

    @Test
    public void testModule_RemoveStudentsAndCourses(){
        target.addStudent(mockStudent);
        target.addModule(mockModule);

        assertTrue(target.getCourseStudents().contains(mockStudent));
        assertTrue(target.getCourseModules().contains(mockModule));

        target.removeStudent(mockStudent);
        target.removeModule(mockModule);

        assertFalse(target.getCourseStudents().contains(mockStudent));
        assertFalse(target.getCourseModules().contains(mockModule));
    }

    @Test
    public void testModule_RemoveModulesAndCourses_NotFound(){
        assertFalse(target.getCourseStudents().contains(mockStudent));
        assertFalse(target.getCourseModules().contains(mockModule));

        target.removeStudent(mockStudent);
        target.removeModule(mockModule);

        verify(target, times(1)).removeStudent(eq(mockStudent));
        verify(target, times(1)).removeModule(eq(mockModule));
    }

    @Test
    public void testModuleConstructor_NoArrayListParameters(){
        tempStudentList.add(mockStudent);
        tempModuleList.add(mockModule);
        ArrayList<Module> tempCourseList = new ArrayList<>(List.of(mockModule));
        target = new Course(tempCourseName, tempStartDate, tempEndDate);
        target.setCourseStudents(tempStudentList);
        target.setCourseModules(tempCourseList);

        constructorAssertions();
    }

    @Test
    public void testModuleContsructor_AllParametersInParenthesis(){
        initialiseArrayLists();
        target = new Course(tempCourseName, tempStartDate, tempEndDate, tempStudentList, tempModuleList);

        constructorAssertions();
    }

    @Test
    public void testModulePrintOutput(){
        target.setCourseName(tempCourseName);
        target.setAcademicStartDate(tempStartDate);
        target.setAcademicEndDate(tempEndDate);
        target.addStudent(mockStudent);
        target.addModule(mockModule);

        System.out.println(target.toString());
        System.out.println(target.getCourseStudents().toString());
        System.out.println(target.getCourseModules().toString());

        verify(target, times(1)).getCourseName();
        verify(target, times(1)).getAcademicStartDate();
        verify(target, times(1)).getAcademicEndDate();
        verify(target, times(1)).getCourseStudents();
        verify(target, times(1)).getCourseModules();
    }

    private void initialiseArrayLists(){
        tempStudentList.add(mockStudent);
        tempModuleList.add(mockModule);
    }

    private void constructorAssertions(){
        assertNotNull(target.getCourseName());
        assertNotNull(target.getAcademicStartDate());
        assertNotNull(target.getAcademicEndDate());
        assertTrue(target.getCourseStudents().contains(mockStudent));
        assertTrue(target.getCourseModules().contains(mockModule));
        assertEquals(tempCourseName, target.getCourseName());
    }
}
