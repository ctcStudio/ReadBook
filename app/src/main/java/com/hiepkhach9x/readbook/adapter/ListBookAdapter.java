package com.hiepkhach9x.readbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hiepkhach9x.readbook.R;

/**
 * Created by HungHN on 1/25/2016.
 */
public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.bookHolder> {


    public ListBookAdapter() {

    }

    @Override
    public bookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(bookHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class bookHolder extends RecyclerView.ViewHolder {
        private final TextView BookTitle, SpeedRead;
        private final RelativeLayout ItemContent;

        bookHolder(View v) {
            super(v);
            ItemContent = (RelativeLayout) v.findViewById(R.id.item_book_content);
            BookTitle = (TextView) v.findViewById(R.id.item_book_title);
            SpeedRead = (TextView) v.findViewById(R.id.item_book_speed_read);
        }
    }
}
