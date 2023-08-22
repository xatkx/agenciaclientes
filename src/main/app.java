/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import persistencia.connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import persistencia.cliente;

/**
 *
 * @author kedwin
 */
public class app {

    public static void main(String[] args) throws SQLException {

        
        connect mysql = new connect();
        List<cliente> rs = null;

        try {
            cliente s = (cliente) mysql.getOne(1);
            
            System.out.println(s);
            
        } catch ( Exception e) {
            System.out.println("hay un error "+e.getMessage());
            
        } finally {
            
        } 

    }
}
