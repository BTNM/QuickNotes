package com.example.btnm.quicknotes;

import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btnm.quicknotes.tabFragments.tabFragment;

public class MainActivity extends AppCompatActivity {
    private SectionPageAdapter sectionPageAdaper;
    private ViewPager mViewPager;

    private Toolbar toolbar;

    EditText fragmentName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        sectionPageAdaper = new SectionPageAdapter(getSupportFragmentManager() );
        initializeTabLayout();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quick Notes");
//        toolbar.setSubtitle("Test subtitle");
//        toolbar.setLogo(R.drawable.ic_note_color);
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTab();
//                removeCurrentTab();
            }
        });
    }



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
                msg = "add";
                addTab();
                break;
            case R.id.search:
                msg = "search";
                addFragmentPropmpt();
//                confirmDialogDemo();
//                promptDialogDemo();
                break;
            case R.id.delete:
                msg ="delete";
                removeCurrentTab();

                break;
            case R.id.setting:
                msg = "setting";
                break;
            case R.id.logout:
                msg = item.getTitle().toString();
                break;
        }
        Toast.makeText(MainActivity.this, msg+" checked", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    private void addTab() {
        sectionPageAdaper.addFragment(new tabFragment(), "tab");
        sectionPageAdaper.notifyDataSetChanged();
    }

    private void removeCurrentTab () {
        int pos = mViewPager.getCurrentItem();
//        System.out.println("current fragment pos: " + pos);
        sectionPageAdaper.removeCurrentFragment(pos);
        sectionPageAdaper.notifyDataSetChanged();

    }

    public void addFragmentPropmpt () {
//        fragmentName = new EditText(context);
        final EditText editText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("test title");
        builder.setMessage("Name of the note category: ");
//        builder.setCancelable(false);
        builder.setView(editText);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Hello " + editText.getText() + " ! how are you?", Toast.LENGTH_LONG).show();
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

    private void confirmDialogDemo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm dialog demo !");
        builder.setMessage("You are about to delete all records of database. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've choosen to delete all records", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    private void promptDialogDemo() {
        final EditText edtText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prompt dialog demo !");
        builder.setMessage("What is your name?");
//        builder.setCancelable(false);
        builder.setView(edtText);
        builder.setNeutralButton("Prompt", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Hello " + edtText.getText() + " ! how are you?", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

    private void initializeTabLayout() {
        //ViewPagers animates screen slides automatically, then add the different tabs/fragment to the viewpager
        mViewPager = (ViewPager) findViewById(R.id.container);

        initializeViewPager(mViewPager);

        //connect the viewPager to the tabLayout in the xml
        TabLayout tabLayout = (TabLayout) findViewById(R.id.allTabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void initializeViewPager(ViewPager viewPager) {
        // SectionPageAdapter extends FragmentPageAdapter to add all fragments into a fragment list
        sectionPageAdaper = new SectionPageAdapter (getSupportFragmentManager() );
        sectionPageAdaper.addFragment(new tabFragment(), "tab1");
        sectionPageAdaper.addFragment(new tabFragment(), "tab2");

        viewPager.setAdapter(sectionPageAdaper);
    }


}
