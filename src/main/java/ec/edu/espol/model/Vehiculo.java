/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author David
 */
public class Vehiculo {
    private String id;
    private String tipo;
    private String placa;
    private String marca;
    private String modelo;
    private String tipoMotor;
    private double año;
    private double recorrido;
    private String tipoCombustible;
    private double precio;
    private String vidrios;
    private String transmision;
    private String traccion;
    private Vendedor vendedor;
    
    public Vehiculo(String id,String tipo, String placa, String marca, String modelo, String tipoMotor, double año, double recorrido, String tipoCombustible, double precio, String vidrios, String transmision, String traccion, Vendedor vendedor){
      this.id = id;
      this.tipo = tipo;
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
      this.vendedor = vendedor; 
    }
    
}
