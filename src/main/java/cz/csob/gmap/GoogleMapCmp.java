package cz.csob.gmap;

import com.google.common.collect.Lists;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.events.MarkerClickListener;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.*;
import cz.csob.chart.AttackLine;
import cz.csob.chart.LayersChart;
import cz.csob.rest.NodeService;
import cz.csob.rest.model.node.Node;
import cz.csob.rest.model.node.NodeResponse;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by roman.zakutny on 21.3.2015.
 */
public class GoogleMapCmp extends VerticalLayout {

    private GoogleMap googleMap;

    private NodeService service = new NodeService();

    private final String apiKey = "";

    public GoogleMapCmp() {
        setSizeFull();

        googleMap = new GoogleMap(null, null, null);
        googleMap.setCenter(new LatLon(49.72, 15.67));
        googleMap.setZoom(8);
        googleMap.setSizeFull();

        NodeResponse response = service.getData();
        for (final Node node : response.get_embedded().getNodes()) {
            LatLon position = new LatLon(NumberUtils.toDouble(node.getVenue_lat()), NumberUtils.toDouble(node.getVenue_long()));
            System.out.println(position);
            GoogleMapMarker nodeMarker = new GoogleMapMarker(
                    node.getVenue_name(), position,
                    false, null);
            nodeMarker.setAnimationEnabled(true);
            googleMap.addMarker(nodeMarker);

            googleMap.addMarkerClickListener(new MarkerClickListener() {
                @Override
                public void markerClicked(GoogleMapMarker clickedMarker) {
                    if (clickedMarker.equals(nodeMarker)) {
                        showWindow(node);
                    }
                }
            });
        }

        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);

        addComponent(googleMap);
        setExpandRatio(googleMap, 1.0f);
    }

    public void showWindow(Node node) {

        // Create the window...
        VerticalLayout content = new VerticalLayout();
        Window subwindow = new Window(node.getVenue_name(), content);
        // ...and make it modal
        subwindow.setModal(true);
        subwindow.setClosable(true);
        subwindow.setWindowMode(WindowMode.MAXIMIZED);

        // Configure the windws layout; by default a VerticalLayout
        VerticalLayout layout = (VerticalLayout) subwindow.getContent();
        layout.setMargin(true);
        layout.setSpacing(true);

        // Add some content; a label and a close-button
        Label message = new Label(node.getInfo(), ContentMode.HTML);
        content.addComponent(message);

        TabSheet tab = new TabSheet();
        tab.setSizeFull();
        tab.addTab(new LayersChart(node.get_embedded().getLayers()), "Layers");

        Map<String, List<Number>> attacks = new HashMap<>();
        attacks.put("DDOS", Lists.newArrayList(7.0, 8, 9, 14, 18, 21, 25, 26, 23, 18,
                13, 9));
        attacks.put("Trojan", Lists.newArrayList(0, 1, 5, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1,
                8.6, 2.5));
        attacks.put("Phishing", Lists.newArrayList(0, 1, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9,
                1.0));

        tab.addTab(new AttackLine(attacks), "Attacks");

        content.addComponent(tab);

        UI.getCurrent().addWindow(subwindow);
    }
}
