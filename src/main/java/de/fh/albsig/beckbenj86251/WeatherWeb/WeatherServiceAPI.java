package de.fh.albsig.beckbenj86251.WeatherWeb;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.dom4j.DocumentException;

/**
 * @author 9
 *
 */
public class WeatherServiceAPI {

    /**
     * Construcktor.
     */
    public WeatherServiceAPI() {
    }

    /**
     * @param city w
     * @param countryCode w
     * @return output.vm
     * @throws URISyntaxException w
     * @throws IOException w
     * @throws DocumentException w
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

    /*
     * private static Logger log = Logger.getLogger(WeatherFormatter.class);
     * private String city; private String countryCode;
     *//**
     * @param args
     *            Argumente aus der Konsole
     */
    /*
     * public static void main(final String[] args) {
     *
     * PropertyConfigurator.configure(
     * WeatherService.class.getClassLoader().getResource("log4j.properties"));
     * this.city = "nome"; this.countryCode = "ak"; try { city = args[0];
     * countryCode = args[1]; } catch (Exception e) { log.error(e.getMessage());
     * }
     *
     * try { new WeatherService(city, countryCode).start(); } catch (IOException
     * | DocumentException | URISyntaxException e) {
     *
     * log.error(e.getMessage()); } }
     *
     *//**
     * @param ci
     *            Variable fuer Stadt
     */
    /*
     * private final String ci;
     *
     *//**
     * @param co
     *            Variable fuer Laenderkuerzel
     */
    /*
     * private final String co;
     *
     *//**
     * @param city
     *            Variable fuer Stadt
     * @param country
     *            Variable fuer Laenderkuerzel
     */
    /*
     * public WeatherService(final String city, final String country) {
     * this.city = city; this.countryCode = country; }
     *
     *//**
     * @throws DocumentException
     *             DocumentException
     * @throws URISyntaxException
     *             URISynteaxException
     * @throws IOException
     *             IOException
     *//*
     * public void start() throws DocumentException, URISyntaxException,
     * IOException { final String path = "src/main/resources/"; final
     * XMLOutput xml = new XMLOutput();
     *
     * // Retrieve Data final InputStream dataIn = new
     * YahooRetriever().retrieve(ci, co);
     *
     * // Parse Data final Weather weather = new
     * YahooParser().parse(dataIn);
     *
     * // Write in XML Doc xml.writeToXML(weather, path); // Format
     * (Print) Data System.out.print(new
     * WeatherFormatter().format(weather));
     *
     * }
     */

}