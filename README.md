Currency Converter API
📋 Descripción del Proyecto
Este proyecto es una aplicación Java que permite convertir montos entre diferentes monedas utilizando la API de ExchangeRate-API. La aplicación realiza solicitudes HTTP a la API, procesa las tasas de cambio proporcionadas y calcula el monto convertido.

🚀 Características Principales
Conversión de Monedas:

Permite convertir un monto desde una moneda origen (from) a una moneda destino (to).
Calcula el monto convertido en base a la tasa de cambio actual.
Validación de Monedas:

Verifica si la moneda destino está disponible en la respuesta de la API.
Maneja errores en caso de que una moneda no sea válida.
Manejo de Errores:

Detecta y gestiona errores de API, como respuestas no exitosas o códigos de estado HTTP inesperados.
Incluye excepciones personalizadas para facilitar la depuración.
🛠️ Arquitectura del Proyecto
El proyecto está estructurado en tres clases principales:

1. ApiService
Encargada de interactuar con la API externa.
Maneja las solicitudes HTTP, analiza las respuestas JSON y calcula el monto convertido.
2. Conversor
Actúa como el punto de entrada para gestionar las conversiones.
Utiliza la clase ApiService para obtener los datos necesarios y mostrar los resultados.
3. Respuesta
Clase dedicada a manejar las estructuras JSON de la API.
Permite organizar y validar las respuestas recibidas de manera eficiente.
⚙️ Instalación y Configuración
Requisitos Previos:
Java Development Kit (JDK) 11 o superior.
Un IDE como IntelliJ IDEA o Eclipse.
Conexión a internet (para acceder a la API).
Instrucciones de Configuración:
Clonar el Repositorio:

bash
Copy code
git clone https://github.com/tu_usuario/currency-converter.git
cd currency-converter
Configurar Dependencias:

Asegúrate de incluir la biblioteca Gson en tu proyecto. Si usas Maven, añade el siguiente bloque a tu pom.xml:
xml
Copy code
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>
API Key:

Regístrate en ExchangeRate-API para obtener tu propia clave API.
Reemplaza la clave existente en ApiService con la tuya:
java
Copy code
private static final String API_KEY = "TU_CLAVE_API";
Ejecutar la Aplicación:

Configura la clase Conversor como tu clase principal en el IDE y ejecuta el programa.
📄 Uso de la Aplicación
Ejemplo de Entrada:

java
Copy code
ApiService apiService = new ApiService();
apiService.convertir("USD", "EUR", 100.0);
Salida Esperada:

yaml
Copy code
Tasa de cambio: 0.8900
100.00 USD = 89.00 EUR
📚 Documentación Técnica
Estructura del Código
Clase ApiService
Métodos Principales:
convertir(String from, String to, double cantidad):
Realiza la conversión entre las monedas.
Maneja la solicitud HTTP y la respuesta JSON.
Clase interna ConversionException:
Maneja errores específicos de la conversión.
Clase Conversor
Integra el flujo principal de la conversión.
Clase Respuesta
Permite manejar y organizar las respuestas JSON de la API.
🐞 Manejo de Errores
Errores Comunes y Soluciones:
API Key Inválida:

Mensaje: Error en la solicitud HTTP: 403.
Solución: Verifica que tu clave API sea válida y esté activa.
Moneda No Disponible:

Mensaje: La moneda destino 'XXX' no se encontró en la respuesta de la API.
Solución: Asegúrate de usar códigos de moneda válidos (ISO 4217).
Problemas de Conexión:

Mensaje: Error inesperado: [detalles del error].
Solución: Verifica tu conexión a internet y el estado de la API.
🤝 Contribuciones
Si deseas contribuir a este proyecto:

Realiza un fork del repositorio.
Crea una nueva rama:
bash
Copy code
git checkout -b feature/nueva-funcionalidad
Envía tus cambios en un pull request.
📃 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

🧑‍💻 Autor
Daniel Guatama
Estudiante de programación en constante aprendizaje.
Si tienes alguna duda o sugerencia, ¡no dudes en contactarme!
