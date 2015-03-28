package farrahzaman.dreamon;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by farrahzaman on 26/03/15.
 */
public class JournalData {
    private static final String FILENAME = "dream_journal.bin";
    public static JournalData journalData = new JournalData();
    private int nextJournalId = 1;
    private List<Journal> journals = new ArrayList<Journal>();

    public List<Journal> findAll() {
        return journals;
    }

    public void saveToFile(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(journals);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readFromFile(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            journals = (List<Journal>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
