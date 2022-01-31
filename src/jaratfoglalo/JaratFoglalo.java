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

public static int testerInt=0;
public static int numberOfShips=0;
public static String level="";
    
    
    public static void main(String[] args) {
        String reverseTest="abc";
        byte[] strAsByteArray = reverseTest.getBytes();
 
        byte[] result = new byte[strAsByteArray.length];
 
        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
 
        System.out.println(new String(result));
        JaratLogin lg = new JaratLogin();
        lg.show();
        
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
        
    }
    
}
