package Milestones.Milestone_4_AlexMurcia;

import java.sql.*;
import java.util.ArrayList;

public class DefaultListModel {
    static final String SERVER_IP = "localhost";
    static final String DB_NAME = "Milestone4";
    static final String USER = "root";
    static final String PASSWORD= "root";
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://"+SERVER_IP+":3306/"+DB_NAME;

    private Connection connection;

    public DefaultListModel(){
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public ArrayList<Photographer> photographers(){
        ArrayList<Photographer> photographs= new ArrayList<>();
        try{
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("Select * From Photographers");
                while(resultSet.next()){
                    int photographerId=resultSet.getInt("PhotographerId");
                    String name=resultSet.getString("Name");
                    boolean awarded= resultSet.getBoolean("Awarded");
                    photographs.add(new Photographer(photographerId, name, awarded));
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return photographs;
    }




    public void close(){
        try{
            connection.close();
            System.out.println("Disconnected from database");
        }catch (SQLException e){
            e.printStackTrace();;
        }
    }

    /*public static void main(String[] args) {
        DefaultListModel dlm= new DefaultListModel();
        dlm.close();
    }*/
}
