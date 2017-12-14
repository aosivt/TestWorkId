package aos.UIObjects.ResultPanel;

import aos.MainController;
import aos.UIObjects.ControllPanel.ControllPanel;
import com.vaadin.ui.Panel;

public class ResultPanel extends Panel {

    private MainController mainController;
    private ResultControllGrid resultControllGrid;
    public ResultPanel(MainController components){
        mainController = components;
        resultControllGrid = new ResultControllGrid();
        setCaption("Результаты");
        setContent(resultControllGrid);
    }

    public MainController getMainController() {
        return mainController;
    }

    public ResultControllGrid getResultControllGrid() {
        return resultControllGrid;
    }
}
