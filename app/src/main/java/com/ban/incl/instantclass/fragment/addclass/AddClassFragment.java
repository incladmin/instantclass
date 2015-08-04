package com.ban.incl.instantclass.fragment.addclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.vo.ClassVO;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddClassFragment extends Fragment {


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

        view.findViewById(R.id.btn_add_class).setOnClickListener(addClassListener);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    Button.OnClickListener addClassListener = new View.OnClickListener(){
        public void  onClick(View v){
            FragmentManager addClassFragementManager  = getActivity().getSupportFragmentManager();
            switch (v.getId()){
                case R.id.btn_add_class:
                    Log.d("add class!!!!!!!!!!", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
                    List addClassList = new ArrayList()
                            ;
                    EditText title      = (EditText)getView().findViewById(R.id.edtTitle);
                    EditText date       = (EditText)getView().findViewById(R.id.edtLessonDate);
                    EditText startTime  = (EditText)getView().findViewById(R.id.edtStartTime);
                    EditText endTime    = (EditText)getView().findViewById(R.id.edtEndTime);
                    EditText place      = (EditText)getView().findViewById(R.id.edtPlace);
                    EditText maxPerson = (EditText)getView().findViewById(R.id.edtMaxPerson);
                    EditText minPerson = (EditText)getView().findViewById(R.id.edtMinPerson);
;
                    addClassList.add(0, title.getText().toString());
                    addClassList.add(1, date.getText().toString());
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

}
