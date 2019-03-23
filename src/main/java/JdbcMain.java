import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class JdbcMain {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useSSL=false";
        String databaseUsername = "root";
        String databasePassword = "DUpadupa123!!";
        Properties properties = new Properties();
        properties.put("user", databaseUsername);
        properties.put("password", databasePassword);
        Connection connection = DriverManager.getConnection(url, properties);

//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery
//                    ("select first_name from sakila.actor where id=? and name = ?");
//            doSomethingWith(resultSet);
//        }
        Integer actor_id = 2;
        String name = "NICK";
        String query  = "select first_name from actor where actor_id=? and first_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,actor_id);
            statement.setString(2, name);
            boolean execute = statement.execute();
            if(execute){
                ResultSet resultSet = statement.getResultSet();

                resultSet.close();
            }

        }

        connection.close();
    }

    private static void doSomethingWith(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int column1 = resultSet.getInt(1);
            String column2 = resultSet.getString(2);
            String column3 = resultSet.getString(3);
            String column4 = resultSet.getString(4);
            String row = new StringJoiner(", ")
                    .add(String.valueOf(column1)).add(column2)
                    .add(column3).add(column4)
                    .toString();
            System.out.println(row);
        }
        resultSet.close();
    }

    private static void doSomethingWith2 (ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {

            String column2 = resultSet.getString(2);
            String row = new StringJoiner(", ")
                    .toString();
            System.out.println(row);
        }
        resultSet.close();
    }

}
