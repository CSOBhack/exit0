package cz.csob;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import cz.csob.chart.DonutChart;
import cz.csob.gmap.GoogleMapCmp;
import cz.csob.rest.ForecastDisplay;
import cz.csob.rest.JsonService;
import org.vaadin.maddon.label.Header;
import org.vaadin.maddon.layouts.MVerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 *
 */
@Theme("mytheme")
@Widgetset("cz.csob.MyAppWidgetset")
public class MyUI extends UI {

    JsonService service = new JsonService();
    ForecastDisplay display = new ForecastDisplay();
    NativeSelect citySelector = new NativeSelect("Choose city");

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);


        // rest
        citySelector.addItems("Turku", "San Francisco", "London");
        citySelector.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                // Note, if you rest service may take a while make it "asynchronously"
                // using e.g. ProgressIndicator
                display.setForecast(service.getForecast(citySelector.getValue().toString()));
            }
        });
        citySelector.setValue("Turku");

        // vaadin demo
        Button button = new Button("Click Me");

        TabSheet tab = new TabSheet();
        TabSheet.Tab btnTab = tab.addTab(new VerticalLayout(button), "Click Demo");
        tab.addTab(new DonutChart(), "Chart");
        tab.addTab(new MVerticalLayout(
                new Header("Simple REST weather"),
                citySelector,
                display
        ), "REST");
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
