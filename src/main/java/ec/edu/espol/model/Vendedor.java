/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import static ec.edu.espol.util.Util.getSHA;
import static ec.edu.espol.util.Util.toHexString;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author ZavalaAvila
 */
public class Vendedor {
    private int id;
    private String nombre;
    private String apellidos;
    private String organizacion;
    private String correoElectronico;
    private String clave; 
    
    public Vendedor(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
         try 
        {
            this.clave = toHexString(getSHA(clave));   
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown for incorrect algorithm: " + e); 
        } 
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getOrganizacion() {
        return organizacion;
    }
    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        try 
        {
            this.clave = toHexString(getSHA(clave));   
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown for incorrect algorithm: " + e); 
        }
    }
    @Override
    public boolean equals(Object o){
        if(this==null)
            return false;
        if (this== o)
            return true;
        if (this.getClass()!=o.getClass())
            return false;
        Vendedor other=(Vendedor)o;
        return this.correoElectronico.equals(other.correoElectronico);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.correoElectronico);
        return hash;
    }
    public void saveFile(String nomfile){
         try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.nombre+"|"+this.apellidos+"|"+this.organizacion+"|"+this.correoElectronico+"|"+this.clave);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Vendedor> readFile(String nomFile){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor v = new Vendedor(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
                vendedores.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vendedores;
    }
    
    public static Vendedor searchByCorreo(ArrayList<Vendedor> vendedores,String correo){
        for(Vendedor v : vendedores){
            if(v.correoElectronico.equals(correo));
            return v;
        }
        return null;
    }
    
     public static Vendedor registroVendedor(Scanner sc, String nomfile){
         ArrayList<Vendedor> vendedores = Vendedor.readFile(nomfile);
         int id = Util.nextID(nomfile);
         System.out.println("Ingrese sus nombres: ");
         String nombres = sc.next();
         System.out.println("Ingrese sus apellidos: ");
         String apellidos = sc.next();
         System.out.println("Ingrese la organización  la que pertenece: ");
         String organizacion = sc.next();
         System.out.println("Ingrese el correo electrónico");
         String correo = sc.next();
         System.out.println("Ingrese su clave: ");
         String clave = sc.next();
         if (correo.equals(Vendedor.searchByCorreo(vendedores, correo).correoElectronico)){
             return null;
         }
         else{
             Vendedor v1 = new Vendedor(id, nombres,apellidos,organizacion,correo,clave);   
             v1.saveFile(nomfile);
             return v1;
         }
     }
}