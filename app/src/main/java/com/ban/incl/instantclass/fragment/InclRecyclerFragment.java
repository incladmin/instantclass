package com.ban.incl.instantclass.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.activity.AddClassActivity;
import com.ban.incl.instantclass.activity.DetailClassActivity;
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
    private RecyclerView recyclerView;
    private InclRecyclerAdapter adapter;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;

    public InclRecyclerFragment() {
        // Required empty public constructor
    }

    public static InclRecyclerFragment newInstance() {
        InclRecyclerFragment fragment = new InclRecyclerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        mStaggeredLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mStaggeredLayoutManager);

//        list = InclDBUtil.selectAllList();
//
//        adapter = new InclRecyclerAdapter(list);
//        recyclerView.setAdapter(adapter);
//
//        adapter.setOnItemClickListener(onItemClickListener);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = InclDBUtil.selectAllList();

        adapter = new InclRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(onItemClickListener);
    }

    InclRecyclerAdapter.OnItemClickListener onItemClickListener = new InclRecyclerAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Log.d("INCL_DEBUG", "onItemClick");

//            adapter.notifyItemRemoved(position);
            Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();

//            Intent intent = new Intent(getActivity(), DetailClassActivity.class);
//            startActivity(intent);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction()
                            .replace(R.id.container, ClassDetailFragment.newInstance())
                            .addToBackStack(null)
                            .commit();


        /*
            Intent transitionIntent = new Intent(getActivity(), AddClassActivity.class);

            View navigationBar = view.findViewById(android.R.id.navigationBarBackground);
            View statusBar = view.findViewById(android.R.id.statusBarBackground);

//            Pair<View, String> imagePair = Pair.create((View) placeImage, "tImage");
//            Pair<View, String> holderPair = Pair.create((View) placeNameHolder, "tNameHolder");
            Pair<View, String> navPair = Pair.create(navigationBar, Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME);
            Pair<View, String> statusPair = Pair.create(statusBar, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME);
//            Pair<View, String> toolbarPair = Pair.create((View)toolbar, "tActionBar");

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), navPair, statusPair);
            ActivityCompat.startActivity(getActivity(), transitionIntent, options.toBundle());
        */
        }
    };

}
