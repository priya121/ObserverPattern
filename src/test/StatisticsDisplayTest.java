package test;

import main.StatisticsDisplay;
import main.WeatherData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatisticsDisplayTest {

     @Test
     public void displaysStatistics() {
          WeatherData weather = new WeatherData();
          StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weather);
          weather.setMeasurements(80, 65, 30.4f);
          assertEquals(statisticsDisplay.show(), "Avg/Max/Min temperature = 80.0/80.0/0.0");
     }
}