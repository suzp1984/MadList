/**
 * Created by moses on 4/29/15.
 */

package org.zpcat.madlist;

import org.zpcat.madlist.widget.OverscrollListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class OverScrollListActivity extends Activity {
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
        mArrayNumbersAdapter = ArrayAdapter.createFromResource(this,
                R.array.simple_nums, android.R.layout.simple_list_item_1);

        mOverScrollLv.setAdapter(mArrayNumbersAdapter);
    }
}
