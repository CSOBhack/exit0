package cz.csob.rest;

import cz.csob.rest.apimodel.traffic.TrafficResponse;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jetty.connector.JettyConnectorProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 */
public class TrafficJsonService {

    private Client client;
    private WebTarget target;

    public TrafficJsonService() {
        ClientConfig cc = new ClientConfig();
        cc.connectorProvider(new JettyConnectorProvider());
        cc.register(new LoggingFilter());
        client = ClientBuilder.newClient(cc);
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric

        String pageNumberParam = "1";
        String perPageParam = "2";

        target = client.target(
                "http://csob-hackathon.herokuapp.com:80/api/v1/traffic.json")
                .queryParam("page", pageNumberParam)
                .queryParam("per_page", perPageParam);
    }

    public TrafficResponse getTrafficResponse() {
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(TrafficResponse.class);
    }
}