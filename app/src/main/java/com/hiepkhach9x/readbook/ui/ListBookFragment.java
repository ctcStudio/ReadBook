package com.hiepkhach9x.readbook.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hiepkhach9x.readbook.R;
import com.hiepkhach9x.readbook.adapter.ListBookAdapter;
import com.hiepkhach9x.readbook.entities.EBook;

import java.util.ArrayList;

/**
 * Created by HungHN on 1/25/2016.
 */
public class ListBookFragment extends BaseFragment {
    private static final int spanCount = 3;
    private RecyclerView recyclerView;
    private ListBookAdapter bookAdapter;
    private ArrayList<EBook> lstBook;


    public static ListBookFragment newInstanse(){
        ListBookFragment fragment = new ListBookFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_book,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view);
    }

    @Override
    public void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),spanCount);
        recyclerView.setLayoutManager(gridLayoutManager);
        if(lstBook == null){
            lstBook = new ArrayList<>();
        }
        bookAdapter = new ListBookAdapter(getActivity(),lstBook);
        recyclerView.setAdapter(bookAdapter);
    }
}
