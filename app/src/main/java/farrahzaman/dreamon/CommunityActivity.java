package farrahzaman.dreamon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        for (Journal journal : JournalData.journalData.findAll()) {
            text = text + journal.getDate() + " | " + journal.getTitle() + "\n" + journal.getDream() + "\n\n";
        }
        textOtherDreamersJournals.setText(text);


        Button buttonMyJournal = (Button) findViewById(R.id.buttonMyJournal);

        buttonMyJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), JournalActivity.class);
                startActivity(intent);

            }

         });

        Button buttonCommFaves = (Button) findViewById(R.id.buttonCommFaves);
        buttonCommFaves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "Saved to Favourites";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        });


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