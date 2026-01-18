package TemperatureTransformer;

import java.util.Scanner;

    public class MainConversion {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ConversionTemperaturas conversion = new ConversionTemperaturas(0,0);

            boolean respuestaCorrecta = false;

            while (!respuestaCorrecta) {
                System.out.println("Deseas convertir la temperatura de Celcius a Farenheit? (Y/N)");
                String preguntaCelFar = scanner.nextLine();

                if (preguntaCelFar.equalsIgnoreCase("Y") || preguntaCelFar.equalsIgnoreCase("YES")) {
                    System.out.println("Cual es la temperatura en Celcius");
                    float preguntaTempCelcius = scanner.nextFloat();
                    int preguntaTempCelciusInt = (int) preguntaTempCelcius;

                    float convertirTempCelcius = conversion.convertirFahrenheit(preguntaTempCelcius);
                    int convertirTempCelciusInt = (int) convertirTempCelcius;
                    System.out.println(preguntaTempCelcius + " grados celcius, equivalen a: " + convertirTempCelcius + " grados fahrenheit");
                    System.out.println(preguntaTempCelciusInt + " grados celcius, equivalen a: " + convertirTempCelciusInt + " grados fahrenheit PERO SIN DECIMALES");
                    respuestaCorrecta = true;
                } else if (preguntaCelFar.equalsIgnoreCase("N") || preguntaCelFar.equalsIgnoreCase("NO")) {
                    System.out.println("Entonces deseas convertir la temperatura de Farenheit a Celcius? (Y/N)");
                    String preguntaFarCel = scanner.nextLine();

                    if (preguntaFarCel.equalsIgnoreCase("Y") || preguntaFarCel.equalsIgnoreCase("YES")) {
                        System.out.println("Cual es la temperatura en Farenheit");
                        float preguntaTempFarenheit = scanner.nextFloat();
                        int preguntaTempFahrenheitInt = (int) preguntaTempFarenheit;

                        float convertirTempFahrenheit = conversion.convertirCelcius(preguntaTempFarenheit);
                        int convertirTempFahrenheitInt = (int) convertirTempFahrenheit;
                        System.out.println(preguntaTempFarenheit + " grados Fahrenheit, equivalen a: " + convertirTempFahrenheit + " grados Celcius");
                        System.out.println(preguntaTempFahrenheitInt + " grados Fahrenheit, equivalen a: " + convertirTempFahrenheitInt + " grados Celcius PERO SIN DECIMALES");
                        respuestaCorrecta = true;
                    }
                } else {
                    System.out.println("La respuesta no es valida, responde Y/N");
                }
            }
        }
    }
