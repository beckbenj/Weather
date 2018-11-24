package de.fh.albsig.beckbenj86251.WeatherWeb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.dom4j.DocumentException;

/**
 * @author Benjamin Beck
 *
 */
public class WeatherServiceAPI {

    /**
     * empty construcktor.
     */
    public WeatherServiceAPI() {
    }

    /**
     * @param city
     *            w
     * @param countryCode
     *            w
     * @return output.vm
     * @throws URISyntaxException
     *             w
     * @throws IOException
     *             w
     * @throws DocumentException
     *             w
     */
    public String retrieveForecast(final String city, final String countryCode)
            throws URISyntaxException, IOException, DocumentException {
        // Retrieve Daten
        final InputStream dataIn = new YahooRetriever().retrieve(city,
                countryCode);
        // Parse Data
        final Weather weather = new YahooParser().parse(dataIn);
        // Format (Print) Data
        return new WeatherFormatter().format(weather);
    }

}
