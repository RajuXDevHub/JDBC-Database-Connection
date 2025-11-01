import java.sql.*;

public class ThirdDemo {
    public static void main(String[] args) throws ClassNotFoundException{

        //? Step 1 : Creating the URL
        String url  = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";
        String query = "select * from employees;";

        //? This is for loading the Drivers
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully ");

        }catch (ClassNotFoundException e){
            System.out.println( e.getMessage());
        }

        //? Now for Established connections
        try {
            Connection con = DriverManager.getConnection(url,username,password); //? Connecting with the Database
            System.out.println("Connection Established successfully ............");
           Statement stmt =  con.createStatement();
           ResultSet rs = stmt.executeQuery(query);

           while ( rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String job_title = rs.getString("job_title");
               double salary =  rs.getDouble("salary");

               System.out.println();
               System.out.println("****************************");
               System.out.println("Id : "+id);
               System.out.println("Name: "+name);
               System.out.println("Job_Title : "+job_title);
               System.out.println("Salary is  : "+ salary);
           }

           rs.close();
           stmt.close();
           con.close();
            System.out.println();
            System.out.println("Connection closed Successfully ................");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}

