package aos.UIObjects.ControllPanel;

import aos.MainController;
import com.vaadin.ui.Panel;

public class ControllPanel extends Panel{
    private MainGrid mainGrid;
    private MainController mainController;
    public ControllPanel(MainController components){
        mainController = components;
        mainGrid = new MainGrid();
        setCaption("Данные для расчета");
        setContent(mainGrid);
    }

    public MainGrid getMainGrid() {
        return mainGrid;
    }

    public MainController getMainController() {
        return mainController;
    }
}
