package service;

import Model.User;
import dbConnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    //DB value insert:
    public void insertUser(User user) {
        //Query SQL:
        String query = "insert into user(username, email, address, password)" + "values(?,?,?,?)";

        // Prepared Statement:
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE USER:
    public void deleteUser(int id){

        String query = "delete from user where id=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);

        try {
            preparedStatement.setInt(1,id); //peremeter id:
            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }



    }


}
