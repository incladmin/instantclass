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

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddClassDetailFragment extends Fragment {

    public static AddClassDetailFragment newInstance() {
        AddClassDetailFragment fragment = new AddClassDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public AddClassDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_class_detail, container, false);

        view.findViewById(R.id.btn_add_class_dtl).setOnClickListener(addClassDtlListener);

        return view;
    }

    Button.OnClickListener addClassDtlListener = new View.OnClickListener(){
        public void  onClick(View v){
            FragmentManager addClassDtlFragementManager  = getActivity().getSupportFragmentManager();
            switch (v.getId()){
                case R.id.btn_add_class_dtl:
                    Log.d("add class dtl!!!!!!!!!!", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
                    Intent mainIntend = new Intent(getActivity(), MainActivity.class);
                    startActivity(mainIntend);
//                    addClassDtlFragementManager.beginTransaction()
//                            .replace(R.id.container, SingleListFragment.newInstance())
//                            .addToBackStack(null)
//                            .commit();
//                    Intent addClassIntent = new Intent(getActivity(), AddClassActivity.class);
//                    startActivity(addClassIntent);

            }
        }
    };


}
