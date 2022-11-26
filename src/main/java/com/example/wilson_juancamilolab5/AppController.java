package com.example.wilson_juancamilolab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppController {

    private Connection conn;
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";

    @FXML private TextField titleGame,idPlayerI,firstNamePlayerI,lastNamePlayerI,addressPlayerI,postalCodePlayerI,provincePlayerI,phonePlayerI;
    @FXML private TextField idPlayerU,firstNamePlayerU,lastNamePlayerU,addressPlayerU,postalCodePlayerU,provincePlayerU,phonePlayerU;

    public void createGame(javafx.event.ActionEvent actionEvent) {
        try{
            String title = titleGame.getText();
            // load the driver class
            Class.forName(DRIVER );
            // establish connection to database

            conn = DriverManager.getConnection(DATABASE_URL, "COMP228_m22_sl_30", "password" );

            PreparedStatement pst = conn.prepareStatement("INSERT INTO GAME VALUES(SEQ_GAME.NEXTVAL,?)");
            pst.setString(1, title);

            //Execute the prepared statement using executeUpdate method: �
            int val = pst.executeUpdate(); //returns the row count
            DialogsFX.showInformation("Adding game","Game information added successfully");
        }
        catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
            DialogsFX.showError("Adding game","Error adding game information");
        }
        finally
        {
            if (conn != null) {
                try {
                    conn.close(); // close the connection after you're finnished with it
                } catch (SQLException ex) {/*nothing here*/}
                conn = null;
            }

        }
        System.out.println(titleGame.getText());
    }

    public void createPlayer(ActionEvent actionEvent) {
        try{
            int id = Integer.parseInt(idPlayerI.getText());
            String fname = firstNamePlayerI.getText();
            String lname = lastNamePlayerI.getText();
            String address = addressPlayerI.getText();
            String postalCode = postalCodePlayerI.getText();
            String province = provincePlayerI.getText();
            String phoneNumber = phonePlayerI.getText();

            // load the driver class
            Class.forName(DRIVER );
            // establish connection to database

            conn = DriverManager.getConnection(DATABASE_URL, "COMP228_m22_sl_30", "password" );

            PreparedStatement pst = conn.prepareStatement("INSERT INTO PLAYER VALUES(?,?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, address);
            pst.setString(5, postalCode);
            pst.setString(6, province);
            pst.setString(7, phoneNumber);

            //Execute the prepared statement using executeUpdate method: �
            int val = pst.executeUpdate(); //returns the row count

            DialogsFX.showInformation("Adding player","Player information added successfully");
            System.out.print("Success row added");
        }
        catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
            DialogsFX.showError("Adding player","Error adding player information");
        }
        finally
        {
            if (conn != null) {
                try {
                    conn.close(); // close the connection after you're finnished with it
                } catch (SQLException ex) {/*nothing here*/}
                conn = null;
            }

        }
    }

    public void updatePlayer(ActionEvent actionEvent) {
        try{
            int id = Integer.parseInt(idPlayerU.getText());
            String fname = firstNamePlayerU.getText();
            String lname = lastNamePlayerU.getText();
            String address = addressPlayerU.getText();
            String postalCode = postalCodePlayerU.getText();
            String province = provincePlayerU.getText();
            String phoneNumber = phonePlayerU.getText();
            // load the driver class
            Class.forName(DRIVER );
            // establish connection to database

            conn = DriverManager.getConnection(DATABASE_URL, "COMP228_m22_sl_30", "password" );

            PreparedStatement pst = conn.prepareStatement("UPDATE PLAYER SET PLAYER_ID = ?,FIRST_NAME = ?,LAST_NAME = ?,ADDRESS = ?, POSTAL_CODE = ?, PROVINCE = ?, PHONE_NUMBER = ? WHERE PLAYER_ID = ?");
            pst.setInt(1, id);
            pst.setString(2, fname);
            pst.setString(3, lname);
            pst.setString(4, address);
            pst.setString(5, postalCode);
            pst.setString(6, province);
            pst.setString(7, phoneNumber);
            pst.setInt(8, id);

            //Execute the prepared statement using executeUpdate method: �
            int val = pst.executeUpdate(); //returns the row count

            DialogsFX.showInformation("Updating player","Player information updated successfully");
        }
        catch(Exception e) {
            System.out.println(e);
            e.printStackTrace();
            DialogsFX.showError("Updating player","Error updating player information");
        }
        finally
        {
            if (conn != null) {
                try {
                    conn.close(); // close the connection after you're finnished with it
                } catch (SQLException ex) {/*nothing here*/}
                conn = null;
            }

        }
    }
}