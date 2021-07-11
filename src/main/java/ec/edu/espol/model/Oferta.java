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
public class Oferta {
    private String correo;
    private double precioOfertar;

    public Oferta(double precioOfertar, String correo) {
        this.precioOfertar = precioOfertar;
        this.correo=correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public double getPrecioOfertar() {
        return precioOfertar;
    }

    public void setPrecioOfertar(double precioOfertar) {
        this.precioOfertar = precioOfertar;
    }
    public void saveFile(String nomfile){
         try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true)))
        {
            pw.println(this.correo+"|"+this.precioOfertar);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static ArrayList<Oferta> readFile(String nomFile){
        ArrayList<Oferta> ofertas = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine())
            {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Oferta o;
                o = new Oferta(Integer.parseInt(tokens[1]),tokens[0]);
                ofertas.add(o);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ofertas;
    }
    public static ArrayList<Oferta> ofertarPorVehiculo(String nomfileVehiculo,String nomfileComprador){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese Correo Electronico: ");
        String correo=sc.nextLine();
        System.out.println("Ingrese Contraseña: ");
        String clave=sc.nextLine();
        ArrayList<Oferta> cP=new ArrayList<>();
        Oferta ofer;
        ArrayList<Vehiculo>vn;
        int cont=0;
        Vehiculo aV[];
        if(Comprador.compararCorreoYContraseña(nomfileComprador, correo, clave)){
            vn=Vehiculo.busquedaPorVehiculo(nomfileVehiculo);
            aV=new Vehiculo[vn.size()];
            for(Vehiculo v:vn){
                aV[cont]=v;
                cont=cont+1;
            }
            cont=0;
            do{
                System.out.println("Seleccione opcion: ");
                if(cont==0){
                    System.out.println("Vehiculo: "+aV[cont]);
                    System.out.println("1.Siguiente");
                    System.out.println("2.Ofertar");
                    System.out.println("3.Salir");
                    int opcion=sc.nextInt();
                    if(opcion==1){
                        cont=cont+1;
                    }
                    if(opcion==2){
                        System.out.println("Precio a ofertar: ");
                        double pO=sc.nextDouble();
                        ofer=new Oferta(pO,correo);
                        cP.add(ofer);
                        System.out.println("Oferta Realizada");
                    }
                    if(opcion==3){
                        cont=-1;
                    }
                }if(0<cont || cont<=aV.length){
                    System.out.println("Vehiculo: "+aV[cont]);
                    System.out.println("1.Siguiente");
                    System.out.println("2.Ofertar");
                    System.out.println("3.Atras");
                    System.out.println("4.Salir");
                    int opcion=sc.nextInt();
                    if(opcion==1){
                        cont=cont+1;
                    }
                    if(opcion==2){
                        System.out.println("Precio a ofertar: ");
                        double pO=sc.nextDouble();
                        ofer=new Oferta(pO,correo);
                        cP.add(ofer);
                        System.out.println("Oferta Realizada");
                    }
                    if(opcion==3){
                        cont=cont-1;
                    }
                    if(opcion==4){
                        cont=-1;
                    }
                }
                                
            }while(cont!=-1);
        }
        return cP;
    }
}
