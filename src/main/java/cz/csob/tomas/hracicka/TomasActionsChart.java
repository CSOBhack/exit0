package cz.csob.tomas.hracicka;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.XAxis;
import cz.csob.rest.apimodel.actions.Actions;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Valovi on 21.3.2015.
 */
public class TomasActionsChart {

    private static String ID = "ID";
    private static String PRICE = "PRICE";
    private static String NAME = "NAME";
    private static String POWER = "POWER";

    public static Chart getActionsChart(Actions actions[]) {

        Chart chart = new Chart(ChartType.COLUMN);
        //chart.setWidth("1000px");  // 100% by default
        chart.setHeight("900px"); // 400px by default

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Tomikuv prvni grafik");
        conf.setSubTitle("Actions");

        ListSeries seriesPower = new ListSeries("Power");
        ListSeries seriesPrice = new ListSeries("Price");
        XAxis xaxis = new XAxis();
        xaxis.setTitle("Name");
        List<String> categories = new ArrayList<>();

        for (Actions action : actions) {
            seriesPower.addData(Integer.parseInt(action.getPower()));
            seriesPrice.addData(Integer.parseInt(action.getPrice()));
            categories.add(action.getName());
        }
        xaxis.setCategories(categories.toArray(new String[categories.size()]));

        conf.addSeries(seriesPower);
        conf.addSeries(seriesPrice);
        conf.addxAxis(xaxis);

        return chart;
    }
}
