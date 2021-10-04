import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentTest {
    private static final String tempStudentName = "Test Dude";
    private static final DateTime tempStudentDOB = DateTime.now();
    private static final Integer tempStudentAge = 21;
    private static final Long tempStudentId = 10101010L;
    private static final ArrayList<Module> tempModuleList = new ArrayList<>();
    private static final ArrayList<Course> tempCourseList = new ArrayList<>();
    private Student target;
    private AutoCloseable closeable;

    @Mock
    private Module mockModule;

    @Mock
    private Course mockCourse;

    @BeforeEach
    public void prepareTest(){
        closeable = MockitoAnnotations.openMocks(this);
        target = spy(new Student());
    }

    @AfterEach
    public void concludeTest() throws Exception {
        target = null;
        tempModuleList.clear();
        tempCourseList.clear();
        closeable.close();
    }

    @Test
    public void testGetUserName(){
        target.setStudentName("Bill Richardson");
        target.setStudentAge(21);

        assertEquals(target.getUserName(),
                StringUtils.deleteWhitespace(target.getStudentName()) + "_" + target.getStudentAge());
    }

    @Test
    public void testStudent_RemoveModulesAndCourses(){
        target.addModule(mockModule);
        target.addCourse(mockCourse);

        assertTrue(target.getStudentModules().contains(mockModule));
        assertTrue(target.getStudentCourses().contains(mockCourse));

        target.removeModule(mockModule);
        target.removeCourse(mockCourse);

        assertFalse(target.getStudentModules().contains(mockModule));
        assertFalse(target.getStudentCourses().contains(mockCourse));
    }

    @Test
    public void testStudent_RemoveModulesAndCourses_NotFound(){
        assertFalse(target.getStudentModules().contains(mockModule));
        assertFalse(target.getStudentCourses().contains(mockCourse));

        target.removeModule(mockModule);
        target.removeCourse(mockCourse);

        verify(target, times(1)).removeModule(eq(mockModule));
        verify(target, times(1)).removeCourse(eq(mockCourse));
    }

    @Test
    public void testStudentConstructor_NoArrayListParameters(){
        tempModuleList.add(mockModule);
        tempCourseList.add(mockCourse);
        ArrayList<Course> tempCourseList = new ArrayList<>(List.of(mockCourse));
        target = new Student(tempStudentName, tempStudentAge, tempStudentDOB, tempStudentId);
        target.setStudentModules(tempModuleList);
        target.setStudentCourses(tempCourseList);

        constructorAssertions();
    }

    @Test
    public void testStudentContsructor_AllParametersInParenthesis(){
        initialiseArrayLists();
        target = new Student(tempStudentName, tempStudentAge, tempStudentDOB,tempStudentId,
                tempModuleList, tempCourseList);

        constructorAssertions();
    }

    @Test
    public void testStudentPrintOutput(){
        target.setStudentName(tempStudentName);
        target.setStudentDob(tempStudentDOB);
        target.setStudentId(tempStudentId);
        target.setStudentAge(tempStudentAge);
        target.addModule(mockModule);
        target.addCourse(mockCourse);

        System.out.println(target.toString());
        System.out.println(target.getStudentModules().toString());
        System.out.println(target.getStudentCourses().toString());

        verify(target, times(2)).getStudentName();
        verify(target, times(1)).getStudentId();
        verify(target, times(1)).getStudentDob();
        verify(target, times(2)).getStudentAge();
        verify(target, times(1)).getUserName();
        verify(target, times(1)).getStudentModules();
        verify(target, times(1)).getStudentCourses();
    }

    private void initialiseArrayLists(){
        tempModuleList.add(mockModule);
        tempCourseList.add(mockCourse);
    }

    private void constructorAssertions(){
        assertNotNull(target.getStudentName());
        assertNotNull(target.getStudentDob());
        assertTrue(target.getStudentModules().contains(mockModule));
        assertTrue(target.getStudentCourses().contains(mockCourse));
        assertEquals(tempStudentAge, target.getStudentAge());
        assertEquals(tempStudentId, target.getStudentId());
    }
}
