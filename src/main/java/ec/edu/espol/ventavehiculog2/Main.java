/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ventavehiculog2;
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
        double opcion;
        do{
            System.out.println("1.Vendedor");
            System.out.println("2.Comprador");
            System.out.println("3.Salir");
            System.out.println("Ingrese valor de la opcion: ");
            opcion=sc.nextDouble();
            if(opcion==1){
                System.out.println("1");
            }
            else if (opcion==2){
                System.out.println("2");
            }
            else if(opcion==3){
                a=3;
            }
            else{
                System.out.println("Valor Invalido");       
            }
        }while(a!=3);
    }
}
