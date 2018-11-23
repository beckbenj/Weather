package de.fh.albsig.beckbenj86251.WeatherWeb;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(value = Lifecycle.PER_CLASS)
public class FormatterTest {

    private static Logger log = Logger.getLogger(FormatterTest.class);
    public Weather mockedWeather;
    private Weather weather;

    @BeforeAll
    public void setup() {
        this.weather = null;
        this.mockedWeather = null;

    }

    @BeforeEach
    public void beforeTest() {
        this.weather = new Weather();
        this.mockedWeather = mock(Weather.class);
        when(this.mockedWeather.getCity()).thenReturn("Berlin");
        when(this.mockedWeather.getRegion()).thenReturn("BW");
        when(this.mockedWeather.getCountry()).thenReturn("Germany");
        when(this.mockedWeather.getCondition()).thenReturn("dark");
        when(this.mockedWeather.getHumidity()).thenReturn("60");
        when(this.mockedWeather.getTemp()).thenReturn("20");
    }

    @Test
    public void TempTest() {

        this.weather.setTemp("20");
        this.weather.setRegion("BW");
        this.weather.setCountry("Germany");
        this.weather.setCondition("dark");
        this.weather.setHumidity("60");
        this.weather.setCity("Berlin");
        assertTrue(StringUtils.contains(this.mockedWeather.getTemp(),
                this.weather.getTemp()));
        assertTrue(StringUtils.contains(this.mockedWeather.getRegion(),
                this.weather.getRegion()));
        assertTrue(StringUtils.contains(this.mockedWeather.getCountry(),
                this.weather.getCountry()));
        assertTrue(StringUtils.contains(this.mockedWeather.getCondition(),
                this.weather.getCondition()));
        assertTrue(StringUtils.contains(this.mockedWeather.getHumidity(),
                this.weather.getHumidity()));
        assertTrue(StringUtils.contains(this.mockedWeather.getCity(),
                this.weather.getCity()));

    }

    @AfterEach
    public void cleanEach() {
        this.weather = null;
    }

    @AfterAll
    public void cleanUp() {
        try {
            final File file = new File("src/test/resources/testFormatter.txt");
            file.delete();
        } catch (final Exception e) {
            log.error(e.getMessage());
        }
    }

}