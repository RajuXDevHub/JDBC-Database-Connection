package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatingPreparedStatement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";
        String query = " UPDATE employees set id = ? , name = ? , job_title = ? , salary = ? WHERE id = 8; ";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully .........");

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,8 );
            preparedStatement.setString(2,"Rai Chowdhury" );
            preparedStatement.setString(3,"SDE INTERN" );
            preparedStatement.setDouble(4,80000.0 );

            int rowsAffected = preparedStatement.executeUpdate();

            if ( rowsAffected > 0 ){
                System.out.println("Updating process successfully done.....");
            }else {
                System.out.println("Failed ....");
            }
            preparedStatement.close();
            connection.close();






        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
