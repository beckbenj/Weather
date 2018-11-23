package de.fh.albsig.beckbenjamin86251.weather;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

/**
 * @author Benjamin Beck
 *
 */
public class WeatherFormatter {
    /**
     *
     */
    private static Logger log = Logger.getLogger(WeatherFormatter.class);
    /**
     *
     */
    private static final ClassLoader LOADER = WeatherFormatter.class
            .getClassLoader();

    /**
     * @param weather w
     * @return String w
     * @throws ParseErrorException w
     * @throws MethodInvocationException w
     * @throws ResourceNotFoundException w
     * @throws IOException w
     */
    public final String format(final Weather weather)
            throws ParseErrorException, MethodInvocationException,
            ResourceNotFoundException, IOException {

        WeatherFormatter.log.info("Formatting Weather Data");

        final Reader reader = new InputStreamReader(
                LOADER.getResourceAsStream("output.vm"));

        final VelocityContext context = new VelocityContext();
        context.put("weather", weather);

        final StringWriter writer = new StringWriter();

        Velocity.evaluate(context, writer, "", reader);

        return writer.toString();
    }
}
