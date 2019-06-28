package com.example.btnm.quicknotes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteRecycleViewAdapter extends RecyclerView.Adapter<NoteRecycleViewAdapter.RecycleViewHolder> {

    private ArrayList<Note> mNoteList;
    private Boolean mIsViewAsList = true;

    /**
     *  the layout and content of an each item in the recycleview
     *  takes the info from view in xml into each element in the recycleview
     */
    public static class RecycleViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView typeIcon;
        public ImageView typeIconImg;
        public TextView description;
        public ImageView colorIcon;
        public ImageView deleteIcon;

        /**
         * represent each item in the recycleview, by itemView
         * @param itemView
         */
        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
            typeIcon = itemView.findViewById(R.id.typeIconText);
            typeIconImg = itemView.findViewById(R.id.typeIcon);
            description = itemView.findViewById(R.id.description);
            colorIcon = itemView.findViewById(R.id.colorIcon);
            deleteIcon = itemView.findViewById(R.id.deleteIcon);

        }

    }

    /**
     * Takes a List<Model> as a parameter which is the data to display,
     * @param noteList list of all items in the recycle view
     * @param isViewAsList decide which layout for recycleview
     */
    public NoteRecycleViewAdapter (ArrayList<Note> noteList, Boolean isViewAsList) {
        mNoteList = noteList;
        mIsViewAsList = isViewAsList;
    }


    /**
     * this method is responsible for creating our ViewHolder
     *
     * Create a View by inflating our XML layout
     * Return an instance of our ViewHolder while passing the previously created view as parameter.
     * inflate layout from xml file into each alarm element
     * @param viewGroup
     * @param i
     * @return return recycleView Holder with the inflated layout
     */
    @NonNull
    @Override
    public NoteRecycleViewAdapter.RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext() );
//        View itemView = inflater.inflate(R.layout.list_item, viewGroup, false);
        View itemView = inflater.inflate(mIsViewAsList ? R.layout.list_item : R.layout.grid_item, null);

//        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(mIsViewAsList ? R.layout.layout_listview : R.layout.layout_gridview, null);
        RecycleViewHolder recycleViewHolder = new RecycleViewHolder(itemView );


        return recycleViewHolder;
    }

    /**
     * method binds our ViewHolder with the model, which each item in recycleview has
     * Cast the RecyclerView.ViewHolder to the ViewHolder that we’ve created
     * Use the helper bindData method to actually connect the model and UI
     * on each alarm element take image and txt
     * @param recycleViewHolder
     * @param i position of the item in the arraylist
     */
    @Override
    public void onBindViewHolder(@NonNull NoteRecycleViewAdapter.RecycleViewHolder recycleViewHolder, int i) {
        Note currentItem = mNoteList.get(i);

        recycleViewHolder.title.setText(currentItem.getTitle() );
        recycleViewHolder.typeIcon.setText(currentItem.getTypeIcon() );
        recycleViewHolder.typeIconImg.setImageResource(currentItem.getTypeIconImageId() );
        recycleViewHolder.description.setText(currentItem.getDescription() );

        recycleViewHolder.colorIcon.setImageResource(R.drawable.ic_color);
        recycleViewHolder.deleteIcon.setImageResource(R.drawable.ic_delete);

    }

    @Override
    public int getItemCount() {
        return mNoteList.size();
    }


}
