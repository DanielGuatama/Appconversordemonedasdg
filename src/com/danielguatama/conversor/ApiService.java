package com.danielguatama.conversor;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    private static final String API_KEY = "54a74d82d1cfbc88fb259601";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public void convertir(String from, String to, double cantidad) {
        try {
            // Generamos la URL con la moneda base que deseamos consultar
            String endpoint = BASE_URL + API_KEY + "/latest/" + from;
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Verifica que la respuesta sea exitosa (200 OK)
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error en la respuesta de la API: " + responseCode);
            }

            // Leer la respuesta
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            Gson gson = new Gson();
            Respuesta respuesta = gson.fromJson(reader, Respuesta.class);

            // Verificamos si la respuesta fue exitosa
            if ("success".equals(respuesta.result)) {
                // Accedemos a la tasa de cambio usando el código de la moneda destino
                Double tasaCambio = respuesta.conversion_rates.get(to);

                if (tasaCambio != null) {
                    double resultado = tasaCambio * cantidad;
                    System.out.printf("Tasa de cambio: %.4f%n", tasaCambio);
                    System.out.printf("%.2f %s = %.2f %s%n", cantidad, from, resultado, to);
                } else {
                    System.out.println("Moneda destino no encontrada.");
                }
            } else {
                System.out.println("Error al realizar la conversión.");
            }

            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


