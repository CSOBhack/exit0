package cz.csob.tomas.hracicka;

import cz.csob.rest.AllJsonServices;
import org.vaadin.maddon.label.Header;
import org.vaadin.maddon.layouts.MHorizontalLayout;
import org.vaadin.maddon.layouts.MVerticalLayout;

/**
 * Created by Valovi on 21.3.2015.
 */
public class TomikuvTab {

    private AllJsonServices service;

    public TomikuvTab(AllJsonServices service) {
        this.service = service;
    }

    public MVerticalLayout getTomikuvTab() {
        return new MVerticalLayout(
                new Header("Tomas Hracicka"),
                new MHorizontalLayout(
                        TomasActionsTable.getActionsTable(service.getActions().get_embedded().getActions()),
                        TomasActionsChart.getActionsChart(service.getActions().get_embedded().getActions())));
    }



}
