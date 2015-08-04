package com.ban.incl.instantclass.fragment.addclass;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.activity.MainActivity;
import com.ban.incl.instantclass.util.phpDown;
import com.ban.incl.instantclass.vo.ClassVO;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddClassDetailFragment extends Fragment {
    String title;
    String lessenDate;
    String startTime;
    String endTime;
    String place;
    String maxPerson;
    String minPerson;

    public AddClassDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            List addClassList = getArguments().getCharSequenceArrayList("addClassList");

            title = addClassList.get(0).toString();
            lessenDate = addClassList.get(1).toString();
            startTime = addClassList.get(2).toString();
            endTime =  addClassList.get(3).toString();
            place = addClassList.get(4).toString();
            maxPerson = addClassList.get(5).toString();
            minPerson = addClassList.get(6).toString();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_class_detail, container, false);

        view.findViewById(R.id.btn_add_class_dtl).setOnClickListener(addClassDtlListener);

        return view;
    }

    public static AddClassDetailFragment newInstance(List addClassList ) {
        AddClassDetailFragment fragment = new AddClassDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        args.putCharSequenceArrayList("addClassList", (ArrayList<CharSequence>) addClassList);
        return fragment;
    }

    Button.OnClickListener addClassDtlListener = new View.OnClickListener(){
        public void  onClick(View v){
            FragmentManager addClassDtlFragementManager  = getActivity().getSupportFragmentManager();
            switch (v.getId()){
                case R.id.btn_add_class_dtl:
                    ClassVO vo = new ClassVO();
                    EditText content    = (EditText)getView().findViewById(R.id.edtContent);
                    EditText items      = (EditText)getView().findViewById(R.id.edtItems);
//                    EditText maxPerson = (EditText)getView().findViewById(R.id.edtPhoto);
                    EditText bank = (EditText)getView().findViewById(R.id.edtBank);
                    EditText account = (EditText)getView().findViewById(R.id.edtAccount);

//                    vo.setPlace(place.getText().toString());
                    vo.setTitle(title);
                    vo.setDate(lessenDate);
                    vo.setStartTime(startTime);
                    vo.setEndTime(endTime);
                    vo.setPlace(place);
                    vo.setMaxPerson(maxPerson);
                    vo.setMinPerson(minPerson);

                    vo.setContent(content.getText().toString());
                    vo.setItems(items.getText().toString());
                    vo.setBank(bank.getText().toString());
                    vo.setAccount(account.getText().toString());

                    phpDown task = new phpDown();

                    try {
                        task.setMode("INSERT");
                        task.setInsertItem(vo);

                        task.execute("insertClass.php");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(getActivity(), "Insert", Toast.LENGTH_SHORT).show();
                    Intent mainIntend = new Intent(getActivity(), MainActivity.class);
                    startActivity(mainIntend);
                    break;
            }
        }
    };


}
