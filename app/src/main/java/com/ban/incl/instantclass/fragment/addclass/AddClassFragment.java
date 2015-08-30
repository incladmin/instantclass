package com.ban.incl.instantclass.fragment.addclass;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.ban.incl.instantclass.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddClassFragment extends Fragment {
    Calendar dateAndTime = Calendar.getInstance();
    DateFormat fmDateAndTime = DateFormat.getDateTimeInstance();
    TextView dateLabel;
    TextView timeLabel;

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            int dayOfWeek=0;
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            dateAndTime.set(Calendar.DAY_OF_WEEK, dayOfWeek);
//            Calendar.DAY_OF_WEEK;

            updateDateLabel(year, monthOfYear, dayOfMonth);
        }
    };

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute){
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);

            updateTimeLabel(hourOfDay, minute);
        }

    };

    public static AddClassFragment newInstance() {
        AddClassFragment fragment = new AddClassFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public AddClassFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_class, container, false);

        view.findViewById(R.id.btn_lessonDate).setOnClickListener(addClassListener);
        view.findViewById(R.id.btn_add_class).setOnClickListener(addClassListener);
        view.findViewById(R.id.btn_start_time).setOnClickListener(addClassListener);
        view.findViewById(R.id.btn_end_time).setOnClickListener(addClassListener);


        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Button.OnClickListener addClassListener = new View.OnClickListener(){
        public void  onClick(View v){
            FragmentManager addClassFragementManager  = getActivity().getSupportFragmentManager();
            switch (v.getId()) {
                case R.id.btn_lessonDate:
                    new DatePickerDialog(getActivity(), date,
                            dateAndTime.get(Calendar.YEAR),
                            dateAndTime.get(Calendar.MONTH),
                            dateAndTime.get(Calendar.DAY_OF_MONTH)).show();

                    dateLabel = (TextView) v.findViewById(R.id.btn_lessonDate);
                    //updateDateLabel();

                    break;

                case R.id.btn_start_time:
                    new TimePickerDialog(getActivity(), time,
                            dateAndTime.get(Calendar.HOUR_OF_DAY),
                            dateAndTime.get(Calendar.MINUTE), true).show();

                    timeLabel = (TextView) v.findViewById(R.id.btn_start_time);
                    //updateDateLabel();

                    break;

                case R.id.btn_end_time:
                    new TimePickerDialog(getActivity(), time,
                            dateAndTime.get(Calendar.HOUR_OF_DAY),
                            dateAndTime.get(Calendar.MINUTE), true).show();

                    timeLabel = (TextView) v.findViewById(R.id.btn_end_time);
                    //updateDateLabel();

                    break;


                case R.id.btn_add_class:
                    List addClassList = new ArrayList();
                    EditText title = (EditText) getView().findViewById(R.id.edtTitle);
                    Button lessonDate = (Button) getView().findViewById(R.id.btn_lessonDate);
                    Button startTime = (Button) getView().findViewById(R.id.btn_start_time);
                    Button endTime = (Button) getView().findViewById(R.id.btn_end_time);
                    EditText place = (EditText) getView().findViewById(R.id.edtPlace);
                    EditText maxPerson = (EditText) getView().findViewById(R.id.edtMaxPerson);
                    EditText minPerson = (EditText) getView().findViewById(R.id.edtMinPerson);
                    ;
                    addClassList.add(0, title.getText().toString());
                    addClassList.add(1, lessonDate.getText().toString());
                    addClassList.add(2, startTime.getText().toString());
                    addClassList.add(3, endTime.getText().toString());
                    addClassList.add(4, place.getText().toString());
                    addClassList.add(5, maxPerson.getText().toString());
                    addClassList.add(6, minPerson.getText().toString());

//                    Log.d("add class!!!!!!!!!!", addClassList.get(0).toString());

                    addClassFragementManager.beginTransaction()
                            .replace(R.id.add_class_container, AddClassDetailFragment.newInstance(addClassList))
                            .addToBackStack(null)
                            .commit();

            }
        }


    };

    private void updateDateLabel(int year, int monthOfYear, int dayOfMonth){

       dateLabel.setText(year + " 년" + monthOfYear + " 월" + dayOfMonth + " 일" );
    }

    private void  updateTimeLabel(int hourOfDay, int minute){
        timeLabel.setText(hourOfDay+ " 시 " + minute +" 분" );
    }
}
