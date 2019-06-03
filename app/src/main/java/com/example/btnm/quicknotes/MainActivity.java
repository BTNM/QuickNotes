package com.example.btnm.quicknotes;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.btnm.quicknotes.tabFragments.tabFragment;

public class MainActivity extends AppCompatActivity {
    private SectionPageAdapter sectionPageAdaper;
    private ViewPager mViewPager;

    private Toolbar toolbar;

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
        sectionPageAdaper.removeCurrentFragment(pos);
        sectionPageAdaper.notifyDataSetChanged();

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
