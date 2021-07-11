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
 * @author David
 */
public class Vehiculo {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private String tipoMotor;
    private int año;
    private double recorrido;
    private String color;
    private String tipoCombustible;
    private double precio;
    private String vidrios;
    private String transmision;
    private String traccion;
    
    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrios, String transmision, String traccion){
      this.id = id;
      this.placa = placa;
      this.marca = marca;
      this.modelo = modelo;
      this.tipoMotor = tipoMotor;
      this.año = año;
      this.recorrido = recorrido;
      this.tipoCombustible = tipoCombustible;
      this.precio = precio;
      this.vidrios = vidrios;
      this.traccion = traccion;
      this.transmision = transmision;
      this.color = color;
    }
    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio){
        this.id = id;
      this.placa = placa;
      this.marca = marca;
      this.modelo = modelo;
      this.tipoMotor = tipoMotor;
      this.año = año;
      this.recorrido = recorrido;
      this.tipoCombustible = tipoCombustible;
      this.precio = precio;
      this.vidrios = null;
      this.traccion = null;
      this.transmision = null;
      this.color = color;
    }
    
    public Vehiculo(int id, String placa, String marca, String modelo, String tipoMotor, int año, double recorrido, String color, String tipoCombustible, double precio, String vidrios, String transmision){
      this.id = id;
      this.placa = placa;
      this.marca = marca;
      this.modelo = modelo;
      this.tipoMotor = tipoMotor;
      this.año = año;
      this.recorrido = recorrido;
      this.tipoCombustible = tipoCombustible;
      this.precio = precio;
      this.vidrios = vidrios;
      this.traccion = null;
      this.transmision = transmision;
      this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public int getId() {
        return id;
    }


    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public int getAño() {
        return año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public double getPrecio() {
        return precio;
    }

    public String getVidrios() {
        return vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public String getTraccion() {
        return traccion;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }


 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.placa, other.placa);
    }
    
    
    public void saveFile(String nomfile){
         try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.id+"|"+this.placa+"|"+this.marca+"|"+this.modelo+"|"+this.tipoMotor+"|"+this.año+"|"+this.recorrido+"|"+this.tipoCombustible+"|"+this.precio+"|"+this.vidrios+"|"+this.transmision+this.traccion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Vehiculo> readFile(String nomFile){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vehiculo v;
                v = new Vehiculo(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3],tokens[4],Integer.parseInt(tokens[5]),Double.parseDouble(tokens[6]),tokens[7],tokens[8],Double.parseDouble(tokens[9]),tokens[10],tokens[11],tokens[12]);
                vehiculos.add(v);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return vehiculos;
    }
    
    
    
    public static String searchByPlaca(ArrayList<Vehiculo> vehiculos,String placa){
        for(Vehiculo v : vehiculos){
            if(v.placa.equals(placa));
            return v.placa;
        }
        return null;
    }
    
    
     public static Vehiculo registroVehiculo(Scanner sc, String nomfile,String nomfilevendedor){
         ArrayList<Vehiculo> vehiculos = Vehiculo.readFile(nomfile);
         Vehiculo v1;
         String moto="moto";
         int id = Util.nextID(nomfile);
         System.out.println("Ingrese el correo electrónico");
         String correo = sc.next();
         System.out.println("Ingrese su clave: ");
         String clave = sc.next();
         //System.out.println("Ingrese el tipo, si es auto ingrese auto, si es camioneta ingrese camioneta, si es moto ingrese moto: ");
         //String tipo = sc.next();
         if(Vendedor.compararCorreoYContraseña(nomfilevendedor, correo, clave)){
             System.out.println("Ingrese el tipo, si es auto ingrese auto, si es camioneta ingrese camioneta, si es moto ingrese moto: ");
             String tipo = sc.next();
             if(tipo.equals(moto)){
                 System.out.println("Ingrese la placa: ");
                 String placa = sc.next();
                 System.out.println("Ingrese la marca: ");
                 String marca = sc.next();
                 System.out.println("Ingrese el modelo: ");
                 String modelo = sc.next();
                 System.out.println("Ingrese el tipo de motor: ");
                 String tipomotor = sc.next();
                 System.out.println("Ingrese el año: ");
                 int año = sc.nextInt();
                 System.out.println("Ingrese el recorrido: ");
                 double recorrido = sc.nextDouble();
                 System.out.println("Ingrese el color: ");
                 String color = sc.next();
                 System.out.println("Ingrese el tipo de combustible");
                 String combustible = sc.next();
                 System.out.println("Ingrese el precio: ");
                 double precio = sc.nextDouble();
                 if(!placa.equals(Vehiculo.searchByPlaca(vehiculos, placa))){
                    v1 = new Vehiculo(id,placa,marca,modelo,tipomotor,año,recorrido,color,combustible,precio);
                    return v1;
                 }else
                     return null;
             }
             else if(tipo.equals("camioneta")){
                 System.out.println("Ingrese la placa: ");
                 String placa = sc.next();
                 System.out.println("Ingrese la marca: ");
                 String marca = sc.next();
                 System.out.println("Ingrese el modelo: ");
                 String modelo = sc.next();
                 System.out.println("Ingrese el tipo de motor: ");
                 String tipomotor = sc.next();
                 System.out.println("Ingrese el año: ");
                 int año = sc.nextInt();
                 System.out.println("Ingrese el recorrido: ");
                 double recorrido = sc.nextDouble();
                 System.out.println("Ingrese el color: ");
                 String color = sc.next();
                 System.out.println("Ingrese el tipo de combustible");
                 String combustible = sc.next();
                 System.out.println("Ingrese el tipo de vidrios: ");
                 String vidrios = sc.next();
                 System.out.println("Ingrese el tipo de transmision: ");
                 String transmision = sc.next();
                 System.out.println("Ingrese el tipo de traccion: ");
                 String traccion = sc.next();
                 System.out.println("Ingrese el precio: ");
                 double precio = sc.nextDouble();
                 if(!placa.equals(Vehiculo.searchByPlaca(vehiculos, placa))){
                    v1 = new Vehiculo(id,placa,marca,modelo,tipomotor,año,recorrido,color,combustible,precio,vidrios,transmision,traccion);
                    return v1;
                 }else
                     return null;
         }
             else if(tipo.equals("auto")){
                 System.out.println("Ingrese la placa: ");
                 String placa = sc.next();
                 System.out.println("Ingrese la marca: ");
                 String marca = sc.next();
                 System.out.println("Ingrese el modelo: ");
                 String modelo = sc.next();
                 System.out.println("Ingrese el tipo de motor: ");
                 String tipomotor = sc.next();
                 System.out.println("Ingrese el año: ");
                 int año = sc.nextInt();
                 System.out.println("Ingrese el recorrido: ");
                 double recorrido = sc.nextDouble();
                 System.out.println("Ingrese el color: ");
                 String color = sc.next();
                 System.out.println("Ingrese el tipo de combustible");
                 String combustible = sc.next();
                 System.out.println("Ingrese el tipo de vidrios: ");
                 String vidrios = sc.next();
                 System.out.println("Ingrese el tipo de transmision: ");
                 String transmision = sc.next();
                 System.out.println("Ingrese el precio: ");
                 double precio = sc.nextDouble();
                 if(!placa.equals(Vehiculo.searchByPlaca(vehiculos, placa))){
                    v1 = new Vehiculo(id,placa,marca,modelo,tipomotor,año,recorrido,color,combustible,precio,vidrios,transmision);
                    return v1;
                 }else
                     return null;
             }
         
         }
         return null;
     }
     
}
