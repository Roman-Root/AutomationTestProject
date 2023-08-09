package jdbc;

import java.sql.*;

public class DBconfig {

    public static Connection getConnection() {

        String jdbcUrl = "jdbc:sqlite:C:/Users/korne/AppData/Roaming/DBeaverData/workspace6/.metadata/sample-database-sqlite-1/Chinook.db";

        Connection connection;
        try {
            connection = DriverManager.getConnection(jdbcUrl);
            String sql = "SELECT * FROM Artist";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Integer artistId = resultSet.getInt("ArtistId");
                String name = resultSet.getString("Name");

                System.out.println(artistId + " " + name);

            }

        } catch (SQLException e) {
            System.out.println("Error connection!");
            throw new RuntimeException(e);
        }

//        // Используйте константы для хранения имени файла свойств и параметров подключения
//        final String PROPERTIES_FILE = "src/main/resources/config.properties";
//        System.out.println(PROPERTIES_FILE);
//
//        // Создайте объект Properties для хранения настроек базы данных
//        Properties properties = new Properties();
//
//        // Используйте try-with-resources для автоматического закрытия потока ввода
//        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE)) {
//            // Загрузите свойства из файла
//            properties.load(fis);
//        } catch (FileNotFoundException e) {
//            // Если файл не найден, выбросите исключение с сообщением об ошибке
//            throw new RuntimeException("Файл свойств не найден: " + PROPERTIES_FILE, e);
//        } catch (IOException e) {
//            // Если произошла ошибка ввода-вывода, выбросите исключение с сообщением об ошибке
//            throw new RuntimeException("Ошибка при чтении файла свойств: " + PROPERTIES_FILE, e);
//        }
//
//        // Получите строку подключения к базе данных из свойств
//        String dbURL = properties.getProperty("dbhost");
//
//        // Создайте объект Connection для подключения к базе данных
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(dbURL);
//        } catch (SQLException e) {
//            // Если произошла ошибка при подключении к базе данных, выбросите исключение с сообщением об ошибке и причиной
//            throw new RuntimeException("Ошибка при подключении к базе данных: " + dbURL, e);
//        }
        return connection;

    }
}
