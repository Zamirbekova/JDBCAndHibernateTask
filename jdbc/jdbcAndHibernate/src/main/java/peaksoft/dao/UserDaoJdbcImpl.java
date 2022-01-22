package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String Sql = "create table users" +
                "      (               id serial not null," +
                "                     name varchar(50) not null," +
                "                     last_name varchar(50) not null," +
                "                     age  int not  null);";

        try (
                Connection connection=Util.connection();
           Statement statement=connection.createStatement()){
           statement.executeUpdate(Sql);
            System.out.println("done");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void dropUsersTable() {
        String Sql = "DROP TABLE users";

       try (
               Connection connection=Util.connection();
         Statement statement=connection.createStatement()){
          statement.executeUpdate(Sql);
           System.out.println("drop");
        }catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL ="  INSERT INTO users(name,last_name,age) VALUES(?,?,?)";
        try(Connection conn =Util.connection();
            PreparedStatement prstmt = conn.prepareStatement(SQL)){
            prstmt.setString(1,name);
            prstmt.setString(2,lastName);
            prstmt.setByte(3,age);
            prstmt.executeUpdate();
            System.out.println("Save base");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void removeUserById(long id) {
        String Sql = "DELETE  from users WHERE id=1; ";

        try (
                Connection connection=Util.connection();
           Statement statement=connection.createStatement()){
            statement.executeUpdate(Sql);
            System.out.println("Remove id= "+ id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String SQL = "SELECT * FROM users;";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                users.add(new User(rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getByte("age")));

            }
            return users;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); System.out.println("Get oll users");
            return null;
        }
    }

    public void cleanUsersTable() {

       String sql = "DELETE FROM users";
        try (Connection connection = Util.connection();
              Statement statement = connection.createStatement()){
            final int i = statement.executeUpdate(sql);
             if (i>0){
                 System.out.println("delete all users");
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}