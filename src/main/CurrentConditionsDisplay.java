package main;
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public String show() {
        return "Current conditions: " + temperature  + "F degrees and " + humidity + "% humidity";
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherData) {
            WeatherData weather = (WeatherData) observable;
            this.temperature = weather.getTemperature();
            this.humidity = weather.getHumidity();
            show();
        }

    }
}
