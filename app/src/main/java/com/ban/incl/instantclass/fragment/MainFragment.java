package com.ban.incl.instantclass.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.SingleListFragment;


public class MainFragment extends Fragment {
    private FragmentActivity mActivity;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

//        LinearLayout mLayoutCalendar = (LinearLayout) view.findViewById(R.id.listcalendar);
//
//        mLayoutCalendar.removeAllViews();
//
//        for (int i = 0; i < 15; i++){
//
//        }
        /*
        HorizontalScrollView scrollView = (HorizontalScrollView) view.findViewById(R.id.horizontalScrollView);

        LinearLayout topLinearLayout = new LinearLayout(view.getContext());
        // topLinearLayout.setLayoutParams(android.widget.LinearLayout.LayoutParams.FILL_PARENT,android.widget.LinearLayout.LayoutParams.FILL_PARENT);
        topLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < 15; i++){
            final ImageView imageView = new ImageView(view.getContext());

            imageView.setTag(i);

            imageView.setImageResource(R.drawable.ic_launcher);

            topLinearLayout.addView(imageView);

            imageView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    // TODO Auto-generated method stub
                    Log.e("Tag", "" + imageView.getTag());
                }
            });
        }

        scrollView.addView(topLinearLayout);
        */

        view.findViewById(R.id.btn_main_recommand).setOnClickListener(mainListener);
        view.findViewById(R.id.btn_main_region).setOnClickListener(mainListener);
        view.findViewById(R.id.btn_main_all).setOnClickListener(mainListener);

        return view;
    }

    Button.OnClickListener mainListener = new View.OnClickListener() {
        public void onClick(View v) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            switch (v.getId()) {
                case R.id.btn_main_recommand:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, SingleListFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.btn_main_region:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, SingleListFragment.newInstance())
                            .commit();
                    break;
                case R.id.btn_main_all:
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, SingleListFragment.newInstance())
                            .commit();
                    break;
            }
        }
    };

}
