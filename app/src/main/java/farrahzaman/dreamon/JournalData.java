package farrahzaman.dreamon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farrahzaman on 26/03/15.
 */
public class JournalData {
    public static JournalData journalData = new JournalData();
    private int nextJournalId = 1;
    private List<Journal> journals = new ArrayList<Journal>();

    public List<Journal> findAll() {
        return journals;
    }

    public Journal save(Journal journal){
        if (journal._id == 0) {
            journal._id = nextJournalId;
            nextJournalId++;
            journals.add(journal);
        } else {
            for (int i=0; i<journals.size(); i++) {
                Journal current = journals.get(i);
                if (current._id == journal._id) {
                    journals.set(i, journal);
                    break;
                }
            }
        }
        //TODO saveJournal();
        return journal;
    }

    public void delete(int id) {
        for (int i=0; i<journals.size(); i++) {
            Journal current = journals.get(i);
            if (current._id == id) {
                journals.remove(i);
                break;
            }

        }
    }
}
