package main;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements  Observer, DisplayElement{
    Observable observable;
    private float maxTemp;
    private float minTemp;
    private  int numberOfReadings;
    private float sumOfTemps;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    @Override
    public String show() {
        return "Avg/Max/Min temperature = " + (sumOfTemps / numberOfReadings)
                + "/" + maxTemp + "/" + minTemp;
    }

    @Override
    public void update(Observable observable, Object args) {
        WeatherData weather = (WeatherData) observable;
        float temperature = weather.getTemperature();
        sumOfTemps += temperature;
        numberOfReadings ++;
        maxTemperature(temperature);
        minimumTemperature(temperature);
        show();
    }

    private void minimumTemperature(float temperature) {
        if (temperature < minTemp) {
            minTemp = temperature;
        }
    }

    private void maxTemperature(float temperature) {
        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
    }
}
