package cz.csob.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import cz.csob.rest.apimodel.ActionsResponse;
import cz.csob.rest.model.ForecastResponse;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jetty.connector.JettyConnectorProvider;

/**
 */
public class ActionsJsonService {

    private Client client;
    private WebTarget target;

    public ActionsJsonService() {
        ClientConfig cc = new ClientConfig();
        cc.connectorProvider(new JettyConnectorProvider());
        cc.register(new LoggingFilter());
        client = ClientBuilder.newClient(cc);
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric
        target = client.target(
                "http://csob-hackathon.herokuapp.com:80/api/v1/actions.json");
    }

    public ActionsResponse getData() {
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(ActionsResponse.class);
    }
}