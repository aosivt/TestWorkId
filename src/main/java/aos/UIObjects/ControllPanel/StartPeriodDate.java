package aos.UIObjects.ControllPanel;

import com.vaadin.shared.ui.datefield.DateTimeResolution;
import com.vaadin.ui.DateTimeField;

import java.time.LocalDateTime;

public class StartPeriodDate extends DateTimeField {
    private LocalDateTime dateStartPeriod;

    public StartPeriodDate(){
        setCaption("Начало периода");
        setResolution(DateTimeResolution.SECOND);
        addValueChangeListener(this::setStartPeriod);
    }

    private void setStartPeriod(ValueChangeEvent<LocalDateTime> localDateTimeValueChangeEvent) {
        dateStartPeriod = localDateTimeValueChangeEvent.getValue();
    }
    public LocalDateTime getDate(){
        return dateStartPeriod;
    }
}
