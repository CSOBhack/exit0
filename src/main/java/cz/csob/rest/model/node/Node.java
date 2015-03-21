package cz.csob.rest.model.node;

import org.apache.commons.lang3.math.NumberUtils;

import java.text.MessageFormat;

/**
 * Created by roman.zakutny on 21.3.2015.
 */
public class Node {
    private String venue_long;

    private String id;

    private String ip_address;

    private String venue_address;

    private String venue_name;

    private String active_users;

    private String venue_lat;

    private EmbeddedLayers _embedded;

    private String parent_id;

    public String getVenue_long() {
        return venue_long;
    }

    public void setVenue_long(String venue_long) {
        this.venue_long = venue_long;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getVenue_address() {
        return venue_address;
    }

    public void setVenue_address(String venue_address) {
        this.venue_address = venue_address;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getActive_users() {
        return active_users;
    }

    public void setActive_users(String active_users) {
        this.active_users = active_users;
    }

    public String getVenue_lat() {
        return venue_lat;
    }

    public void setVenue_lat(String venue_lat) {
        this.venue_lat = venue_lat;
    }

    public EmbeddedLayers get_embedded() {
        return _embedded;
    }

    public void set_embedded(EmbeddedLayers _embedded) {
        this._embedded = _embedded;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "ClassPojo [venue_long = " + venue_long + ", id = " + id + ", ip_address = " + ip_address + ", venue_address = " + venue_address + ", venue_name = " + venue_name + ", active_users = " + active_users + ", venue_lat = " + venue_lat + ", _embedded = " + _embedded + ", parent_id = " + parent_id + "]";
    }

    public String getInfo() {
        return MessageFormat.format("<div>Address: {0}</div><div>IP: {1}</div><div>Active users: {2}</div><div>Up Layers: {3}</div>",
                getVenue_address(), getIp_address(), getActive_users(), getUpLayers());
    }

    public String getUpLayers() {
        Layer[] layers = get_embedded().getLayers();
        int up = 0;
        for (Layer layer : layers) {
            if (NumberUtils.toInt(layer.getCurrent_robustness()) > 0) up++;
        }
        return up + "/" + layers.length;
    }
}
