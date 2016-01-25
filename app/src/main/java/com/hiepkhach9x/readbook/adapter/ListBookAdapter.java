package com.hiepkhach9x.readbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hiepkhach9x.readbook.R;
import com.hiepkhach9x.readbook.entities.EBook;

import java.util.ArrayList;

/**
 * Created by HungHN on 1/25/2016.
 */
public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.BookHolder> {

    private Context mContext;
    private ArrayList<EBook> lstBook;

    public ListBookAdapter(Context context, ArrayList<EBook> eBooks) {
        this.mContext = context;
        this.lstBook = eBooks;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        EBook book = lstBook.get(position);
        fillView(holder, book);

    }

    private void fillView(final BookHolder holder, final EBook eBook) {
        holder.BookTitle.setText(eBook.getTitle());
        holder.SpeedRead.setText(eBook.getReadPosition() / eBook.getNumberPage() + "%");
        holder.ItemContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "I want to read " + eBook.getTitle(), Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstBook.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder {
        private final TextView BookTitle, SpeedRead;
        private final RelativeLayout ItemContent;

        BookHolder(View v) {
            super(v);
            ItemContent = (RelativeLayout) v.findViewById(R.id.item_book_content);
            BookTitle = (TextView) v.findViewById(R.id.item_book_title);
            SpeedRead = (TextView) v.findViewById(R.id.item_book_speed_read);
        }
    }
}
