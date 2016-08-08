package main;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 29.90f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weather) {
        weather.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        show();
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
}
