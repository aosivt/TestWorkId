package aos;

import javax.servlet.annotation.WebServlet;


import aos.UIObjects.ControllPanel.ControllPanel;
import aos.UIObjects.ControllPanel.MainGrid;
import aos.UIObjects.ResultPanel.ResultPanel;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")

@JavaScript({
        "vaadin://jquery-3.1.1.js",
        "vaadin://plotly-latest.min.js",
        "vaadin://connect-plotly.js"
})
public class MainController extends UI {

    ControllPanel controllPanel;
    ResultPanel resultPanel;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        controllPanel = new ControllPanel(this);
        resultPanel = new ResultPanel(this);

        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.addComponentsAndExpand(controllPanel);
        mainLayout.addComponentsAndExpand(resultPanel);
        setContent(mainLayout);
    }

    public ControllPanel getControllPanel() {
        return controllPanel;
    }

    public ResultPanel getResultPanel() {
        return resultPanel;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainController.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}
