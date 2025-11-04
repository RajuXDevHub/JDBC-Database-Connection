package PreparedStatement;

import java.sql.*;

public class PreparedStatementUnderstanding {
    public static void main(String[] args) {
        System.out.println("This is for Understanding PreparedStatement In JDBC ");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";
        String sql = "SELECT * FROM employees WHERE id = ? AND name = ?;";

        //? This is for Driver Loading purpose
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        //? Now Connection Purpose
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected Successfully ....");
//            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,5);
            preparedStatement.setString(2,"Raj Roy");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");
                System.out.println();
                System.out.println("****************");
                System.out.println("ID : "+id);
                System.out.println("Name  : "+name);
                System.out.println("Job Title  : "+job_title);
                System.out.println("Salary : "+salary);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
