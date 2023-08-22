/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;

/**
 * 
 * 
 *
 * @author kedwin
 * 
 */
public interface Crud<E> {
    
    
    public ArrayList<E> getAll();
    
    public Object getOne(int id);
    
    public boolean putOne(Object obj);
    
    public boolean delOne(Object obj);
    
    public boolean createOne(Object obj);
    
    public boolean createAll(ArrayList<E> list);
    
}
