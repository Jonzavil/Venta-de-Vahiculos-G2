/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;

/**
 *
 * @author ZavalaAvila
 */
public class Usuario {
    private ArrayList<Vendedor> v;
    private ArrayList<Comprador> c;
    public Usuario(ArrayList<Vendedor> v, ArrayList<Comprador> c) {
        this.v = v;
        this.c = c;
    }
}
