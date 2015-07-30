package com.ban.incl.instantclass.fragment.addclass;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.fragment.SingleListFragment;

public class AgreementFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public static AgreementFragment newInstance() {
        AgreementFragment fragment = new AgreementFragment();
        Bundle args = new Bundle();
        //        args.putString(ARG_PARAM1, param1);
        //        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public AgreementFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

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


//    Button.OnClickListener mainListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//
//            switch (v.getId()) {
//                case R.id.btn_main_recommand:
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.container, SingleListFragment.newInstance())
//                            .addToBackStack(null)
//                            .commit();
//                    break;
//                case R.id.btn_main_region:
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.container, SingleListFragment.newInstance())
//                            .commit();
//                    break;
//                case R.id.btn_main_all:
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.container, SingleListFragment.newInstance())
//                            .commit();
//                    break;
//                case R.id.btn_cal_prev:
//                    Log.d("INCL_DEBUG", "Calendar Scroll prev");
//                    break;
//                case R.id.btn_cal_next:
//                    Log.d("INCL_DEBUG", "Calendar Scroll next");
//                    break;
//            }
//        }
//    };

}
