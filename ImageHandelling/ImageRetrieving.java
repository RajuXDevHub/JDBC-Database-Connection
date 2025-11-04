package ImageHandelling;

import java.io.*;
import java.sql.*;

public class ImageRetrieving {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Raju@123";

        String pkgPath = "/Users/rajuchowdhury/Documents/Programming/Total Java/Java Spring Enterprises/JDBC-Class/src/ImageHandelling/";

        String query = " SELECT image_data FROM image_table WHERE image_id = (? )";

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
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setInt(1,1);

            ResultSet resultSet= preparedStatement.executeQuery();
            if ( resultSet.next()){
                byte[] image_data = resultSet.getBytes("image_data");
                String imagePath = pkgPath+"extracted_image.png";
                OutputStream outputStream = new FileOutputStream(imagePath);
                outputStream.write(image_data);
                System.out.println("Image found ...");
            }else{
                System.out.println("Image not found ");
            }





        }catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
