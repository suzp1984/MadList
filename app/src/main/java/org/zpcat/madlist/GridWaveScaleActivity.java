package org.zpcat.madlist;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;


public class GridWaveScaleActivity extends AppCompatActivity {

    private List<ResolveInfo> mApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadApps();
        setContentView(R.layout.activity_grid_wave_scale);
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new AppsAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gride_wave_scale, menu);
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

    private void loadApps() {
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        mApps = getPackageManager().queryIntentActivities(mainIntent, 0);
    }

    public class AppsAdapter extends BaseAdapter {
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(GridWaveScaleActivity.this);

            ResolveInfo info = mApps.get(position % mApps.size());

            i.setImageDrawable(info.activityInfo.loadIcon(getPackageManager()));
            i.setScaleType(ImageView.ScaleType.FIT_CENTER);
            final int w = (int) (36 * getResources().getDisplayMetrics().density + 0.5f);
            i.setLayoutParams(new GridView.LayoutParams(w, w));
            return i;
        }


        public final int getCount() {
            return Math.min(32, mApps.size());
        }

        public final Object getItem(int position) {
            return mApps.get(position % mApps.size());
        }

        public final long getItemId(int position) {
            return position;
        }
    }
}
