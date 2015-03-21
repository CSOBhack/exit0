package cz.csob.chart;


import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.themes.ValoLightTheme;
import com.vaadin.ui.Component;
import cz.csob.rest.model.node.Layer;
import cz.csob.rest.model.system.System;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

@SuppressWarnings("serial")
public class LayersChart extends AbstractVaadinChartExample {

    private static Random rand = new Random(0);
    private static Color[] colors = new ValoLightTheme().getColors();
    private final Layer[] layers;

    public LayersChart(Layer[] layers) {
        this.layers = layers;
    }

    @Override
    public String getDescription() {
        return "Up/Down Layers";
    }

    @Override
    protected Component getChart() {
        Component ret = createChart();
        ret.setWidth("100%");
        ret.setHeight("450px");
        return ret;
    }

    public Chart createChart() {
        rand = new Random(0);

        int up = 0;
        int down = 0;

        Map<System, Integer> upMap = new HashMap<>();
        Map<System, Integer> downMap = new HashMap<>();

        for (System system : System.class.getEnumConstants()) {
            upMap.put(system, 0);
            downMap.put(system, 0);
        }

        for (Layer layer : layers) {
            System system = System.class.getEnumConstants()[NumberUtils.toInt(layer.getLevel()) - 1];

            if (NumberUtils.toInt(layer.getCurrent_robustness()) > 0) {
                up++;
                upMap.put(system, upMap.get(system) + 1);
            } else {
                down++;
                downMap.put(system, downMap.get(system) + 1);
            }
        }

        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Up/Down Layers");

        YAxis yaxis = new YAxis();
        yaxis.setTitle("---");

        PlotOptionsPie pie = new PlotOptionsPie();
        pie.setShadow(false);
        conf.setPlotOptions(pie);

        conf.getTooltip().setValueSuffix("%");

        DataSeries innerSeries = new DataSeries();
        innerSeries.setName("Status");
        PlotOptionsPie innerPieOptions = new PlotOptionsPie();
        innerSeries.setPlotOptions(innerPieOptions);
        innerPieOptions.setSize(237);
        innerPieOptions.setDataLabels(new Labels());
        innerPieOptions.getDataLabels().setFormatter(
                "this.y > 5 ? this.point.name : null");
        innerPieOptions.getDataLabels().setColor(new SolidColor(255, 255, 255));
        innerPieOptions.getDataLabels().setDistance(-30);

        Color[] innerColors = Arrays.copyOf(colors, 5);
        innerSeries.setData(new String[]{"Up Layers", "Down Layers"}, new Number[]{100*(up/(double)(up+down)), 100*(down/(double)(up+down))}, innerColors);

        DataSeries outerSeries = new DataSeries();
        outerSeries.setName("System");
        PlotOptionsPie outerSeriesOptions = new PlotOptionsPie();
        outerSeries.setPlotOptions(outerSeriesOptions);
        outerSeriesOptions.setInnerSize(237);
        outerSeriesOptions.setSize(318);
        outerSeriesOptions.setDataLabels(new Labels());
        outerSeriesOptions
                .getDataLabels()
                .setFormatter(
                        "this.y > 1 ? ''+ this.point.name +': '+ this.y +'%' : null");

        List<DataSeriesItem> list = new ArrayList<>();
        for (System system : System.class.getEnumConstants()) {
            list.add(new DataSeriesItem(system.toString(), 100*(upMap.get(system) / (double)(down+up)), color(0)));
        }
        for (System system : System.class.getEnumConstants()) {
            list.add(new DataSeriesItem(system.toString(), 100*(downMap.get(system) / (double)(down+up)), color(1)));
        }


        outerSeries.setData(list);
        conf.setSeries(innerSeries, outerSeries);
        chart.drawChart(conf);

        return chart;
    }

    /**
     * Add a small random factor to a color form the vaadin theme.
     *
     * @param colorIndex the index of the color in the colors array.
     * @return the new color
     */
    private static SolidColor color(int colorIndex) {
        SolidColor c = (SolidColor) colors[colorIndex];
        String cStr = c.toString().substring(1);

        int r = Integer.parseInt(cStr.substring(0, 2), 16);
        int g = Integer.parseInt(cStr.substring(2, 4), 16);
        int b = Integer.parseInt(cStr.substring(4, 6), 16);

        double opacity = (50 + rand.nextInt(95 - 50)) / 100.0;

        return new SolidColor(r, g, b, opacity);
    }
}