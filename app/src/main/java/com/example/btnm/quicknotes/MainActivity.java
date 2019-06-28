package com.example.btnm.quicknotes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.btnm.quicknotes.tabFragments.tabFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SectionPageAdapter sectionPageAdaper;
    private ViewPager mViewPager;


    private Toolbar toolbar;
//    private ViewStub stubGrid;
//    private ViewStub stubList;
//    private ListView listView;
//    private GridView gridView;
//    private ListViewAdapter listViewAdapter;
//    private GridViewAdapter gridViewAdapter;
//
//    private int currentViewMode = 0;
//    static final int VIEW_MODE_LISTVIEW = 0;
//    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionPageAdaper = new SectionPageAdapter(getSupportFragmentManager() );

        initializeTabLayout();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quick Notes");
//        toolbar.setSubtitle("Test subtitle");
//        toolbar.setLogo(R.drawable.ic_note_color);
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

//        stubList = findViewById(R.id.stub_list);
//        stubGrid = findViewById(R.id.stub_grid);
//        // inflate ViewStub before get view
//        stubList.inflate();
//        stubGrid.inflate();
//        listView = (ListView) findViewById(R.id.listView);
//        gridView = (GridView) findViewById(R.id.gridView);

//        // get list of notes
//        getNoteList();

//        //get current view mode in share references
//        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE );
//        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_LISTVIEW);
//        // register item click
////        listView.setOnClickListener( onItemClick);
////        gridView.setOnClickListener( onItemClick);
//        listView.setOnItemClickListener(onItemClick);
//        gridView.setOnItemClickListener(onItemClick);
//        switchView();

//        initializeRecycleView();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("from activity");
////                addTab();
////                removeCurrentTab();
//            }
//        });
    }

//    private void initializeRecycleView() {
//
//
//    }

//    private void switchView() {
//        // display listview and hides gridview, and opposite
//        if (VIEW_MODE_LISTVIEW == currentViewMode) {
//            stubList.setVisibility(View.VISIBLE);
//            stubGrid.setVisibility(View.GONE);
//        } else {
//            stubList.setVisibility(View.GONE);
//            stubGrid.setVisibility(View.VISIBLE);
//        }
//        setAdapters();
//    }
//    private void setAdapters() {
//        if (VIEW_MODE_LISTVIEW == currentViewMode) {
//            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, noteList);
//            listView.setAdapter(listViewAdapter);
//        } else {
//            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, noteList);
//            gridView.setAdapter(gridViewAdapter);
//        }
//
//    }
//    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            // do any thing when user click to item
//            Toast.makeText(getApplicationContext(), noteList.get(position).getTitle() + " - " + noteList.get(position).getDescription(), Toast.LENGTH_LONG ).show();
//        }
//    };

    /**
     * Initialize the contents of the Activity's standard options menu. You should place your menu items in to menu.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate custom menu from xml file
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch (item.getItemId()) {
            case R.id.add:
//                msg = "add";
                addFragmentPrompt();
//                addTab(name);
                break;
            case R.id.search:
                msg = "search";
                return false;
//                break;

//                addFragmentPrompt();
//                confirmDialogDemo();
//                promptDialogDemo();
            case R.id.SwitchView:
                msg = "switchView";

                return false;
//                if (VIEW_MODE_LISTVIEW == currentViewMode) {
//                    currentViewMode = VIEW_MODE_GRIDVIEW;
//                } else {
//                    currentViewMode = VIEW_MODE_LISTVIEW;
//                }
//                switchView();
//                // save view in shared preferences
//                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putInt("currentViewMode", currentViewMode);
//                editor.commit();
//                break;
            case R.id.delete:
                msg ="delete";
                removeFragmentPrompt();

                break;
            case R.id.setting:
                msg = "setting";
                break;
            case R.id.logout:
                msg = item.getTitle().toString();
                break;
        }
//        Toast.makeText(MainActivity.this, msg+" checked", Toast.LENGTH_LONG).show();

        return false;
//        return super.onOptionsItemSelected(item);

    }



    private void addTab(String name) {
        if (name != null) {
            sectionPageAdaper.addFragment(new tabFragment(), name);
        }
        sectionPageAdaper.notifyDataSetChanged();
    }

    private void removeCurrentTab (int position) {
//        int pos = mViewPager.getCurrentItem();
//        System.out.println("current fragment pos: " + pos);
        sectionPageAdaper.removeCurrentFragment(position);
        sectionPageAdaper.notifyDataSetChanged();

    }

    public void addFragmentPrompt () {
//        fragmentName = new EditText(context);
        final EditText editText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set Name");
        builder.setMessage("Set the Name of the note category: ");
        builder.setCancelable(false);
        builder.setView(editText);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = editText.getText().toString();

                if (name.trim().length() != 0) {
                    addTab( name);
                } else {
                    Toast.makeText(getApplicationContext(),"Input are empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

//        builder.show();
        //create alertdialog and always shows keyboard before showing it
        AlertDialog dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        dialog.show();

    }

    private void removeFragmentPrompt() {
        final int pos = mViewPager.getCurrentItem();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Delete Tab!");
        builder.setMessage("Do you want to delete the tab: "+ "\"" +sectionPageAdaper.getPageTitle(pos)+ "\" " +"\nDo you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "You've choosen to delete all records", Toast.LENGTH_SHORT).show();
                removeCurrentTab(pos);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

//    private void promptDialogDemo() {
//        final EditText edtText = new EditText(this);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Prompt dialog demo !");
//        builder.setMessage("What is your name?");
////        builder.setCancelable(false);
//        builder.setView(edtText);
//        builder.setNeutralButton("Prompt", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "Hello " + edtText.getText() + " ! how are you?", Toast.LENGTH_LONG).show();
//            }
//        });
//        builder.show();
//    }

    private void initializeTabLayout() {
        //ViewPagers animates screen slides automatically, then add the different tabs/fragment to the viewpager
        mViewPager = (ViewPager) findViewById(R.id.viewPagerContainer);

        initializeViewPager(mViewPager);

        //connect the viewPager to the tabLayout in the xml
        TabLayout tabLayout = (TabLayout) findViewById(R.id.allTabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void initializeViewPager(ViewPager viewPager) {
        // SectionPageAdapter extends FragmentPageAdapter to add all fragments into a fragment list
        sectionPageAdaper = new SectionPageAdapter (getSupportFragmentManager() );
        sectionPageAdaper.addFragment(new tabFragment(), "Quick Notes");
        sectionPageAdaper.addFragment(new tabFragment(), "tab2");

        viewPager.setAdapter(sectionPageAdaper);
    }


}
