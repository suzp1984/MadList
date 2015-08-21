package org.zpcat.madlist.adapter;

import org.zpcat.madlist.R;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moses on 8/21/15.
 */
public class MultiViewHolderAdapter extends RecyclerView.Adapter<MultiViewHolderAdapter.BaseMultiViewHolder> {

    private final List<ItemContent> mItemContents = new ArrayList<>();

    @Override
    public BaseMultiViewHolder onCreateViewHolder(ViewGroup parent,
            int viewType) {
        BaseMultiViewHolder viewHolder = null;
        View view;

        switch (viewType) {
            case TitleViewHolder.VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_multi_view_title, parent, false);
                viewHolder = new TitleViewHolder(view);
                break;
            case BodyViewHolder.VIEW_TYPE:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_multi_view_body, parent, false);
                viewHolder = new BodyViewHolder(view);
                break;
            default:
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseMultiViewHolder holder, int position) {
        int type = getItemViewType(position);
        ItemContent item = mItemContents.get(position);

        switch (type) {
            case TitleViewHolder.VIEW_TYPE:
                TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
                titleViewHolder.mTextView.setText(item.title);
                break;
            case BodyViewHolder.VIEW_TYPE:
                BodyViewHolder bodyViewHolder = (BodyViewHolder) holder;
                bodyViewHolder.titleView.setText(item.bodyTitle);
                bodyViewHolder.bodyView.setText(item.bodyContent);

                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItemContents.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mItemContents.get(position).type;
    }

    public void addItemContents(int type, String title, String body, String subBody) {
        mItemContents.add(new ItemContent(type, title, body, subBody));
    }

    class BaseMultiViewHolder extends RecyclerView.ViewHolder {

        public BaseMultiViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class TitleViewHolder extends BaseMultiViewHolder {
        public static final int VIEW_TYPE = 0;

        TextView mTextView;

        public TitleViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public class BodyViewHolder extends BaseMultiViewHolder {
        public static final int VIEW_TYPE = 1;

        CardView cardView;
        TextView titleView;
        TextView bodyView;

        public BodyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardlist_item);
            titleView = (TextView) itemView.findViewById(R.id.item_title);
            bodyView = (TextView) itemView.findViewById(R.id.item_body);
        }
    }

    public class ItemContent {
        int type;
        String title;
        String bodyTitle;
        String bodyContent;

        public ItemContent(int type, String title, String bodyTitle, String bodyContent) {
            this.type = type;
            this.title = title;
            this.bodyTitle = bodyTitle;
            this.bodyContent = bodyContent;
        }
    }
}
