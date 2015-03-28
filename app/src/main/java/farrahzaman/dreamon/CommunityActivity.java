package farrahzaman.dreamon;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import farrahzaman.dreamon.R;

public class CommunityActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        JournalData.journalData.readFromFile(this);
        TextView textOtherDreamersJournals = (TextView) findViewById(R.id.textOtherDreamersJournals);
        String text = "";
        for(Journal journal : JournalData.journalData.findAll()) {
            text = text + journal.getDate() + ", " + journal.getTitle() + "\n" + journal.getDream() + "\n\n";
        }
        textOtherDreamersJournals.setText(text);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.community, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}