/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author kedwin
 */
public class cliente {

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDirecion() {
        return direcion;
    }
    
    String nombre;
    String apellido;
    String direcion;
    int id;
    
    public cliente (int id, String name,String lastname, String address)
    {
        this.nombre = name;
        this.apellido = lastname;
        this.direcion = address;
        this.id = id;
       
    }

    @Override
    public String toString() {
        String s = nombre+" "+apellido+" "+direcion;
        return s;
    }
    
    
    
}
