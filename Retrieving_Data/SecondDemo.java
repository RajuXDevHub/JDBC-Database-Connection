package Retrieving_Data;

import java.sql.*;

public class SecondDemo {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";
        String query = "Select * from employees ;";


        //? This is for loading all the drivers from the SQL
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully !!");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }



        //? This is the connection Established part ......
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Established Successfully !!");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query); //? executeQuery() is for fatch
            while (rs.next()){
                int id = rs.getInt("id");
                String name  = rs.getString("name");
                String jobTitle  = rs.getString("job_title");
                double Salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("***************************************");
                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Job_Title : "+jobTitle );
                System.out.println( "Salary : "+Salary);
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed Successfully.....................");

        }catch ( SQLException e ){
            System.out.println(e.getMessage());
        }
    }
}
