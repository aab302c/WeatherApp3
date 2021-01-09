package com.example.weather3.presentation.cities;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class CityItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private ItemTouchHelperAdapter itemTouchHelperAdapter;

    public CityItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.itemTouchHelperAdapter = itemTouchHelperAdapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = 0;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        itemTouchHelperAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    public interface ItemTouchHelperAdapter {
        void onItemDismiss(int position);
    }
}
