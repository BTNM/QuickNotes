package com.example.btnm.quicknotes.tabFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.btnm.quicknotes.MainActivity;
import com.example.btnm.quicknotes.Note;
import com.example.btnm.quicknotes.NoteRecycleViewAdapter;
import com.example.btnm.quicknotes.R;

import java.util.ArrayList;
import java.util.List;


public class tabFragment extends Fragment {
    private RecyclerView mRecycleView; // recycleview connects to the recycleview element in the xml
    private RecyclerView.Adapter mAdapter; // bridge that connects datalist to recycleview
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Note> noteList = new ArrayList<>();

    private Button btnTest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment,container, false);

        setupRecycleView(view);

//        btnTest = (Button) view.findViewById(R.id.btnTest);
//        btnTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Testing button click 1", Toast.LENGTH_SHORT).show();
//
//            }
//        });



        return view;
    }

    private void setupRecycleView(View view) {
        mRecycleView = view.findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext() );

        mAdapter = new NoteRecycleViewAdapter(noteList);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);

    }

    private List<Note> getNoteList() {
        // pseudo code to get note, replace your code to get real note here
        noteList = new ArrayList<>();
        noteList.add(new Note("Test Title1", R.drawable.ic_work,"Work", "Test description for the note") );
        noteList.add(new Note("Test Title2", R.drawable.ic_note_blue,"Work", "Test description for the note") );
        noteList.add(new Note("Test Title3", R.drawable.ic_work,"Work", "Test description for the note") );
        noteList.add(new Note("Test Title4", R.drawable.ic_note_color,"Work", "Test description for the note") );
        noteList.add(new Note("Test Title5", R.drawable.ic_work,"Work", "Test description for the note") );

        return noteList;


    }



}
