package com.ban.incl.instantclass.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.util.phpDown;
import com.ban.incl.instantclass.vo.ClassVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClassDetailFragment extends Fragment implements View.OnClickListener {

    public static ClassDetailFragment newInstance() {
        ClassDetailFragment fragment = new ClassDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ClassDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_class_detail, container, false);

        phpDown task = new phpDown();

        try {
            ClassVO vo = new ClassVO();
            vo.setClassId(2);

            task.setMode("DETAIL");
            task.setInsertItem(vo);

            String sVo = task.execute("getDataDetail.php").get();

            try{
                JSONObject root = new JSONObject(sVo);
                JSONArray ja = root.getJSONArray("results");
                JSONObject jo = ja.getJSONObject(0);

                EditText title      = (EditText)view.findViewById(R.id.edtUpTitle);
                EditText date       = (EditText)view.findViewById(R.id.edtUpDate);
                EditText startTime  = (EditText)view.findViewById(R.id.edtUpStartTime);
                EditText endTime    = (EditText)view.findViewById(R.id.edtUpEndTime);
                EditText content    = (EditText)view.findViewById(R.id.edtUpContent);
                EditText place      = (EditText)view.findViewById(R.id.edtUpPlace);

                Log.d("inclTest", "GetDetail >> title : " + title.getText());

                title.setText(jo.getString("title"));
                date.setText(jo.getString("date"));
                startTime.setText(jo.getString("startTime"));
                endTime.setText(jo.getString("endTime"));
                content.setText(jo.getString("content"));
                place.setText(jo.getString("place"));

            }catch(JSONException e){
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


//        Button btnAddClass = (Button)view.findViewById(R.id.btn_update_class);
//        Button btnDeleteAll = (Button)view.findViewById(R.id.btn_del_class);
//
//        btnAddClass.setOnClickListener(this);
//        btnDeleteAll.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update_class:
                ClassVO vo = new ClassVO();

//                EditText title      = (EditText)getView().findViewById(R.id.edtUpTitle);
                EditText date       = (EditText)getView().findViewById(R.id.edtUpDate);
                EditText startTime  = (EditText)getView().findViewById(R.id.edtUpStartTime);
                EditText endTime    = (EditText)getView().findViewById(R.id.edtUpEndTime);
                EditText content   = (EditText)getView().findViewById(R.id.edtUpContent);
                EditText place      = (EditText)getView().findViewById(R.id.edtUpPlace);

//                vo.setTitle(title.getText().toString());
                vo.setDate(date.getText().toString());
                vo.setStartTime(startTime.getText().toString());
                vo.setEndTime(endTime.getText().toString());
                vo.setContent(content.getText().toString());
                vo.setPlace(place.getText().toString());

                phpDown task = new phpDown();



                Toast.makeText(getActivity(), "Update", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_del_class:
                break;
        }
    }
}
