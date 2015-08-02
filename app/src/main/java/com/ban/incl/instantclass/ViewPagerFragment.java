package com.ban.incl.instantclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerFragment extends Fragment {

    ViewPagerAdapter mAdapter;
    ViewPager mPager;

    CharSequence mViewPagerContentType;

    public ViewPagerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        get this fragment's number
        if (getArguments() != null) {
            mViewPagerContentType = getArguments().getCharSequence("TYPE");
        } else {
            mViewPagerContentType = "REGION";
        }
    }

    public static ViewPagerFragment newInstance(CharSequence type) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putCharSequence("TYPE", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);

        mAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), mViewPagerContentType);

        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        return view;
    }


}
