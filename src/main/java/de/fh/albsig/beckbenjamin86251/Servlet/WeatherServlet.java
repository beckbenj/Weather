package de.fh.albsig.beckbenjamin86251.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fh.albsig.beckbenj86251.WeatherWeb.WeatherServiceAPI;

/**
 * @author Benjamin Beck
 *
 */
public class WeatherServlet extends HttpServlet {
    @Override
    public void doGet(final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        final String city = request.getParameter("city");
        final String country = request.getParameter("country");
        final WeatherServiceAPI weatherService = new WeatherServiceAPI();
        final PrintWriter out = response.getWriter();
        try {
            out.println(weatherService.retrieveForecast(city, country));
        } catch (final Exception e) {
            out.println("Error Retrieving Forecast: " + e.getMessage());
        }
        out.flush();
        out.close();
    }
}
