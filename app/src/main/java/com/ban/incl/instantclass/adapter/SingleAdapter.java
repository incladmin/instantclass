package com.ban.incl.instantclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

        view.setTag(list.get(position).getClass_id());

        TextView txt_list_title     = (TextView) view.findViewById(R.id.txt_list_title);
        TextView txt_list_date      = (TextView) view.findViewById(R.id.txt_list_date);
        TextView txt_list_place     = (TextView) view.findViewById(R.id.txt_list_place);
        TextView txt_list_time      = (TextView) view.findViewById(R.id.txt_list_time);
        TextView txt_list_people    = (TextView) view.findViewById(R.id.txt_list_people);
        TextView txt_list_writer    = (TextView) view.findViewById(R.id.txt_list_writer);
        TextView txt_list_addr      = (TextView) view.findViewById(R.id.txt_list_addr);
        TextView txt_list_price      = (TextView) view.findViewById(R.id.txt_list_price);

        txt_list_title.setText(list.get(position).getTitle());
        txt_list_date.setText(list.get(position).getLesson_date());
        txt_list_place.setText(list.get(position).getPlace());
        String time = list.get(position).getStart_time()+"~"+list.get(position).getEnd_time();
        txt_list_time.setText(time);
//        String people = list.get(position).getCurr_people()+"/"+list.get(position).getMax_people();
//        txt_list_people.setText(people);
//        txt_list_people.setText(list.get(position).g());
//        txt_list_writer.setText(list.get(position).getw());
        txt_list_addr.setText(list.get(position).getAddr());
        txt_list_price.setText(list.get(position).getPrice());


        return view;
    }

}
