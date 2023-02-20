package notebook.Service;
import notebook.Application;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * TODO: mark this class as an @Component, so that it may be within the NotebookService class.
 * This is a Service class that will be used to obtain the current time for notebook entries.
 */
public class TimeService {

    public String getCurrentTime(){
        long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMillis);
        Application.log.info("TimeService: Generated the current time and date: "+currentDate);
        return currentDate.toString();
    }
}
