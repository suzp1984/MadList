package org.zpcat.madlist;

import org.zpcat.madlist.widget.OverscrollListView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ActionBarActivity {
    public static final String CATEGORY_SAMPLE_LIST = "org.zpcat.madlist.sample_code";

    private final String TAG = "tag";

    private OverscrollListView mOverScrollLv;

    private ArrayAdapter<CharSequence> mArrayNumbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();
        initData();
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

    private void findViewsById() {
        mOverScrollLv = (OverscrollListView) findViewById(R.id.lv_container);
    }

    private void initData() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(CATEGORY_SAMPLE_LIST);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> plist = pm.queryIntentActivities(mainIntent, 0);

        for (ResolveInfo info : plist) {
            Log.e(TAG, info.activityInfo.toString());

            CharSequence labelSeq = info.loadLabel(pm);
            String label = labelSeq != null ? labelSeq.toString() :
                    info.activityInfo.name;


        }

        mArrayNumbersAdapter = ArrayAdapter.createFromResource(this,
                R.array.simple_nums, android.R.layout.simple_list_item_1);

        mOverScrollLv.setAdapter(mArrayNumbersAdapter);
    }
}
