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
import java.util.logging.Level;
import java.util.logging.Logger;

class Tester{
String test;

void adder(String nextValue){
    test = nextValue;
}
}
/**
 *
 * @author Bakcsányi Dominik
 */
public class JaratFoglalo extends Tester{

public static String bruh="nem jó";
public static String currentUser="no conn";
public static int currentId=0;
public static int adminCount=0;
public static int testerInt=0;
public static int numberOfShips=0;
public static String level="";
public static int numberOfSystems=0;
public static int fLoad = 0;
    
    
    public static void main(String[] args) throws Exception {
        
        /*String reverseTest="abc";
        byte[] strAsByteArray = reverseTest.getBytes();
        byte[] result = new byte[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++){
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        System.out.println(new String(result));*/
        
        
        
        
        
        
        /*
        String asd="admin";
        String rev = new StringBuilder(asd).reverse().toString();
        char f2= rev.charAt(0);
        String result = f2+rev+f2;
        System.out.println(result);
        result = result.substring(1, result.length() - 1);
        String encode = new StringBuilder(result).reverse().toString();
        System.err.println(encode);
        */
          JaratLogin jl = new JaratLogin();
        jl.setLocationRelativeTo(null);
        jl.show();
        
        
        JaratFoglalo newO = new JaratFoglalo();
        newO.adder("adada");
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok","root","");
          
          Statement stm = con.createStatement();
          String sql = "SELECT `userfield` FROM users WHERE 1";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()){
              testerInt++;
              
          }
         testerInt++;
            System.out.println("Number of Users in the database is: " + testerInt);
            
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok","root","");
          
          Statement stm = con.createStatement();
          String sql = "SELECT `shipName` FROM shuttles WHERE 1";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()){
              numberOfShips++;
          }
         
            System.out.println("Number of Ships in the database is: " + numberOfShips);
            
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok","root","");
          
          Statement stm = con.createStatement();
          String sql = "SELECT `systemName` FROM systems WHERE 1";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()){
              numberOfSystems++;
          }
         
            System.out.println("Number of systems in the database is: " + numberOfSystems);
            
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        
         try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jaratok","root","");
          
          Statement stm = con.createStatement();
          String sql = "SELECT `userfield` FROM `users` WHERE `clearance` LIKE \"L4\";";
          ResultSet rs = stm.executeQuery(sql);
          
          while(rs.next()){
              adminCount++;
              
          }
         adminCount++;
            System.out.println("Number of Admins in the database is: " + adminCount);
            
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JaratLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
}
