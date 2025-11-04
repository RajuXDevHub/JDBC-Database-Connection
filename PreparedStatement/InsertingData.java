package PreparedStatement;

import java.sql.*;
import java.util.Scanner;

public class InsertingData {
    public static void main(String[] args) {
        System.out.println("This is for Understanding PreparedStatement In JDBC ");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";
        String sql = "INSERT INTO employees(id, name , job_title , salary ) VALUES ( ?, ?, ?, ?);";

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

            System.out.println(" FIll the given Interactions to Insert Data in the Database ....");
            Scanner snc = new Scanner(System.in);
            System.out.print("Enter id :  ");
            int id = snc.nextInt();
            snc.nextLine();
            System.out.print("Enter Name :  ");
            String  name = snc.nextLine();

            System.out.print("Enter Job Title :  ");
            String JobTitle = snc.nextLine();

            System.out.print("Enter Salary :  ");
            double salary = snc.nextDouble();
//            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,JobTitle);
            preparedStatement.setDouble(4,salary);

            int rowsAffect = preparedStatement.executeUpdate();
            if ( rowsAffect > 0 ){
                System.out.println("Data Inserted successfully .....");
            }else {
                System.out.println("Data Insertion Failed .....");
            }


            preparedStatement.close();
            connection.close();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
