package com.example.btnm.quicknotes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Note> {
    public ListViewAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View v = convertView;

        if (null == v) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

        Note note = getItem(position);
        ImageView img = (ImageView) v.findViewById(R.id.typeIcon);
        TextView textTitle = (TextView) v.findViewById(R.id.textTitle);
        TextView textIconText = (TextView) v.findViewById(R.id.typeIconText);
        TextView textDescription = (TextView) v.findViewById(R.id.description);

        img.setImageResource(note.getTypeIconImageId() );
        textTitle.setText(note.getTitle() );
        textIconText.setText(note.getTypeIcon() );
        textDescription.setText(note.getDescription() );

        return v;
    }
}
