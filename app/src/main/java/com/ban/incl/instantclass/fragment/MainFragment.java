package com.ban.incl.instantclass.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ban.incl.instantclass.R;

import java.util.Calendar;


public class MainFragment extends Fragment {
    public enum eDayOfWeek { Sun, Mon, Tue, Wed, Thu, Fri, Sat; }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Init Calendar
        LinearLayout mLayoutCalendar = (LinearLayout) view.findViewById(R.id.calendar_list);
        mLayoutCalendar.removeAllViews();

        LayoutInflater vi = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < 50; i++) {
            if(i != 0) {
                cal.add(Calendar.DAY_OF_MONTH, 1);  // 하루씩 증가
            }

            View v;
            if(i == 0) {
                v = getCalendarDayView(vi, cal, true, false);
            } else {
                if(i % 2 == 0) {
                    v = getCalendarDayView(vi, cal, false, true);
                } else {
                    v = getCalendarDayView(vi, cal, false, false);
                }
            }

            mLayoutCalendar.addView(v, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        }
        view.findViewById(R.id.btn_cal_prev).setOnClickListener(mainListener);
        view.findViewById(R.id.btn_cal_next).setOnClickListener(mainListener);
        // Init Calendar End

        view.findViewById(R.id.btn_main_recommand).setOnClickListener(mainListener);
        view.findViewById(R.id.btn_main_region).setOnClickListener(mainListener);
        view.findViewById(R.id.btn_main_all).setOnClickListener(mainListener);

        return view;
    }

    public View getCalendarDayView(LayoutInflater vi, Calendar cal, boolean isToday, boolean hasTodo) {

        String year = String.valueOf(cal.get(Calendar.YEAR));
        String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
        String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        View dayView = vi.inflate(R.layout.main_calendar_item, null);

        TextView txtWeek = (TextView)dayView.findViewById(R.id.txt_calendar_week);
        TextView txtDay = (TextView)dayView.findViewById(R.id.txt_calendar_day);
        TextView ivFullDate_Hidden = (TextView)dayView.findViewById(R.id.txt_cal_fulldate_hidden);

        ImageView ivTodayBg = (ImageView)dayView.findViewById(R.id.iv_cal_today_bg);
        ImageView ivTodoBg = (ImageView)dayView.findViewById(R.id.iv_cal_todo_bg);

        dayView.findViewById(R.id.layout_cal_day).setOnClickListener(calendar_click_listener);

        if(isToday) {
            ivTodayBg.setVisibility(View.VISIBLE);
        } else {
            ivTodayBg.setVisibility(View.INVISIBLE);
        }

        if(hasTodo) {
            ivTodoBg.setVisibility(View.VISIBLE);
        } else {
            ivTodoBg.setVisibility(View.INVISIBLE);
        }

        txtWeek.setText(eDayOfWeek.values()[dayOfWeek-1].toString());
        txtDay.setText(""+day);


        month   = (month.length() == 1) ? "0" + month   : month;
        day     = (day.length() == 1)   ? "0" + day     : day;

        ivFullDate_Hidden.setText(year+month+day);

        return dayView;
    }

    Button.OnClickListener calendar_click_listener = new View.OnClickListener() {
        public void onClick(View v) {

            TextView ivFullDate_Hidden = (TextView)v.findViewById(R.id.txt_cal_fulldate_hidden);

            Toast.makeText(getActivity(), ivFullDate_Hidden.getText(), Toast.LENGTH_SHORT).show();
        }
    };

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
                case R.id.btn_cal_prev:
                    Log.d("INCL_DEBUG", "Calendar Scroll prev");
                    break;
                case R.id.btn_cal_next:
                    Log.d("INCL_DEBUG", "Calendar Scroll next");
                    break;
            }
        }
    };

}
