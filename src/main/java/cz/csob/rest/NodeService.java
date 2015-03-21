package cz.csob.rest;

import cz.csob.rest.model.node.NodeResponse;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jetty.connector.JettyConnectorProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 */
public class NodeService {

    private Client client;
    private WebTarget target;

    public NodeService() {
        ClientConfig cc = new ClientConfig();
        cc.connectorProvider(new JettyConnectorProvider());
        cc.register(new LoggingFilter());
        client = ClientBuilder.newClient(cc);
        //example query params: ?q=Turku&cnt=10&mode=json&units=metric
        target = client.target(
                "http://csob-hackathon.herokuapp.com/api/v1/nodes");
    }

    public NodeResponse getData() {
        return target.request(MediaType.APPLICATION_JSON_TYPE)
                .get(NodeResponse.class);
    }
}