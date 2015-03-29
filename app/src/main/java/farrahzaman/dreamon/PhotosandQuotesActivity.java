package farrahzaman.dreamon;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import farrahzaman.dreamon.R;

public class PhotosandQuotesActivity extends Activity {
    int imageResourceId = R.drawable.mosswoman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photosand_quotes);
    }

    public void changeImage(View v) {
        ImageView inspirationImageView = (ImageView) findViewById(R.id.inspirationImage);
        if (imageResourceId == R.drawable.mosswoman) {
            imageResourceId = R.drawable.cloudbaby;
        } else if (imageResourceId == R.drawable.cloudbaby) {
            imageResourceId = R.drawable.mosswoman;
        }
        inspirationImageView.setBackgroundResource(imageResourceId);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.photosand_quotes, menu);
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
