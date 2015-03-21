package cz.csob;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import cz.csob.chart.DonutChart;
import cz.csob.gmap.GoogleMapCmp;
import cz.csob.rest.AllJsonServices;
import cz.csob.tomas.hracicka.TomikuvTab;

import javax.servlet.annotation.WebServlet;
import java.util.Arrays;

/**
 *
 */
@Theme("mytheme")
@Widgetset("cz.csob.MyAppWidgetset")
public class MyUI extends UI {

    AllJsonServices service = new AllJsonServices();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);


        // vaadin demo
        Button button = new Button("Click Me");

        TabSheet tab = new TabSheet();
        TabSheet.Tab btnTab = tab.addTab(new VerticalLayout(button), "Click Demo");
        tab.addTab(new DonutChart(), "Chart");
        tab.addTab(new TomikuvTab(service).getTomikuvTab(), "Tomas Hracicka");
        tab.addTab(new GoogleMapCmp(), "Google Maps");

        layout.addComponent(tab);

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                ((VerticalLayout) btnTab.getComponent()).addComponent(new Label("Thank you for clicking"));
            }
        });
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
