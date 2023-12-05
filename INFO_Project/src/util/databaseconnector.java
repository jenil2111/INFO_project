/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Jeel
 */
import java.sql.*;
import java.util.ArrayList;
import model.*;

public class databaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/UPS?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Privatized constructor so as to not allow object creation
     */
    private databaseConnector() {
    }

    /**
     * Insert given user to database
     * @see User
     * @param user User object to be added
     */
    public static void addUser(EmpTable user) {
        //add to database
        String query = "INSERT INTO UserTable(NAME,AGE) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, EmpTable.getName());
            stmt.setInt(2, user.getAge());
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows);
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return lost of all users in database
     * @see User
     * @return list of users
     */
    public static ArrayList<EmpTable> getAllusers() {
//        return list of users from db
        
        ArrayList<EmpTable> users = new ArrayList<>();

        String query = "SELECT * FROM UserTable";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                EmpTable u = new EmpTable();
                u.setEID(rs.getInt("ID"));
                u.setEmployeeName(rs.getString("name"));
                u.setDataJoined(rs.getString("joining_date"));
                users.add(u);
            }
            rs.close();
            for(int i = 0; i < users.size(); i++) {   
                System.out.print(users.get(i));
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
        public static ArrayList<AssignmentRequests> getorders() {
//        return list of users from db
        
        ArrayList<AssignmentRequests> orders = new ArrayList<>();
        System.out.println("calling get orderrs");
        String query = "SELECT * FROM OrderTable where orderStatus='pending_assignment'";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                AssignmentRequests u = new AssignmentRequests();
                u.setOID(rs.getInt("OrderID"));
                u.setCompanyName(rs.getString("ProductName"));
                u.setAddress(rs.getString("Address"));
                u.setOrderStatus(rs.getString("OrderStatus"));
                u.setDate(rs.getString("PlacedDate"));
                orders.add(u);   
            }
            rs.close();
            for(int i = 0; i < orders.size(); i++) {   
                System.out.print(orders.get(i));
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * Delete given user from database
     * @see User
     * @param u User to be deleted
     * 
     */
    public static void deleteUser(EmpTable u) {
        String query = "delete from USER where id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edit given user details in the database
     * @param oldUser existing user in database
     * @param newUser modified user details to be added
     */
    public static void editUser(EmpTable oldUser, EmpTable newUser) {
        String query = "UPDATE USER SET name=?, age=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newUser.getName());
            stmt.setInt(2, newUser.getAge());
            stmt.setInt(3, oldUser.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
