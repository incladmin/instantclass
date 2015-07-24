package com.ban.incl.instantclass.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.util.InclDBUtil;
import com.ban.incl.instantclass.util.InclUtil;
import com.ban.incl.instantclass.vo.ClassVO;

import java.util.Map;


public class AddClassFragment extends Fragment implements View.OnClickListener {
    ///test scban
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static AddClassFragment newInstance() {
        AddClassFragment fragment = new AddClassFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AddClassFragment() {
        // Required empty public constructor
    }

    // 화면에서 화면으로 데이터 전송시
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    // Fragment의 시작
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_class, container, false);

        Button btnAddClass = (Button)view.findViewById(R.id.btn_add_class);

        btnAddClass.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_add_class:

                ClassVO vo = new ClassVO();
                //화면에서 사용할 데이터를 셋팅한다.
                EditText title      = (EditText)getView().findViewById(R.id.edtTitle);
//                EditText lessonDate       = (EditText)getView().findViewById(R.id.edtLessonDtPk);
                EditText startTime  = (EditText)getView().findViewById(R.id.edtStartTime);
                EditText endTime    = (EditText)getView().findViewById(R.id.edtEndTime);
                EditText content   = (EditText)getView().findViewById(R.id.edtContent);
                EditText place      = (EditText)getView().findViewById(R.id.edtPlace);
//                EditText items = (EditText)getView().findViewById(R.id.edtItems);
//                EditText minPeople = (EditText)getView().findViewById(R.id.edtMinPeople);
//                EditText maxPeople = (EditText)getView().findViewById(R.id.edtMaxPeople);
//                EditText account = (EditText)getView().findViewById(R.id.edtAccount);

                Log.d("insertClass", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
                Log.d("insertClass", title.getText().toString());
//                Log.d("insertClass", lessonDate.getText().toString());
                Log.d("insertClass", startTime.getText().toString());
                Log.d("insertClass", endTime.getText().toString());
                Log.d("insertClass", content.getText().toString());
                Log.d("insertClass", place.getText().toString());
//                Log.d("insertClass", items.getText().toString());
//                Log.d("insertClass", minPeople.getText().toString());
//                Log.d("insertClass", maxPeople.getText().toString());
//                Log.d("insertClass", account.getText().toString());

                vo.setTitle(title.getText().toString());
//                vo.setLessonDate(lessonDate.getText().toString());
                vo.setStartTime(startTime.getText().toString());
                vo.setEndTime(endTime.getText().toString());
                vo.setContent(content.getText().toString());
                vo.setPlace(place.getText().toString());
//                vo.setItems(items.getText().toString());
//                vo.setMinPeople(minPeople.getText().toString());
//                vo.setMaxPeople(maxPeople.getText().toString());
//                vo.setAccount(account.getText().toString());

                Map map = InclUtil.ConvertObjtoMap(vo);

                InclDBUtil.insertClass(map);

                Toast.makeText(getActivity(), "Insert", Toast.LENGTH_SHORT).show();

                //Data reset
                title.setText("");
//                lessonDate.setText("");
                startTime.setText("");
                endTime.setText("");
                content.setText("");
                place.setText("");
//                items.setText("");
//                minPeople.setText("");
//                maxPeople.setText("");
//                account.setText("");
                break;
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }

}
