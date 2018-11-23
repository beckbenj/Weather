package de.fh.albsig.beckbenjamin86251.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.log4j.PropertyConfigurator;
import org.dom4j.DocumentException;

/**
 * @author Ich
 *
 */
public class Main {

    /**
     * @param args
     *            City and country
     * @throws Exception
     *             exception
     */
    public static void main(final String[] args) throws Exception {
        // Configure Log4J
        PropertyConfigurator.configure(
                Main.class.getClassLoader().getResource("log4J.properties"));

        String city = "nome";
        String countrydefault = "ak";

        try {
            city = args[0];
            countrydefault = args[1];
        } catch (final Exception e) {
            e.printStackTrace();
        }

        // Start the program
        try {
            new Main(city, countrydefault).start();
        } catch (IOException | DocumentException
                | URISyntaxException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     *
     */
    private final String ci;
    /**
     *
     */
    private final String co;

    /**
     * @param city
     *            city
     * @param country
     *            country
     */
    public Main(final String city, final String country) {
        this.ci = city;
        this.co = country;
    }


    /**
     * @throws DocumentException w
     * @throws URISyntaxException w
     * @throws IOException w
     */
    public final void start()
            throws DocumentException, URISyntaxException, IOException {

        final Writetoxml xml = new Writetoxml();

        // Retrieve Data
        final InputStream dataIn = new YahooRetriever().retrieve(this.ci,
                this.co);

        // Parse Data
        final Weather weather = new YahooParser().parse(dataIn);

        // Formate (Print) Data
        System.out.print(new WeatherFormatter().format(weather));

        xml.xmlOutput(weather, "C:\\Users\\Ich\\Desktop\\Weather\\");
    }
}
