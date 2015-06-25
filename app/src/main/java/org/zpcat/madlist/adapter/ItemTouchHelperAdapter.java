package org.zpcat.madlist.adapter;

/**
 * Created by moses on 6/25/15.
 */
public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
