package com.ban.incl.instantclass.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.adapter.SingleAdapter;
import com.ban.incl.instantclass.vo.ClassVO;

public class SingleListFragment extends Fragment implements AdapterView.OnItemClickListener {

    public SingleListFragment() {

    }

    public static SingleListFragment newInstance() {
        SingleListFragment fragment = new SingleListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_list, container, false);

//        ListView list = (ListView)view.findViewById(R.id.singleList);
//
//        SingleAdapter adapter = new SingleAdapter(view.getContext());
//        list.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView list = (ListView)getView().findViewById(R.id.singleList);

        SingleAdapter adapter = new SingleAdapter(getView().getContext());
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ClassVO vo = (ClassVO)view.getTag();

        Toast.makeText(getActivity(), vo.getTitle() + ":: " + position, Toast.LENGTH_SHORT).show();


        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, ClassDetailFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
