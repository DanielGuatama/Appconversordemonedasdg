package com.danielguatama.conversor;

import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {

        System.out.println("**************************************");
        System.out.println("Bienvenido/a, a tu Conversor de Monedas ");
        System.out.println("    BY Edwin Daniel Guatama Murcia    ");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nElige una opción: ");
            System.out.println("\n1. Convertir Pesos Colombianos a Dólares");
            System.out.println("2. Convertir Pesos Mexixanos a pesos Colombianos");
            System.out.println("3. Convertir Euros a Pesos Colombianos");
            System.out.println("4. Convertir Pesos Argentinos a Euros ");
            System.out.println("5. Convertir Dólares a Euros");
            System.out.println("6. Salir");
            System.out.println("\n**************************************");

            int opcion = scanner.nextInt();
            if (opcion == 6) {
                System.out.println("Saliendo...");
                break;
            }

            System.out.println("Ingrese por favor la cantidad a convertir");
            double cantidad = scanner.nextDouble();




        }
    }

}