package cz.csob.tomas.hracicka;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import cz.csob.rest.apimodel.actions.Actions;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Valovi on 21.3.2015.
 */
public class TomasActionsChart {

    public static Chart getActionsChart(Actions actions[]) {

        Chart chart = new Chart(ChartType.COLUMN);
        chart.setWidth("1000px");  // 100% by default
        chart.setHeight("900px"); // 400px by default

        Configuration conf = chart.getConfiguration();
        conf.setTitle("Tomikuv prvni grafik");
        conf.setSubTitle("Actions");

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setBackgroundColor("#FFFFFF");
        legend.setHorizontalAlign(HorizontalAlign.LEFT);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(100);
        legend.setY(70);
        legend.setFloating(true);
        legend.setShadow(true);
        conf.setLegend(legend);

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
