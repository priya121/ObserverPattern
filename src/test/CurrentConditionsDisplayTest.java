package test;

import main.CurrentConditionsDisplay;
import main.WeatherData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrentConditionsDisplayTest {

    @Test
    public void displaysCurrentConditions() {
        WeatherData weather = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weather);
        weather.setMeasurements(80, 65, 30.4f);
        assertEquals(conditionsDisplay.show(), "Current conditions: 80.0F degrees and 65.0% humidity");
    }
}