/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.AssignmentRequests;
import util.databaseConnector;


/**
 *
 * @author Purvam Sheth
 */

public class AssignOrdersData {

    public static int totalEmplyee() {
        // total request for approval
        return 21;
    }

    public static ArrayList<EmployeeLoadTable> getAllUsers() {
        ArrayList<EmployeeLoadTable> employees = new ArrayList<>();

        EmployeeLoadTable employee1 = new EmployeeLoadTable();
        employee1.setEID(1);
        employee1.setEmployeeName("John Doe");
        employee1.setCompletedOrder_thisMonth(10);
        employee1.setProcessingOrder_thisMonth(5);

        EmployeeLoadTable employee2 = new EmployeeLoadTable();
        employee2.setEID(2);
        employee2.setEmployeeName("Jane Smith");
        employee2.setCompletedOrder_thisMonth(15);
        employee2.setProcessingOrder_thisMonth(8);

        EmployeeLoadTable employee3 = new EmployeeLoadTable();
        employee3.setEID(3);
        employee3.setEmployeeName("Alice Johnson");
        employee3.setCompletedOrder_thisMonth(8);
        employee3.setProcessingOrder_thisMonth(3);
        
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        return employees;    
    }
    
    public static ArrayList<AssignmentRequests> getAllOrdersData() {
        ArrayList<AssignmentRequests> order = databaseConnector.getorders();
        return order;    
    }

    public static void updateOrderStatus(int oid, int eid) {
        // Update order (find by oid) table, by changing its status to employee assigned and update agent id with eid
    }
    
}
