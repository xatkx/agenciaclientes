/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import interfaces.Crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author kedwin
 */
public class connect implements Crud<cliente>{
    
    String ejecreate = "create table extras (name varchar(45) not null, poder int(9) not null default 0, age int(2), PRIMARY KEY(name))";

    
    public connect()
    {
        nameDB = "cliente";
        userDB = "root";
        passwordDB = "1212";
        urlDB = "jdbc:mysql://localhost:3306/"+nameDB;
//        try {
//            this.createTable(ejecreate);
//        } catch (SQLException ex) {
//            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
    public void Open()
    {
        Connection cx = null;
        try
        {
            cx = DriverManager.getConnection(urlDB, userDB, passwordDB);
//            DriverManager.deregisterDriver();
            System.out.println("Conectado :)");
        }
        catch( SQLException err)
        {
            String hola = err.getMessage();
            System.out.println(hola);
        }
        finally {
            
           data = cx;
        }
    }
    
    public void Close()
    {
        try {
            System.out.println("cerradon conect");
            data.close();
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void createTable(String s) throws SQLException
//    {
//        
//       
//        query = data.createStatement();
//        query.executeUpdate(s);
//        System.out.println("tabla creada");
//           
//        //System.out.println("persistencia.connect.createTable()");//
//        query.close();
//    }
    
//    public ArrayList<cliente> getClientes(String s) throws SQLException
//    {
//        String name, lastname, address;
//        int id = 0;
//        ArrayList<cliente> list = new ArrayList();
//        ResultSet rs = null ;
//        
//        query = data.createStatement();
//        
//        rs = query.executeQuery(s);
//        
//       while(rs.next())
//       {
//                name = rs.getString("nombre");
//                lastname = rs.getString("apellido");
//                address = rs.getString("dirrecion");
//                id = rs.getInt("id");
//                
//                list.add(new cliente(id,name,lastname,address));
//       }
//        
//        return list;
//    }
    
    Statement statement = null;
    Connection data;
    ResultSet rs = null;
    String nameDB;
    String urlDB;
    String userDB;
    String passwordDB;
    String table = "clientes";
     
    @Override
    public ArrayList<cliente> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getOne(int id){
        
        cliente obj = null;
        this.Open();
        
        try
        {
            statement = data.createStatement();
            rs = statement.executeQuery("select * from "+table+" where id = "+id);
            System.out.println("exit!!");
            
            while(rs.next())
            {
                obj = new cliente(
                        rs.getInt("id"),
                        rs.getNString("nombre"),
                        rs.getNString("apellido"),
                        rs.getNString("email")
                );
            }
            
        }catch(SQLException err)
        {
            System.out.println("klk"+err.getMessage());
        }finally
        {
            if(rs != null)
            {
                System.out.println("gallina "+rs.toString());
            }
            this.Close();
            
        }
        
        
        
        return obj;
    }

    @Override
    public boolean putOne(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delOne(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean createOne(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean createAll(ArrayList<cliente> list) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
