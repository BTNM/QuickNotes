package com.example.btnm.quicknotes;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

// viewpage adapter for the swipe tabs, for the fragments
class SectionPageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    private long baseId = 0;

    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    public SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void removeCurrentFragment (int position) {
        mFragmentTitleList.remove(position);
        mFragmentList.remove(position);

    }

//    //this is called when notifyDataSetChanged() is called
//    @Override
//    public int getItemPosition(@NonNull Object object) {
////        return super.getItemPosition(object);
//        return PagerAdapter.POSITION_NONE;
//    }
//
//    /**
//     * give an ID different from position, when the position has been changed
//     * @param position
//     * @return
//     */
//    @Override
//    public long getItemId (int position) {
//        return baseId + position;
//    }
//
//    /**
//     * Notify that the position of a fragment has been changed.
//     * Create a new ID for each position to force recreation of the fragment
//     * @param n number of items which have been changed
//     */
//    public void notifyChangeInPosition(int n) {
//        // shift the ID returned by getItemId outside the range of all previous fragments
//        baseId += getCount() + n;
//    }

}
