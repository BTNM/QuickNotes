package com.example.btnm.quicknotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

//ItemTouchHelper allows you to determine the direction of an event
public class ItemMovesCallback extends ItemTouchHelper.Callback {
    private final ItemTouchHelperInterface interfaceAdapter;

    public ItemMovesCallback(ItemTouchHelperInterface adapter) {
        interfaceAdapter = adapter;
    }

    /**
     * override getMovementFlags() to specify which directions of drags and swipes are supported
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int draggedFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;

        return makeMovementFlags(draggedFlags, swipeFlags);
    }

    @Override
    public boolean isLongPressDragEnabled() {
//        return super.isLongPressDragEnabled();
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
//        return super.isItemViewSwipeEnabled();
        return true;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        interfaceAdapter.onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition() );

        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        interfaceAdapter.onItemDismiss(viewHolder.getAdapterPosition() );
    }


    public interface ItemTouchHelperInterface {
        /**
         * Called when an item has been dragged far enough to trigger a move. This is called every time
         * an item is shifted, and <strong>not</strong> at the end of a "drop" event.<br/>
         * @param fromPosition
         * @param toPosition
         */
        Boolean onItemMoved(int fromPosition, int toPosition);

//        void onItemSelected(NoteRecycleViewAdapter.RecycleViewHolder viewHolder);

        /**
         * Called when an item has been dismissed by a swipe
         * @param position
         */
        void onItemDismiss(int position);

    }

}
