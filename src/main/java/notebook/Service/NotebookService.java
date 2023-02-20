package notebook.Service;

import notebook.Application;
import notebook.Model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a component, which makes it a potential Bean. When Spring undergoes its initial Component Scan,
 * this class will be turned into a bean which may be injected into other classes, such as the NotebookController.
 *
 * TODO: TimeService hasn't been labelled a Component yet, so it can't be injected into the Constructor as a Bean!
 * You will need to add the @Component annotation to TimeService.
 */
@Component
public class NotebookService {
    List<Entry> entries;
    TimeService timeService = new TimeService();

    @Autowired
    public NotebookService(TimeService timeService){
        this.timeService = timeService;
        entries = new ArrayList<>();
        Application.log.info("NotebookService: Just instantiated a new NotebookService! Dependency injection for the win");
    }

    public List<Entry> getEntries(){
        Application.log.info("NotebookService: Getting all entries: "+entries);
        return entries;
    }

    public Entry addEntry(Entry entry){
        entry.setTime(timeService.getCurrentTime());
        entries.add(entry);
        Application.log.info("NotebookService: Added a new entry: "+entry);
        return null;
    }

    public Entry getEntriesById(int entryNumber) {
        Entry entry = entries.get(entryNumber);
        Application.log.info("NotebookService: Getting an entry by id: "+entryNumber+" which is "+entry);
        return entry;
    }

    /**
     * TODO: add the service method necessary for the deletion of a notebook entry.
     */

}
