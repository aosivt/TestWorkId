package aos.UIObjects.ControllPanel;

import aos.MainController;
import aos.Repository.UpdaterDirectoriesTables;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;

import java.time.ZoneId;
import java.util.Date;

public class ReseachTrafficButton extends Button {


    public ReseachTrafficButton(){
        setCaption("Сделать выборку");
        addClickListener(this::reseachTraffics);
    }

    private void reseachTraffics(ClickEvent clickEvent) {
        Notification.show("Value changed:",
                String.valueOf(((MainGrid)getParent()).getEndPeriodDate().getDate()),
                Notification.Type.TRAY_NOTIFICATION);

        ((MainGrid)getParent()).setVolumeResult(
                UpdaterDirectoriesTables.getVolumeTraffic(
                        String.valueOf(((MainGrid)getParent()).getListAbonent().getCurrentAbonent()),
                        String.valueOf(((MainGrid)getParent()).getListTypeLink().getCurrentLink()),
                        ((MainGrid)getParent()).getStartPeriodDate().getDate(),
                        ((MainGrid)getParent()).getEndPeriodDate().getDate()) * 8
        );

        ((MainGrid)getParent()).setSecondsBetween(
                (Date.from(((MainGrid)getParent()).getEndPeriodDate().getDate().atZone(ZoneId.systemDefault()).toInstant()).getTime()-
                Date.from(((MainGrid)getParent()).getStartPeriodDate().getDate().atZone(ZoneId.systemDefault()).toInstant()).getTime())
                /1000);




    }

}
