package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int registerEmployee(UserEntity employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
                " (first_name, last_name, username, password) VALUES " +
                " (?, ?, ?, ?);";

        int result = 0;
        try (Connection connection = DbConn.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            DbConn.printSQLException(e);
        }
        return result;
    }
}
