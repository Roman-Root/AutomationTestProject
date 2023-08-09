package jdbc;

import sql.dtoModel.StudentsDTOsql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    public static List<StudentsDTOsql> getStudentData(String query){
        List<StudentsDTOsql> students = new ArrayList<>();

        try (Connection connection = DBconfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Integer artistId = resultSet.getInt("ArtistId");
                String name = resultSet.getString("Name");


                students.add(new StudentsDTOsql(artistId, name));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

}
