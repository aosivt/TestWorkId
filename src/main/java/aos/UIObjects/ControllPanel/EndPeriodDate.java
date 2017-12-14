package aos.UIObjects.ControllPanel;

import com.vaadin.data.HasValue;
import com.vaadin.shared.ui.datefield.DateTimeResolution;
import com.vaadin.ui.DateTimeField;

import java.time.LocalDateTime;
import java.util.Date;

public class EndPeriodDate extends DateTimeField {

    private LocalDateTime dateEndPeriod;

    public EndPeriodDate(){
        setCaption("Конец периода");
        setResolution(DateTimeResolution.SECOND);
        addValueChangeListener(this::setEndPeriod);
    }

    private void setEndPeriod(ValueChangeEvent<LocalDateTime> localDateTimeValueChangeEvent) {
        dateEndPeriod = localDateTimeValueChangeEvent.getValue();
    }
    public LocalDateTime getDate(){
        return dateEndPeriod;
    }
}
