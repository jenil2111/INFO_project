/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.EmpTable;
import util.databaseConnector;

/**
 *
 * @author Purvam Sheth
 */
public class ManageEmployeeData {
    public static ArrayList<EmpTable> getAllUsers(){

        ArrayList<EmpTable> employeeList = databaseConnector.getAllusers();
        return employeeList;    
    }
    public static void deleteEmployeeStatus(int eid){
        // delete employee based on eid
    }
    public static boolean isEIDUnique(int eid){
        // delete employee based on eid
        return true;
    }
    public static void addUser(int EID, String Name, String CompanyName, String Role, String Password){
     // add user to database .. add fields accordingly
    }
    public static int totalEmplyee(){
        // return total number of employee in ups except managers
        return 7;
    }
    
}
