/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    private ArrayList<Vendedor> rV;

    public Vendedor(int id, String nombre, String apellidos, String organizacion, String correoElectronico, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
        this.correoElectronico = correoElectronico;
        this.clave = clave;
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
        this.clave = clave;
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
    public void saveFile(){
        try(PrintWriter pw=new PrintWriter(new FileOutputStream(new File("Vendedor.txt"))))
        {
            pw.println(this.id+"|"+this.nombre+"|"+this.apellidos+"|"+this.organizacion+"|"+this.correoElectronico+"|"+this.clave);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
