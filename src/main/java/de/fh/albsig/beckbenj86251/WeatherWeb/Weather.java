package de.fh.albsig.beckbenj86251.WeatherWeb;

/**
 * @author Benjamin Beck
 *
 */
public class Weather {

    private String city;
    private String region;
    private String country;
    private String condition;
    private String temp;
    private String chill;
    private String humidity;

    /**
     * @return city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param vcity
     *            input
     */
    public void setCity(final String vcity) {
        this.city = vcity;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * @param vregion
     *            input
     */
    public void setRegion(final String vregion) {
        this.region = vregion;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @param vcountry
     *            input
     */
    public void setCountry(final String vcountry) {
        this.country = vcountry;
    }

    /**
     * @return condition
     */
    public String getCondition() {
        return this.condition;
    }

    /**
     * @param vcondition
     *            input
     */
    public void setCondition(final String vcondition) {
        this.condition = vcondition;
    }

    /**
     * @return temp
     */
    public String getTemp() {
        return this.temp;
    }

    /**
     * @param vtemp
     *            input
     */
    public void setTemp(final String vtemp) {
        this.temp = vtemp;
    }

    /**
     * @return chill
     */
    public String getChill() {
        return this.chill;
    }

    /**
     * @param vchill
     *            input
     */
    public void setChill(final String vchill) {
        this.chill = vchill;
    }

    /**
     * @return humidity
     */
    public String getHumidity() {
        return this.humidity;
    }

    /**
     * @param vhumidity
     *            input
     */
    public void setHumidity(final String vhumidity) {
        this.humidity = vhumidity;
    }

}
