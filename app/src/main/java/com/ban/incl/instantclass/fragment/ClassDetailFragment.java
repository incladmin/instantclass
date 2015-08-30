package com.ban.incl.instantclass.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.util.InclDBUtil;
import com.ban.incl.instantclass.vo.ClassVO;

import java.util.HashMap;
import java.util.Map;

public class ClassDetailFragment extends Fragment implements View.OnClickListener {

    private ClassVO mVo = new ClassVO();

    public static ClassDetailFragment newInstance(CharSequence sClassId) {
        ClassDetailFragment fragment = new ClassDetailFragment();
        Bundle args = new Bundle();
        args.putCharSequence("CLASS_ID", sClassId);
        fragment.setArguments(args);
        return fragment;
    }

    public ClassDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CharSequence mClassId = getArguments().getCharSequence("CLASS_ID");

        Map map = new HashMap();
        map.put("class_id", mClassId);

        mVo = InclDBUtil.selectClassDetail(map);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_class_detail, container, false);

        TextView title      = (TextView)view.findViewById(R.id.txt_detail_title);
        TextView date       = (TextView)view.findViewById(R.id.txt_detail_lesson_date);
        TextView time       = (TextView)view.findViewById(R.id.txt_detail_lesson_time);
        TextView place      = (TextView)view.findViewById(R.id.txt_detail_place);
        TextView person     = (TextView)view.findViewById(R.id.txt_detail_max_person);
        TextView price      = (TextView)view.findViewById(R.id.txt_detail_price);
        TextView content      = (TextView)view.findViewById(R.id.txt_detail_content);

        title.setText(mVo.getTitle());
        date.setText(mVo.getLesson_date());
        time.setText(mVo.getStart_time() + " ~ " + mVo.getEnd_time());
        place.setText(mVo.getPlace());
        person.setText(mVo.getMax_person());
        price.setText(mVo.getPrice());
        content.setText(mVo.getContent());

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
//            case R.id.btn_update_class:
//                ClassVO vo = new ClassVO();
//
////                EditText title      = (EditText)getView().findViewById(R.id.edtUpTitle);
//                EditText date       = (EditText)getView().findViewById(R.id.edtUpDate);
//                EditText startTime  = (EditText)getView().findViewById(R.id.edtUpStartTime);
//                EditText endTime    = (EditText)getView().findViewById(R.id.edtUpEndTime);
//                EditText content   = (EditText)getView().findViewById(R.id.edtUpContent);
//                EditText place      = (EditText)getView().findViewById(R.id.edtUpPlace);
//
////                vo.setTitle(title.getText().toString());
//                vo.setDate(date.getText().toString());
//                vo.setStartTime(startTime.getText().toString());
//                vo.setEndTime(endTime.getText().toString());
//                vo.setContent(content.getText().toString());
//                vo.setPlace(place.getText().toString());
//
//                phpDown task = new phpDown();
//
//
//
//                Toast.makeText(getActivity(), "Update", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.btn_del_class:
//                break;
        }
    }
}
