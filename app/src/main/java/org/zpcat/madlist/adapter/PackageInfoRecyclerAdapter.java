package org.zpcat.madlist.adapter;

import org.zpcat.madlist.R;

import android.content.pm.ResolveInfo;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moses on 8/20/15.
 */
public class PackageInfoRecyclerAdapter extends
        RecyclerView.Adapter<PackageInfoRecyclerAdapter.ItemViewHolder> {

    private final List<ResolveInfo> mListItems = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.package_info_item, parent, false);

        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        if (holder.title != null && holder.subTitle != null) {
            holder.title.setText(mListItems.get(position).activityInfo.name);
            holder.subTitle.setText(mListItems.get(position).activityInfo.packageName);

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(position, mListItems.get(position));
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public void addPackageInfo(ResolveInfo info) {
        if (info != null && !mListItems.contains(info)) {
            mListItems.add(info);
        }
    }

    public void setOnItemClickListener(final OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView title;
        TextView subTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardlist_item);
            title = (TextView) itemView.findViewById(R.id.list_item_name);
            subTitle = (TextView) itemView.findViewById(R.id.list_item_subname);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, ResolveInfo info);
    }
}
