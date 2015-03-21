package cz.csob;

import cz.csob.rest.TrafficJsonService;

import cz.csob.rest.apimodel.traffic.Events;


public class NodeTraffic {

    private TrafficJsonService service;

    public NodeTraffic (TrafficJsonService service) {
        this.service = service;
    }

    public String getData (String nodeId) {
        String response = "";
        for (int i = 0; i < service.getTrafficResponse().get_embedded().getEvents().length; i++) {
            Events event = service.getTrafficResponse().get_embedded().getEvents()[i];
            if (nodeId == event.get_embeddedInside().getNode()) {
                System.out.println(response);
                response += event.toString();
            }
        }
        return response;
    }
}
