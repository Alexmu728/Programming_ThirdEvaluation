package Milestones.Milestone_5_AlexMurcia;

import Milestones.Milestone_5_AlexMurcia.Photographer;
import Milestones.Milestone_5_AlexMurcia.Picture;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DB_Connection {
    static final String SERVER_IP = "localhost";
    static final String DB_NAME = "Milestone5";
    static final String USER = "root";
    static final String PASSWORD= "root";
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://"+SERVER_IP+":3306/"+DB_NAME;

    private Connection connection;

    public DB_Connection(){
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

    public ArrayList<Picture> pictures(){
        ArrayList<Picture> picturs= new ArrayList<>();
        try{
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("Select * From Pictures");
            while(resultSet.next()){
                int pictureId= resultSet.getInt("PictureId");
                String title= resultSet.getString("Title");
                Date date= resultSet.getDate("Date");
                String file= resultSet.getString("File");
                int visits= resultSet.getInt("Visits");
                int photographerId= resultSet.getInt("PhotographerId");
                picturs.add(new Picture(pictureId, title, date, file, visits, photographerId));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return picturs;
    }

    //It does sum every time a picture is selected, but it sums in the wrong picture
    public void incrementVisits(Picture p){
        try{
            PreparedStatement statement= connection.prepareStatement("Update Pictures Set Visits=Visits+1 Where PictureId=?");
            statement.setInt(1, p.getPictureId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public HashMap<Integer, Integer> createVisitsMap(){
        HashMap<Integer, Integer> map= new HashMap<>();
        try{
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("Select * From Pictures");
            while (resultSet.next()){
                int pictureId= resultSet.getInt("PictureId");
                String title= resultSet.getString("Title");
                Date date= resultSet.getDate("Date");
                String file= resultSet.getString("File");
                int visits= resultSet.getInt("Visits");
                int photographerId= resultSet.getInt("PhotographerId");
                if(map.containsKey(photographerId)){
                    int newVisits=map.get(photographerId);
                    map.put(photographerId, newVisits+visits);
                }else{
                    map.put(photographerId, visits);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return map;
    }
    public void setAward(boolean awarded, int photoId){
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("Update Photographers Set Awarded=? where PhotographerId=? ");
            preparedStatement.setBoolean(1, awarded);
            preparedStatement.setInt(2, photoId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletePic(int picId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete From Pictures where PictureId=?");
            preparedStatement.setInt(1, picId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePhoto(int photoId){
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("Delete From Photographers where PhotographerId=?");
            preparedStatement.setInt(1, photoId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            connection.close();
            System.out.println("Disconnected from database");
        }catch (SQLException e){
            e.printStackTrace();;
        }
    }

}
