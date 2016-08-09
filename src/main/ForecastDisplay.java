package main;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    Observable observable;
    private float currentPressure = 29.90f;
    private float lastPressure;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public String show() {
        String noChange = "Forecast: More of the same";
        if (currentPressure > lastPressure) {
           return "Forecast: Improving weather on the way!";
        } else if (currentPressure < lastPressure) {
            return "Forecast: Watch out for cooler, rainy weather";
        }
        return noChange;
    }

    @Override
    public void update(Observable observable, Object arg) {
        WeatherData weather = (WeatherData) observable;
        lastPressure = currentPressure;
        currentPressure = weather.getPressure();
        show();
    }
}
