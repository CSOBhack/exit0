package cz.csob.rest;

import cz.csob.rest.apimodel.actions.ActionsResponse;
import cz.csob.rest.apimodel.actors.ActorsResponse;
import cz.csob.rest.apimodel.actorsimplified.ActorSimplifiedResponse;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jetty.connector.JettyConnectorProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 */
public class AllJsonServices {

    private Client client;
    private WebTarget target;

    public AllJsonServices() {
        ClientConfig cc = new ClientConfig();
        cc.connectorProvider(new JettyConnectorProvider());
        cc.register(new LoggingFilter());
        client = ClientBuilder.newClient(cc);
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric
    }

    public ActionsResponse getActions() {
        target = client.target(
                "http://csob-hackathon.herokuapp.com:80/api/v1/actions.json");
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(ActionsResponse.class);
    }

    public ActorsResponse getActors() {
        target = client.target(
                "http://csob-hackathon.herokuapp.com:80/api/v1/actors.json");
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(ActorsResponse.class);
    }

    public ActorSimplifiedResponse getActorSimplifiedResponse(int id) {
        target = client.target(
                "http://csob-hackathon.herokuapp.com/api/v1/actors/"+id+"/simplified.json");
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(ActorSimplifiedResponse.class);


    }
}