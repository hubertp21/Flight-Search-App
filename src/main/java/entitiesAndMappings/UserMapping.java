package entitiesAndMappings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserMapping {

    private final User user;

    public UserMapping(User user) {
        this.user = user;
    }

    public boolean checkIfLogged(Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(user.verifyLogin);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkIfRegistered(Connection connection) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(user.addUser);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
