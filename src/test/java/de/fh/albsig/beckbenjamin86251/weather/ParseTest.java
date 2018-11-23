package de.fh.albsig.beckbenjamin86251.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;

import org.junit.jupiter.api.Test;


final class WeatherParserTest
{

    private final ClassLoader LOADER = WeatherParserTest.class.getClassLoader();


    @Test
    void test() throws Exception
    {
        final InputStream testData = this.LOADER.getResourceAsStream("test.xml");

        final Weather weather = new YahooParser().parse(testData);

        assertEquals("Frankfurt", weather.getCity());
        assertEquals("Germany", weather.getCountry());
        assertEquals(" HE", weather.getRegion());
        assertEquals("38", weather.getTemp());
        assertEquals("36", weather.getChill());
        assertEquals("74", weather.getHumidity());
    }

}