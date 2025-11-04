package Delete_Data;

import java.sql.*;

public class DeleteData {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";
        String query = "Delete from employees WHERE id = 8 ;";


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
            int rowsaffected = stmt.executeUpdate(query);
            if ( rowsaffected > 0 ){
                System.out.println(" Delete successfully from the DataBase ");
            }else{
                System.out.println("Deletion Failed  ");
            }

            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed Successfully.....................");

        }catch ( SQLException e ){
            System.out.println(e.getMessage());
        }
    }
}
