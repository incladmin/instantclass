package com.ban.incl.instantclass.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.vo.ClassVO;

import java.util.List;

/**
 * Created by sc.ban on 2015.06.28
 */
public class InclRecyclerAdapter extends RecyclerView.Adapter<InclRecyclerAdapter.MyViewHolder>  {

    private List<ClassVO> listClass;

    OnItemClickListener mItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt_card_title;
        TextView txt_card_date;
        TextView txt_card_place;
        TextView txt_card_time;
        TextView txt_card_people;
        TextView txt_card_price;
        TextView txt_card_writer;
        TextView txt_card_addr;

//        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
//            this.txt_card_title = (TextView) itemView.findViewById(R.id.txt_card_title);
            this.txt_card_date      = (TextView) itemView.findViewById(R.id.txt_card_date);
            this.txt_card_place     = (TextView) itemView.findViewById(R.id.txt_card_place);
            this.txt_card_time      = (TextView) itemView.findViewById(R.id.txt_card_time);
            this.txt_card_people    = (TextView) itemView.findViewById(R.id.txt_title);
            this.txt_card_price     = (TextView) itemView.findViewById(R.id.txt_card_price);
            this.txt_card_writer    = (TextView) itemView.findViewById(R.id.txt_lesson_date);
            this.txt_card_addr      = (TextView) itemView.findViewById(R.id.txt_card_addr);

//            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.txtStartTime);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }

    public InclRecyclerAdapter(List<ClassVO> listClass) {
        this.listClass = listClass;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

//        TextView txt_card_title     = holder.txt_card_title;
        TextView txt_card_date      = holder.txt_card_date;
        TextView txt_card_place     = holder.txt_card_place;
        TextView txt_card_time      = holder.txt_card_time;
        TextView txt_card_people    = holder.txt_card_people;
        TextView txt_card_price     = holder.txt_card_price;
        TextView txt_card_writer    = holder.txt_card_writer;
        TextView txt_card_addr      = holder.txt_card_addr;

//        ImageView imageView = holder.imageViewIcon;

        txt_card_date.setText(  listClass.get(listPosition).getLesson_date());
        txt_card_place.setText( listClass.get(listPosition).getPlace());
        String time = listClass.get(listPosition).getStart_time() + "~" + listClass.get(listPosition).getEnd_time();
        txt_card_time.setText(time);
//        String people = listClass.get(listPosition).getCurr_people() + "/" + listClass.get(listPosition).getMax_people();
//        txt_card_people.setText(people);
        txt_card_price.setText( listClass.get(listPosition).getPrice());
//        txt_card_writer.setText(listClass.get(listPosition).get());
        txt_card_addr.setText(  listClass.get(listPosition).getAddr());

//        imageView.setImageResource(listClass.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return listClass.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}