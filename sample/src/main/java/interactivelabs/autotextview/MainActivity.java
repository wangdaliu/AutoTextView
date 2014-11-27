package interactivelabs.autotextview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.auto.library.Subtitle;
import com.auto.library.SubtitleTextView;


public class MainActivity extends Activity {

    private SubtitleTextView mSubtitleTextView;

    private Subtitle mSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubtitleTextView = (SubtitleTextView) findViewById(R.id.subtitle);
        if (mSubtitle == null) {
            mSubtitle = new Subtitle(200, "dadasdasdasdadadadasdadadadadadaddadadadaddadadadadadadadadadaddadada");
            mSubtitle.start(mSubtitleTextView);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
