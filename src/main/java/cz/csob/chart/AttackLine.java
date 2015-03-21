package cz.csob.chart;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

import java.util.List;
import java.util.Map;

public class AttackLine extends AbstractVaadinChartExample {

    private final Map<String, List<Number>> attacks;

    public AttackLine(Map<String, List<Number>> attacks) {
        this.attacks = attacks;
    }

    @Override
    public String getDescription() {
        return "Attacks over time";
    }

    @Override
    protected Component getChart() {
        Chart chart = new Chart();
        chart.setHeight("450px");
        chart.setWidth("100%");

        Configuration configuration = chart.getConfiguration();
        configuration.getChart().setType(ChartType.LINE);
        configuration.getChart().setMarginRight(130);
        configuration.getChart().setMarginBottom(25);

        configuration.getTitle().setText("Attacks [last two hours]");

        int timeslot = 10;
        int slotCount = 12;
        String[] slots = new String[slotCount];

        for (int i = slotCount; i > 0; i--) {
            slots[slotCount - i] = "t - " + i * timeslot + " min.";
        }

        configuration.getxAxis().setCategories(slots);

        Axis yAxis = configuration.getyAxis();
        yAxis.setMin(-5d);
        yAxis.setTitle(new Title("Attacks"));
        yAxis.getTitle().setVerticalAlign(VerticalAlign.HIGH);

        configuration
                .getTooltip()
                .setFormatter("''+ this.series.name +''+this.x +': '+ this.y +'°C'");

        PlotOptionsLine plotOptions = new PlotOptionsLine();
        plotOptions.setDataLabels(new Labels(true));
        configuration.setPlotOptions(plotOptions);

        Legend legend = configuration.getLegend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setHorizontalAlign(HorizontalAlign.RIGHT);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setX(-10d);
        legend.setY(100d);
        legend.setBorderWidth(0);

        for (String key : attacks.keySet()) {
            ListSeries ls = new ListSeries();
            ls.setName(key);
            ls.setData(attacks.get(key));
            configuration.addSeries(ls);
        }

        chart.drawChart(configuration);
        return chart;
    }

}