package cz.csob.tomas.hracicka;

import com.vaadin.data.Item;
import com.vaadin.ui.Table;
import cz.csob.rest.apimodel.actions.Actions;


/**
 * Created by Valovi on 21.3.2015.
 */
public class TomasActionsTable {

    private static String ID = "ID";
    private static String PRICE = "PRICE";
    private static String NAME = "NAME";
    private static String POWER = "POWER";

    public static Table getActionsTable(Actions actions[]) {
        Table table = new Table("Tomikova prvni tabulka: Actions");
        table.addContainerProperty(ID, String.class, null);
        table.addContainerProperty(NAME, String.class, null);
        table.addContainerProperty(PRICE, String.class, null);
        table.addContainerProperty(POWER, String.class, null);

        for (Actions action : actions) {
            Object newItemId = table.addItem();
            Item row = table.getItem(newItemId);
            row.getItemProperty(ID).setValue(action.getId());
            row.getItemProperty(NAME).setValue(action.getName());
            row.getItemProperty(PRICE).setValue(action.getPrice());
            row.getItemProperty(POWER).setValue(action.getPower());
        }

        table.setPageLength(table.size());
        return table;
    }
}
