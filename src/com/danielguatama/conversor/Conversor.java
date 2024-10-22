package com.danielguatama.conversor;

import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************************");
        System.out.println("Bienvenido/a, a tu Conversor de Monedas ");
        System.out.println("    BY Edwin Daniel Guatama Murcia    ");

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

            switch (opcion) {
                case 1 -> apiService.convertir("COP", "USD", cantidad);
                case 2 -> apiService.convertir("MXN", "COP", cantidad);
                case 3 -> apiService.convertir("EUR", "COP", cantidad);
                case 4 -> apiService.convertir("ARS", "EUR", cantidad);
                case 5 -> apiService.convertir("USD", "EUR", cantidad);
                default -> System.out.println("Opciòn NO VÁLIDA");
            }
        }
    }
}