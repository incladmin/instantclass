package com.ban.incl.instantclass.fragment.addclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ban.incl.instantclass.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddClassFragment extends Fragment {


    public static AddClassFragment newInstance() {
        AddClassFragment fragment = new AddClassFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public AddClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_class, container, false);

        view.findViewById(R.id.btn_add_class).setOnClickListener(addClassListener);

        return view;
    }

    Button.OnClickListener addClassListener = new View.OnClickListener(){
        public void  onClick(View v){
            FragmentManager addClassFragementManager  = getActivity().getSupportFragmentManager();
            switch (v.getId()){
                case R.id.btn_add_class:
                    Log.d("add class!!!!!!!!!!", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
                    addClassFragementManager.beginTransaction()
                            .replace(R.id.add_class_container, AddClassDetailFragment.newInstance())
                            .addToBackStack(null)
                            .commit();

            }
        }
    };

}
