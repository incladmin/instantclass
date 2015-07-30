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
public class CertificationFragment extends Fragment {

    public static CertificationFragment newInstance() {
        CertificationFragment fragment = new CertificationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public CertificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_certification, container, false);

        view.findViewById(R.id.btn_certify).setOnClickListener(certifyListener);

        return view;
    }

    Button.OnClickListener certifyListener = new View.OnClickListener(){
        public void  onClick(View v){
            FragmentManager certifyFragementManager  = getActivity().getSupportFragmentManager();
            switch (v.getId()){
                case R.id.btn_certify:
                    Log.d("certiyfy!!!!!!!!!!", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
                    certifyFragementManager.beginTransaction()
                            .replace(R.id.add_class_container, AddClassFragment.newInstance())
                            .addToBackStack(null)
                            .commit();

            }
        }
    };


    /*

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agreement, container, false);

        view.findViewById(R.id.btn_agree).setOnClickListener(agreeListener);

        return view;
    }

    Button.OnClickListener agreeListener = new View.OnClickListener(){
        public void  onClick(View v){
            FragmentManager agreeFragementManager  = getActivity().getSupportFragmentManager();
            Log.d("agreeeeeaaaaaaaaaaEEEEE", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
            switch (v.getId()){
                case R.id.btn_agree:
                    Log.d("agreeeeeEEEEE", ">>>>>>>>>>>>>>>>>>>>>>>>>>>..");
                    agreeFragementManager.beginTransaction()
                            .replace(R.id.add_class_container, CertificationFragment.newInstance())
                            .addToBackStack(null)
                            .commit();

            }
        }
    };


     */

}
