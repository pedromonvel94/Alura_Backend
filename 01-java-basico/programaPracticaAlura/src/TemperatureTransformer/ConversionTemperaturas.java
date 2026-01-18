package TemperatureTransformer;

import java.util.Scanner;

public class ConversionTemperaturas {
    Scanner scanner = new Scanner(System.in);

    float temperaturaCelcius;
    float temperaturaFahrenheit;

    public ConversionTemperaturas(float temperaturaCelcius, float temperaturaFahrenheit) {
        this.temperaturaCelcius = temperaturaCelcius;
        this.temperaturaFahrenheit = temperaturaFahrenheit;
    }

    public float convertirFahrenheit(float temperaturaCelcius) {
        return (float) ((temperaturaCelcius * 1.8) + 32);
    }

    public float convertirCelcius(float temperaturaFahrenheit) {
        return (float) ((temperaturaFahrenheit - 32) / 1.8);
    }


}
