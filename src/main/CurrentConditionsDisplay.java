package main;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        show();

    }

    @Override
    public String show() {
        return "Current conditions: " + temperature  + "F degrees and " + humidity + "% humidity";
    }
}
