package farrahzaman.dreamon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import farrahzaman.dreamon.R;

public class JournalActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        final EditText textJournalDate = (EditText) findViewById(R.id.textJournalDate);
        final EditText textJournalTitle = (EditText) findViewById(R.id.textJournalTitle);
        final EditText textJournalDream = (EditText) findViewById(R.id.textJournalDream);

        // get the 'save' button by Id
        final Button buttonSave = (Button) findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Journal journal = new Journal();
                journal._date = textJournalDate.getText().toString();
                journal._title = textJournalTitle.getText().toString();
                journal._dream = textJournalDream.getText().toString();

                JournalData.journalData.save(journal);
                JournalData.journalData.saveToFile(JournalActivity.this);
                startActivity(new Intent(JournalActivity.this, DreamMainActivity.class));


                Context context = getApplicationContext();
                CharSequence text = "Saved";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }

        });

        Button buttonFavourite = (Button) findViewById(R.id.buttonFavourite);
        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                CharSequence text = "Saved to Favourites";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }


        });

        Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (view.getContext(),SearchDreamActivity.class);
                startActivity(intent);

            }
        });

            }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.journal, menu);
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
