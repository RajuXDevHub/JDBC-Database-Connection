package Insert_Data;

import java.sql.*;

public class InsertData {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";
        String query = "INSERT INTO employees ( id , name , job_title , salary ) VALUES ( 4 , 'Nilanjana Chowdhury' , 'Data Engineer', 77000.0);";


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
            int rowsaffected = stmt.executeUpdate(query); //? this is for the insertion query

            if ( rowsaffected >0 ){
                System.out.println("Inserted Successfully in the Database ......."+ rowsaffected + "row(s) affected ");
            }else {
                System.out.println("Insertion Failed ......");
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
