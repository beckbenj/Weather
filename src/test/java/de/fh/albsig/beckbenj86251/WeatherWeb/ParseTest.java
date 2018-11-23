package de.fh.albsig.beckbenj86251.WeatherWeb;

import static org.junit.Assert.assertTrue;

import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

class WeatherParserTest {

    private final ClassLoader LOADER = WeatherParserTest.class.getClassLoader();

    @Test
    void test() throws Exception {
        final InputStream testData = this.LOADER
                .getResourceAsStream("test.xml");

        final Weather weather = new YahooParser().parse(testData);

        assertTrue(StringUtils.contains("Frankfurt", weather.getCity()));
        assertTrue(StringUtils.contains("Germany", weather.getCountry()));
        assertTrue(StringUtils.contains(" HE", weather.getRegion()));
        assertTrue(StringUtils.contains("38", weather.getTemp()));
        assertTrue(StringUtils.contains("36", weather.getChill()));
        assertTrue(StringUtils.contains("74", weather.getHumidity()));
    }

}