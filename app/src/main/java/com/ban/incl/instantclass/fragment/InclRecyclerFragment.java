package com.ban.incl.instantclass.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.adapter.InclRecyclerAdapter;
import com.ban.incl.instantclass.util.InclDBUtil;
import com.ban.incl.instantclass.vo.ClassVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InclRecyclerFragment extends Fragment {

    private List<ClassVO> list = new ArrayList<ClassVO>();

    public InclRecyclerFragment() {
        // Required empty public constructor
    }

    public static InclRecyclerFragment newInstance() {
        InclRecyclerFragment fragment = new InclRecyclerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mLayoutManager);

        list = InclDBUtil.selectAllList();

        InclRecyclerAdapter adapter = new InclRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void phpFinish(String str) {
        ClassVO vo;
        try{
            JSONObject root = new JSONObject(str);
            JSONArray ja = root.getJSONArray("results");

            for(int i=0; i<ja.length(); i++){
                JSONObject jo = ja.getJSONObject(i);

                vo = new ClassVO();
                vo.setClassId(jo.getString("class_id"));
                vo.setTitle(jo.getString("title"));
                vo.setContent(jo.getString("content"));
                vo.setDate(jo.getString("date"));
                vo.setStartTime(jo.getString("start_time"));
                vo.setEndTime(jo.getString("end_time"));
                vo.setAddr(jo.getString("addr"));
                vo.setPrice(jo.getString("price"));

                list.add(vo);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
    }

}
