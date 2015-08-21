package org.zpcat.madlist.adapter;

import org.zpcat.madlist.R;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by moses on 8/21/15.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {

    private final List<String> mSimpleItems = new LinkedList<>();

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_multi_view_title, parent, false);

        SimpleViewHolder viewHolder = new SimpleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.titleView.setText(mSimpleItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mSimpleItems.size();
    }

    public void addText(String str) {
        mSimpleItems.add(0, str);
    }

    class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;

        public SimpleViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
