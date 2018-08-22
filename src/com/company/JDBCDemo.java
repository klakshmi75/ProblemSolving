package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    private static String driverClass="com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/test_db";
    private static String user = "root";
    private static String password ="root";
    public static void main(String rags[]) throws Exception {
        Class.forName(driverClass);
//        clearDB();
//        insertRecordsThroughJDBC();
            fetchRecords();
    }

    private static void clearDB() {
        try(Connection con = DriverManager.getConnection(url,user,password);
            Statement stmt = con.createStatement();) {
            String sql = "delete from customer";
            System.out.println("Deleted " + stmt.executeUpdate(sql) + " customers from db.");
        } catch(Exception e) {
            System.out.print(e);
        }
    }

    private static void insertRecordsThroughJDBC() {
        try(Connection con = DriverManager.getConnection(url,user,password);
            Statement stmt = con.createStatement();) {
            String sql = "delete from customer";
            String sql1 = "insert into customer values(uuid(), 'Customer_1', '1975-08-30', 'MALE', 'klakshmi75@gmail.com')";
            String sql2 = "insert into customer values(uuid(), 'Customer_2', '1975-08-30', 'MALE', 'lakshmi.k@gmail.com')";
            System.out.println("Deleted " + stmt.executeUpdate(sql) + " customers from db.");
            stmt.execute(sql1);
            stmt.execute(sql2);
            System.out.println("Inserted 2 rows.");
        } catch(Exception e) {
            System.out.print(e);
        }
    }

    private static void fetchRecords() {
        try(Connection con = DriverManager.getConnection(url,user,password);
            Statement stmt = con.createStatement();) {
            System.out.println("Fetching customre records");
            String query = "select * from customer";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) +  " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
            }
        } catch(Exception e) {
            System.out.print(e);
        }
    }
}
