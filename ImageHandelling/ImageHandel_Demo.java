package ImageHandelling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageHandel_Demo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";

        String imagePath = "/Users/rajuchowdhury/Documents/Programming/Total Java/Java Spring Enterprises/JDBC-Class/src/ImageHandelling/Sself.png";
        String query = " INSERT INTO image_table (image_data ) VALUES (?); ";

        //? Driver Loading
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully ");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //? Connection established
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connected successfully ....");
            FileInputStream fileInputStream = new FileInputStream(imagePath);

            byte[] imageData =new byte[fileInputStream.available()];
            fileInputStream.read(imageData);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBytes(1,imageData);
            int affectedRows = preparedStatement.executeUpdate();
            if ( affectedRows > 0){
                System.out.println("Image inserted successfully ");
            }else {
                System.out.println("Image not inserted ..");
            }

            fileInputStream.close();





        }catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
