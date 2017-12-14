package aos.UIObjects.ControllPanel;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;

import java.util.Arrays;
import java.util.List;

public class ListTypeLink extends ComboBox<String> {

    private String currentLink;
    public ListTypeLink(){

        setItems(getItemsTypeLink());
        setPlaceholder("Тип трафика");
        setCaption("Выбрать тип трафика");
        setEmptySelectionAllowed(false);

        addValueChangeListener(this::setCurrentLink);
    }

    private void setCurrentLink(ValueChangeEvent<String> event) {
        currentLink = event.getValue().equals("Up")?"countUpLink":"countDownLink";

        Notification.show("Value changed:",
                String.valueOf(currentLink),
                Notification.Type.TRAY_NOTIFICATION);
    }


    private List<String> getItemsTypeLink(){
        return Arrays.asList("Up","Down");
    }

    private List<String> getDatasTypeLink(){
        return Arrays.asList("countUpLink","countDownLink");
    }

    public String getCurrentLink() {
        return currentLink;
    }
}
