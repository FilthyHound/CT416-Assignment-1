import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    public Student target;

    @BeforeEach
    public void prepareTest(){
        target = new Student();
    }

    @AfterEach
    public void concludeTest(){
        target = null;
    }

    @Test
    public void testGetUserName(){
        target.setStudentName("Bill Richardson");
        target.setStudentAge(21);

        assertEquals(target.getUserName(), target.getStudentName() + target.getStudentAge());
    }
}
