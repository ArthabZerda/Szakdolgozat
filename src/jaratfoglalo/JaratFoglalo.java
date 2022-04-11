/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaratfoglalo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class Tester {

    String test;

    void adder(String nextValue) {
        test = nextValue;
        
       
    }
}

public class JaratFoglalo extends Tester {
    
    public static String bruh = "nem jó";
    public static String currentUser = "no conn";
    public static int currentId = 0;
    public static int adminCount = 0;
    public static int testerInt = 0;
    public static int numberOfShips = 0;
    public static String level = "";
    public static int numberOfSystems = 0;
    public static int fLoad = 0;
    public static String sendTo;
    public static String newPass;
    public static String currentT;
    
    //Globális változók amik szükségesek Listák számához és felhasználó megjegyzésére
    public static void main(String[] args) throws Exception {

        JaratLogin jl = new JaratLogin();
        jl.setLocationRelativeTo(null);
        jl.show();

        JaratFoglalo newO = new JaratFoglalo();
        // newO.adder("adada");
        
        //Felhasználók megszámlálása a késöbbi lista feltöltésére
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `userfield` FROM users WHERE 1";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                testerInt++; //FelhasználóSzám
            }
            testerInt++;
            System.out.println("Number of Users in the database is: " + testerInt);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Hajók megszámlálása késöbbi lista feltöltésére
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `shipName` FROM shuttles WHERE 1";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                numberOfShips++;
            }

            System.out.println("Number of Ships in the database is: " + numberOfShips);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Rendszerek megszámlálása késöbbi lsita feltöltésére
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `systemName` FROM systems WHERE 1";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                numberOfSystems++;
            }

            System.out.println("Number of systems in the database is: " + numberOfSystems);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        //admin számláló
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "SELECT `userfield` FROM `users` WHERE `clearance` LIKE \"L4\";";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                adminCount++;

            }
            adminCount++;
            System.out.println("Number of Admins in the database is: " + adminCount);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Járat törlése ha a járat indulási időpontja meghaladja az aktuális járat indulási dátumát
        try {
            
            
            SimpleDateFormat s= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            
            LocalDate crt=LocalDate.now();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok", "root", "");

            Statement stm = con.createStatement();
            String sql = "DELETE FROM `routes` WHERE `date`<'"+s.format(date)+"'";
            stm.executeUpdate(sql);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
