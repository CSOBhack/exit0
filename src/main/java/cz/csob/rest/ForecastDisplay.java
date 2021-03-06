package cz.csob.rest;

import cz.csob.rest.apimodel.actions.ActionsResponse;
import org.vaadin.maddon.layouts.MVerticalLayout;

/**
 *
 * @author Matti Tahvonen <matti@vaadin.com>
 */
public class ForecastDisplay extends MVerticalLayout {

    String mainTemplate = "Actions id %s, power %s";
    String detailTemplate = "### %tD \n %s°, %s";

    public ForecastDisplay() {
    }

    public void setForecast(ActionsResponse fr) {
        removeAllComponents();
        /*
        addComponent(new Header(String.format(mainTemplate,
                fr.getPower())));
        /*
        removeAllComponents();
        addComponents(
                new Header(String.format(mainTemplate,
                                fr.getCity().getName(),
                                fr.getList().get(0).getWeather().get(0).
                                getDescription()))
        );

        Calendar cal = Calendar.getInstance();
        for (Forecast f : fr.getList()) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
            Date date = cal.getTime();
            Double temperature = f.getTemp().getDay();
            String desc = f.getWeather().get(0).getDescription();
            String md = String.format(detailTemplate, date, temperature, desc);
            addComponent(new RichText().withMarkDown(md));
        }
        */
    }

}