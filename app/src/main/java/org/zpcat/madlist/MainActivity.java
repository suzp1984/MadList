package org.zpcat.madlist;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import org.zpcat.madlist.adapter.PackageInfoRecyclerAdapter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String CATEGORY_SAMPLE_LIST = "org.zpcat.madlist.sample_code";

    private final String TAG = "tag";

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.list)
    RecyclerView mRecyclerView;

    private PackageInfoRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);

            mToolbar.setTitle(R.string.app_name);
            mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        }

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new PackageInfoRecyclerAdapter();
        mAdapter.setOnItemClickListener(new PackageInfoRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, ResolveInfo info) {
                Intent intent = new Intent();
                intent.setClassName(info.activityInfo.applicationInfo.packageName,
                        info.activityInfo.name);

                startActivity(intent);
            }
        });

        initData();

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);

        super.onDestroy();
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

    private void initData() {
        Intent queryIntent = new Intent(Intent.ACTION_MAIN, null);
        queryIntent.addCategory(CATEGORY_SAMPLE_LIST);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> plist = pm.queryIntentActivities(queryIntent, 0);

        for (ResolveInfo info : plist) {
            Log.e(TAG, info.activityInfo.toString());

            mAdapter.addPackageInfo(info);

            /*CharSequence labelSeq = info.loadLabel(pm);
            String label = labelSeq != null ? labelSeq.toString() :
                    info.activityInfo.name;
            Intent intent = new Intent();
            intent.setClassName(info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name);

            Map<String, Object> temp = new HashMap<>();
            temp.put("title", label);
            temp.put("intent", intent);

            intentData.add(temp);*/
        }
    }
}
