package main;

public class StatisticsDisplay implements  Observer, DisplayElement{
    private float maxTemp;
    private float minTemp;
    private  int numberOfReadings;
    private float sumOfTemps;

    public StatisticsDisplay(WeatherData weather) {
        weather.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        sumOfTemps += temperature;
        numberOfReadings ++;
        if (temperature > maxTemp) {
            maxTemp = temperature;
        }

        if (temperature < minTemp) {
            minTemp = temperature;
        }
        show();

    }

    @Override
    public String show() {
        return "Avg/Max/Min temperature = " + (sumOfTemps / numberOfReadings)
                + "/" + maxTemp + "/" + minTemp;
    }
}
