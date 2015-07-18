package com.ban.incl.instantclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.util.InclDBUtil;
import com.ban.incl.instantclass.vo.ClassVO;

import java.util.ArrayList;
import java.util.List;

public class SingleAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;

    List<ClassVO> list = new ArrayList<ClassVO>();

    String returnVal;

    //생성자를 만든다.
    public SingleAdapter(Context context) {

        list = InclDBUtil.selectAllList();

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() { return list.size(); }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view=null;
        if(convertView==null){
            view = inflater.inflate(R.layout.list_item, parent, false);
        }else{
            view = convertView;
        }

        return view;
    }
}
