package dataBaseTest;

import jdbc.DBconfig;
import org.testng.annotations.Test;

public class GetStudents {
    @Test
    public void sqlQuvery(){
//        List<StudentsDTOsql> students = CRUD.getStudentData("SELECT * FROM students");
//        System.out.println(students);
        DBconfig.getConnection();

    }

}
