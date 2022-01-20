/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaratfoglalo;
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
    
    
    public static void main(String[] args) {
        JaratLogin lg = new JaratLogin();
        lg.show();
        
        JaratFoglalo newO = new JaratFoglalo();
        newO.adder("adada");
        
    }
    
}
