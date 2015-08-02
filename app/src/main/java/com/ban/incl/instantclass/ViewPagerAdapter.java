package com.ban.incl.instantclass;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ban.incl.instantclass.fragment.InclRecyclerFragment;
import com.ban.incl.instantclass.fragment.SingleListFragment;

/**
 * Created by clive on 25-May-14.
 * www.101apps.co.za
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence    mViewPagerContentType;
    CharSequence[]  mAdapterList;

    public ViewPagerAdapter(FragmentManager fragmentManager, CharSequence type) {
        super(fragmentManager);

        mViewPagerContentType = type;

        if("REGION".equals(mViewPagerContentType)) {
            mAdapterList = TitleClass.region;
        } else {
            mAdapterList = TitleClass.list_type;
        }
    }

    //    returns the number of views available
    @Override
    public int getCount() { return mAdapterList.length; }

    // when swiping returns a fragment with the object identified by position
    @Override
    public Fragment getItem(int position) {
        if("REGION".equals(mViewPagerContentType)) {
            return InclRecyclerFragment.newInstance();
        } else {
            return SingleListFragment.newInstance();
        }
//        return ArrayListFragment.createNewFragmentToDisplay(position);
    }

    /*gets the title describing specified page
    and passes it to the PagerTitleStrip in
    fragment_pager.xml - displays either top or
    bottom of screen*/
    @Override
    public CharSequence getPageTitle(int position) {
        return mAdapterList[position];
    }
}
