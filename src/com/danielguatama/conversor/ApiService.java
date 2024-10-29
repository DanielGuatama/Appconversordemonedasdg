package com.danielguatama.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private static final String API_KEY = "54a74d82d1cfbc88fb259601";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public void convertir(String from, String to, double cantidad) {
        try {

            String endpoint = BASE_URL + API_KEY + "/latest/" + from;
            URI url = URI.create(endpoint);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica el código de estado de la respuesta
            if (response.statusCode() == 200) {
                // Usamos JsonParser para analizar la respuesta JSON
                JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

                // Verificamos el resultado antes de convertir
                if ("success".equals(jsonObject.get("result").getAsString())) {
                    JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

                    // Validación y obtención de tasa de cambio
                    if (!conversionRates.has(to)) {
                        System.out.println("La moneda destino '" + to + "' no se encontró en la respuesta de la API.");
                    } else {
                        double tasaCambio = conversionRates.get(to).getAsDouble();
                        double resultado = tasaCambio * cantidad;

                        System.out.printf("Tasa de cambio: %.4f%n", tasaCambio);
                        System.out.printf("%.2f %s = %.2f %s%n",cantidad, from,resultado, to);
                    }
                } else {
                    System.out.println("Error en la respuesta de la API.");
                }
            } else {
                System.out.println("Error en la solicitud HTTP: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



