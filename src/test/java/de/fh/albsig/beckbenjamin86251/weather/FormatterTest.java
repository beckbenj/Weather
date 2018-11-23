package de.fh.albsig.beckbenjamin86251.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(value = Lifecycle.PER_CLASS)
public class FormatterTest {

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
        assertEquals(this.mockedWeather.getTemp(), this.weather.getTemp());
        assertEquals(this.mockedWeather.getRegion(), this.weather.getRegion());
        assertEquals(this.mockedWeather.getCountry(), this.weather.getCountry());
        assertEquals(this.mockedWeather.getCondition(), this.weather.getCondition());
        assertEquals(this.mockedWeather.getHumidity(), this.weather.getHumidity());
        assertEquals(this.mockedWeather.getCity(), this.weather.getCity());

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
            e.printStackTrace();
        }
    }

}