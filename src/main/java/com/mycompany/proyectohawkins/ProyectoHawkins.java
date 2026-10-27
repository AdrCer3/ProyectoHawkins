/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectohawkins;
import java.util.Scanner;
/**
 *
 * @author adriancl
 */
public class ProyectoHawkins {

    public static void main(String[] args) {
        final double MAX_ENERGIA = 200.0;
        final double LIMITE_RIESGO = 150.0;
        String operadorActual = null;
        double sensorMedido;
        int codigoRiesgo;
        boolean portalAbierto;
        int opcionMenu = 0;
        double porcentajeEstado;
        
        Scanner sc = new Scanner(System.in);
        
        String mensaje = "Introduce lectura μT: ";
        System.out.println("Bienvenido. Introduzca nombre de operario: ");
        operadorActual = sc.nextLine();
        do {
            mostrarEncabezado(operadorActual, sc, opcionMenu);
            opcionMenu = sc.nextInt();
            switch(opcionMenu) {
                case 1: 
                    sensorMedido = leerLecturaSegura(sc, mensaje);
                    evaluarNivelRiesgo(sensorMedido, LIMITE_RIESGO);
                case 2:
                    simularMuestreoContinuo(sc, LIMITE_RIESGO);
                case 0:
                    
                default:
                    System.out.println("Opción no valida, vuelva a intentarlo.");
                    break;
            }
        } while(opcionMenu != 0);
    }


    
    
    
    public static void mostrarEncabezado( String operadorActual, Scanner sc, int opcionMenu) { 
          System.out.printf("Hola " + operadorActual + "---SISTEMA HAWKINS---\n1. Inspeccionar Sensor Individual\n2. Iniciar muestreo continuo\n0. Salir\t");
    }
    
    
    
    
    public static double leerLecturaSegura(Scanner sc, String mensaje){
        boolean valido = false;
        double lectura = 0;
        do {
            try {
                System.out.print(mensaje);
                lectura = sc.nextDouble();
                valido = true;
            } catch(Exception e) {
                System.out.println("El valor es invalido");
                sc.next();
            }
        } while (valido != true);
            return lectura;
        } 
    
    
    
    
    public static int evaluarNivelRiesgo(double microTeslas, double LIMITE_RIESGO){
        int cantidadRiesgo = 0;
        if (microTeslas < 50){
            cantidadRiesgo = 1;
        } else if(microTeslas >=50 || microTeslas <=150){
            cantidadRiesgo = 2;
        } else
            cantidadRiesgo = 3;
        System.out.println(cantidadRiesgo == 1 ? "Seguro" : (cantidadRiesgo == 2 ? "Alerta" : "Critico"));
        return cantidadRiesgo;     
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void simularMuestreoContinuo(Scanner sc, double LIMITE_RIESGO) {
        String mensaje = "Introduce lectura μT: ";
        double valor = leerLecturaSegura(sc, mensaje);
        do {
            if(valor < 0){
                break;
            } else if(valor == 0.0){
                continue;
            } else if(valor > LIMITE_RIESGO) {
                System.out.println("Advertencia, umbral superado: máximo 150.0");
            }
        } while(valor <= LIMITE_RIESGO);
        System.out.println(valor/2);
    }
}
