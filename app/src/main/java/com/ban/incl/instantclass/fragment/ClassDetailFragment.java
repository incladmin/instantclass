package com.ban.incl.instantclass.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        //TODO : seesion
        map.put("user_id", "incladmin");

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
        TextView content    = (TextView)view.findViewById(R.id.txt_detail_content);
        TextView txt_regist_incl    = (TextView)view.findViewById(R.id.txt_regist_incl);

        ImageView iv_detail_interest = (ImageView)view.findViewById(R.id.iv_detail_interest);
        ImageView btn_incl_regist = (ImageView)view.findViewById(R.id.btn_incl_regist);
        RelativeLayout btn_incl_interest = (RelativeLayout)view.findViewById(R.id.btn_incl_interest);

        title.setText(mVo.getTitle());
        date.setText(mVo.getLesson_date());
        time.setText(mVo.getStart_time() + " ~ " + mVo.getEnd_time());
        place.setText(mVo.getPlace());
        person.setText(mVo.getMax_person());
        price.setText(mVo.getPrice());
        content.setText(mVo.getContent());

        if("Y".equals(mVo.getRegist_yn())) {
            btn_incl_regist.setTag("Y");
            btn_incl_regist.setImageResource(R.color.disabled);
            txt_regist_incl.setText("수업 취소");
        } else {
            btn_incl_regist.setTag("N");
            btn_incl_regist.setImageResource(R.drawable.button_red);
            txt_regist_incl.setText("수업 듣기");
        }

        if("Y".equals(mVo.getInterest_yn())) {
            btn_incl_interest.setTag("Y");
            iv_detail_interest.setImageResource(R.drawable.ic_list_interest);
        } else {
            btn_incl_interest.setTag("N");
            iv_detail_interest.setImageResource(R.drawable.ic_list_check);
        }


        btn_incl_regist.setOnClickListener(this);
        btn_incl_interest.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Map map = new HashMap();
        String strRetun = "";
        String sAction = "";
        switch (v.getId()) {
            case R.id.btn_incl_regist:
                ImageView btn_incl_regist = (ImageView)getView().findViewById(R.id.btn_incl_regist);
                TextView txt_regist_incl  = (TextView)getView().findViewById(R.id.txt_regist_incl);
                if("Y".equals(v.getTag())) {
                    sAction = "DELETE";
                    btn_incl_regist.setTag("N");
                    btn_incl_regist.setImageResource(R.drawable.button_red);
                    txt_regist_incl.setText("수업 듣기");
                } else {
                    sAction = "INSERT";
                    btn_incl_regist.setTag("Y");
                    btn_incl_regist.setImageResource(R.color.disabled);
                    txt_regist_incl.setText("수업 취소");
                }

                map = new HashMap();
                //TODO : session
                map.put("class_id", getArguments().getCharSequence("CLASS_ID"));
                map.put("user_id", "incladmin");
                map.put("action", sAction);
                strRetun = InclDBUtil.saveInclRegist(map);

                break;
            case R.id.btn_incl_interest:
                ImageView iv_detail_interest = (ImageView)getView().findViewById(R.id.iv_detail_interest);
                RelativeLayout btn_incl_interest = (RelativeLayout)getView().findViewById(R.id.btn_incl_interest);
                if("Y".equals(v.getTag())) {
                    sAction = "DELETE";
                    btn_incl_interest.setTag("N");
                    iv_detail_interest.setImageResource(R.drawable.ic_list_check);
                } else {
                    sAction = "INSERT";
                    btn_incl_interest.setTag("Y");
                    iv_detail_interest.setImageResource(R.drawable.ic_list_interest);
                }

                map = new HashMap();
                //TODO : session
                map.put("class_id", getArguments().getCharSequence("CLASS_ID"));
                map.put("user_id", "incladmin");
                map.put("action", sAction);
                strRetun = InclDBUtil.saveInclInterest(map);

                break;
        }
    }
}
