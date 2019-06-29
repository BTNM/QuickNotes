package com.example.btnm.quicknotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemMovesCallback extends ItemTouchHelper.Callback {

    public ItemMovesCallback(ItemTouchHelperInterface adapter) {

    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return 0;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }


    public interface ItemTouchHelperInterface {
        void onRowMoved(int fromPosition, int toPosition);
        void onRowSelected(NoteRecycleViewAdapter.RecycleViewHolder viewHolder);
        void onRowClear(NoteRecycleViewAdapter.RecycleViewHolder viewHolder);

    }

}
