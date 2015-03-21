package cz.csob.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import cz.csob.rest.model.ForecastResponse;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jetty.connector.JettyConnectorProvider;

/**
 */
public class JsonService {

    private Client client;
    private WebTarget target;

    public JsonService() {
        ClientConfig cc = new ClientConfig();
        cc.connectorProvider(new JettyConnectorProvider());
        cc.register(new LoggingFilter());
        client = ClientBuilder.newClient(cc);
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric
        target = client.target(
                "http://api.openweathermap.org/data/2.5/forecast/daily").queryParam("cnt", "10")
                .queryParam("mode", "json")
                .queryParam("units", "metric");
    }

    public ForecastResponse getForecast(String place) {
        return target.queryParam("q", place)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(ForecastResponse.class);
    }
}