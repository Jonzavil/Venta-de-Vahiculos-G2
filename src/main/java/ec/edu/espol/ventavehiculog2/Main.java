/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculog2;
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
        int opcion;
        do{
            System.out.println("1.Vendedor");
            System.out.println("2.Comprador");
            System.out.println("3.Salir");
            System.out.println("Ingrese valor de la opcion: ");
            opcion=sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("1. Registrar un nuevo vendedor");
                    System.out.println("2.Ingresar un nuevo vehiculo");
                    System.out.println("3.Aceptar oferta");
                    System.out.println("Ingrese valor de la opcion: ");
                    opcion=sc.nextInt();
                    switch(opcion){
                        case 1:
                            Vendedor.registroVendedor(sc, "Vendedor.txt");
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:       
                            System.out.println("Valor Invalido");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("2");
                    System.out.println("1.Registrar un nuevo comprador");
                    System.out.println("2.Ofertar por un vehiculo");
                    System.out.println("Ingrese valor de la opcion: ");
                    opcion=sc.nextInt();
                    switch(opcion){
                        case 1:
                            break;
                        case 2:
                            break;
                        default:       
                            System.out.println("Valor Invalido");
                            break;
                    }
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
