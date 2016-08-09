package test;

import main.ForecastDisplay;
import main.WeatherData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForecastDisplayTest {

    @Test
    public void displaysForecast() {
        WeatherData weather = new WeatherData();
        ForecastDisplay forecastDisplay = new ForecastDisplay(weather);
        weather.setMeasurements(80, 65, 30.4f);
        assertEquals(forecastDisplay.show(), "Forecast: Improving weather on the way!");
    }
}