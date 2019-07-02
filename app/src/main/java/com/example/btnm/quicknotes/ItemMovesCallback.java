package com.example.btnm.quicknotes;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

//ItemTouchHelper allows you to determine the direction of an event
public class ItemMovesCallback extends ItemTouchHelper.Callback {
    private final ItemTouchHelperInterface interfaceAdapter;
    public static final float ALPHA_FULL = 1.0f;

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
        int draggedFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                           ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
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


//    @Override
//    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//            // Fade out the view as it is swiped out of the parent's bounds
//            final float alpha = ALPHA_FULL - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
//            viewHolder.itemView.setAlpha(alpha);
//            viewHolder.itemView.setTranslationX(dX);
//        } else {
//            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//        }
//    }

//    @Override
//    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
//        // We only want the active item to change
//        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
//            if (viewHolder instanceof ItemTouchHelperViewHolder) {
//                // Let the view holder know that this item is being moved or dragged
//                NoteRecycleViewAdapter.RecycleViewHolder itemViewHolder = (NoteRecycleViewAdapter.RecycleViewHolder) viewHolder;
//                itemViewHolder.onItemSelected();
//            }
//        }
//
//        super.onSelectedChanged(viewHolder, actionState);
//    }
//
//    @Override
//    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
//        super.clearView(recyclerView, viewHolder);
//
//        viewHolder.itemView.setAlpha(ALPHA_FULL);
//
//        if (viewHolder instanceof NoteRecycleViewAdapter.RecycleViewHolder) {
//            // Tell the view holder it's time to restore the idle state
//            NoteRecycleViewAdapter.RecycleViewHolder itemViewHolder = (NoteRecycleViewAdapter.RecycleViewHolder) viewHolder;
//            itemViewHolder.onItemClear();
//        }
//    }


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
