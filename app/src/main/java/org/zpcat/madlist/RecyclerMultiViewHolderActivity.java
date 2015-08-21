package org.zpcat.madlist;

import org.zpcat.madlist.adapter.MultiViewHolderAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerMultiViewHolderActivity extends AppCompatActivity {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private MultiViewHolderAdapter mMultiViewHolderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_multi_view_holder);

        ButterKnife.bind(this);

        mMultiViewHolderAdapter = new MultiViewHolderAdapter();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setAdapter(mMultiViewHolderAdapter);

        setupData();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);

        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    public void setupData() {
        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.TitleViewHolder.VIEW_TYPE, "a", "aa", "aaa");

        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "b", "bb", "bbb");
        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "c", "bb", "bbb");
        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "d", "bb", "bbb");

        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.TitleViewHolder.VIEW_TYPE, "ee", "ee", "ee");

        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.TitleViewHolder.VIEW_TYPE, "ff", "aa", "aaa");

        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "b", "bb", "bbb");
        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "c", "bb", "bbb");
        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "d", "bb", "bbb");

        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.TitleViewHolder.VIEW_TYPE, "ggggg", "aa", "aaa");

        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "b", "bb", "bbb");
        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "c", "bb", "bbb");
        mMultiViewHolderAdapter.addItemContents(MultiViewHolderAdapter.BodyViewHolder.VIEW_TYPE, "d", "bb", "bbb");
    }
}
