package aos.UIObjects.ResultPanel;

import aos.UIObjects.ControllPanel.*;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class ResultControllGrid extends GridLayout{

    private Label volumeTraffics;
    private Label trafficCapacity;

    public ResultControllGrid(){
        setOptions();
    }

    public Label getVolumeTraffics() {
        return volumeTraffics;
    }

    public void setVolumeTraffics(Label volumeTraffics) {
        this.volumeTraffics = volumeTraffics;
    }

    public Label getTrafficCapacity() {
        return trafficCapacity;
    }

    public void setTrafficCapacity(Label trafficCapacity) {
        this.trafficCapacity = trafficCapacity;
    }

    private void setOptions(){

        volumeTraffics = new Label("Объем данных (байт): ");
        trafficCapacity = new Label("Пропускная способность (бит/сек): ");
        setSizeFull();
        setRows(1);
        setColumns(2);
        setSpacing(true);

        addComponent(getVolumeTraffics(), 0,0);
        addComponent(getTrafficCapacity(), 1,0);

        for (int col=0; col<getColumns(); col++) {
            for (int row=0; row<getRows(); row++) {
                Component c = getComponent(col, row);
                setComponentAlignment(c, Alignment.TOP_CENTER);

            }
        }

    }
}
