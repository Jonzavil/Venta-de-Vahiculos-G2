/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculog2;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import java.util.Scanner;
/**
 *
 * @author ZavalaAvila
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //menu de opciones
        Scanner sc=new Scanner(System.in);
        sc.useDelimiter("\n");
        int a=0;
        int b=0;
        int c=0;
        int opcion;
        int opcion1;
        int opcion2;
        do{
            System.out.println("1.Vendedor");
            System.out.println("2.Comprador");
            System.out.println("3.Salir");
            System.out.println("Ingrese valor de la opcion: ");
            opcion=sc.nextInt();
            System.out.println("---------------------------------------------");
            switch (opcion) {
                case 1:
                    do{
                    System.out.println("1. Registrar un nuevo vendedor");
                    System.out.println("2.Ingresar un nuevo vehiculo");
                    System.out.println("3.Aceptar oferta");
                    System.out.println("4.regresar");
                    System.out.println("Ingrese valor de la opcion: ");
                    opcion1=sc.nextInt();
                    System.out.println("---------------------------------------------");
                    switch(opcion1){
                        case 1:
                            Vendedor.registroVendedor(sc, "Vendedor.txt");
                            System.out.println("---------------------------------------------");
                            break;
                        case 2:
                            Vehiculo.registroVehiculo(sc, "Vehiculo.txt", "Vendedor.txt");
                            System.out.println("---------------------------------------------");
                            break;
                        case 3:
                            System.out.println("---------------------------------------------");
                            break;
                        case 4:
                            b
                                    =4;
                            break;
                        default:       
                            System.out.println("Valor Invalido");
                            break;
                    }
                    }while(b!=4);
                    break;
                case 2:
                    do{
                    System.out.println("1.Registrar un nuevo comprador");
                    System.out.println("2.Ofertar por un vehiculo");
                    System.out.println("3.Regresar");
                    System.out.println("Ingrese valor de la opcion: ");
                    opcion2=sc.nextInt();
                    System.out.println("---------------------------------------------");
                    switch(opcion2){
                        case 1:
                            Comprador.registroComprador(sc, "Comprador.txt");
                            System.out.println("---------------------------------------------");
                            break;
                        case 2:
                            Oferta.ofertarPorVehiculo("Vehiculo.txt", "Comprador.txt");
                            System.out.println("---------------------------------------------");
                            break;
                        case 3:
                            c=3;
                            break;
                        default:       
                            System.out.println("Valor Invalido");
                            break;
                    }
                    }while(c!=3);
                    break;
                case 3:
                    a=3;
                    break;
                default:       
                    System.out.println("Valor Invalido");
                    break;
            }
        }while(a!=3);
    }
}
