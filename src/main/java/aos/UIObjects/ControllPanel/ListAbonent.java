package aos.UIObjects.ControllPanel;

import aos.Repository.Directories;
import aos.Repository.UpdaterDirectoriesTables;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;

import java.util.Collection;
import java.util.List;

public class ListAbonent extends ComboBox<Directories> {
    private Collection<Directories> abonents;
    private String currentAbonent;
    public ListAbonent(){
        abonents = UpdaterDirectoriesTables.select("Abonent");
        setItems(abonents);
        setCaption("Выбрать абонента");
        setItemCaptionGenerator(Directories::getDirName);
        setEmptySelectionAllowed(false);

        addValueChangeListener(this::setCurrentAbonent);
    }

    private void setCurrentAbonent(ValueChangeEvent<Directories> abonentValueChangeEvent) {
        currentAbonent = abonentValueChangeEvent.getValue().getDirName();
        Notification.show("Value changed:",
                String.valueOf(currentAbonent),
                Notification.Type.TRAY_NOTIFICATION);
    }

    public String getCurrentAbonent(){
        return currentAbonent;
    }


}
