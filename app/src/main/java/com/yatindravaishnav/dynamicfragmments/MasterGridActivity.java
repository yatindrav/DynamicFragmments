package com.yatindravaishnav.dynamicfragmments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by Yatindra Vaishnav on 8/10/2016.
 */
public class MasterGridActivity extends Fragment {

    Boolean isDualPane;
    GridView gridView;
    ListView listView;
    int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gridview, container, false);

        gridView = (GridView) view.findViewById(R.id.gridViewImage);
        gridView.setAdapter(new MyAdapter(view.getContext()));

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        View detailFrame = getActivity().findViewById(R.id.detail);

        isDualPane = detailFrame != null && detailFrame.getVisibility() == View.VISIBLE;

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
                if (!isDualPane) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), DetailActivity.class);
                    intent.putExtra("position", pos);
                    startActivity(intent);
                } else {
                    DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail);

                    if (detailFragment == null || detailFragment.getIndex() != pos) {

                        detailFragment = new DetailFragment(pos);
                        FragmentTransaction ft = getFragmentManager().beginTransaction();

                        ft.replace(R.id.detail, detailFragment);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                    }
                }
            }
        });

        super.onActivityCreated(savedInstanceState);
    }
}