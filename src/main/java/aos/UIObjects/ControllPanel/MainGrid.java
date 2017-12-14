package aos.UIObjects.ControllPanel;

import aos.MainController;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class MainGrid extends GridLayout{

    private ListAbonent listAbonent;
    private ListTypeLink listTypeLink;
    private StartPeriodDate startPeriodDate;
    private EndPeriodDate endPeriodDate;

    private Long volumeResult;
    private Long secondsBetween;




    public MainGrid(){
        setOptions();
    }


    public void setVolumeResult(Long volumeResult) {

        ((MainController)getParent().getParent().getParent())
                .getResultPanel()
                .getResultControllGrid()
                .getVolumeTraffics().setValue("Объем данных (байт): " + volumeResult);
        this.volumeResult = volumeResult;
    }

    public void setSecondsBetween(Long secondsBetween) {
        ((MainController)getParent().getParent().getParent())
                .getResultPanel()
                .getResultControllGrid()
                .getTrafficCapacity().setValue("Пропускная способность (бит/сек): " +
                    (double)volumeResult/(double)secondsBetween);
        this.secondsBetween = secondsBetween;
    }

    protected ListAbonent getListAbonent() {
        return listAbonent;
    }

    public ListTypeLink getListTypeLink() {
        return listTypeLink;
    }



    protected StartPeriodDate getStartPeriodDate() {
        return startPeriodDate;
    }

    protected EndPeriodDate getEndPeriodDate() {
        return endPeriodDate;
    }

    private void setOptions(){
        listAbonent = new ListAbonent();
        listTypeLink = new ListTypeLink();
        startPeriodDate = new StartPeriodDate();
        endPeriodDate = new EndPeriodDate();


        setSizeFull();
        setRows(1);
        setColumns(5);
        setSpacing(true);

        addComponent(listAbonent, 0,0);
        addComponent(listTypeLink, 1,0);
        addComponent(startPeriodDate, 2,0);
        addComponent(endPeriodDate, 3,0);
        addComponent(new ReseachTrafficButton(), 4,0);

        for (int col=0; col<getColumns(); col++) {
            for (int row=0; row<getRows(); row++) {
                Component c = getComponent(col, row);
                setComponentAlignment(c, Alignment.TOP_CENTER);

            }
        }

    }
}
