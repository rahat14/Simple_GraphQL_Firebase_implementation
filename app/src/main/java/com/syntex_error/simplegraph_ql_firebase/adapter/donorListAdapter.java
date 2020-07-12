package com.syntex_error.simplegraph_ql_firebase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplegraph_ql_firebase.AllDonorsQuery;
import com.syntex_error.simplegraph_ql_firebase.R;

import java.util.ArrayList;
import java.util.List;

public  class donorListAdapter  extends RecyclerView.Adapter<donorListAdapter.BookSearchResultHolder> {
    private List<AllDonorsQuery.Donor> results = new ArrayList<>();

    @NonNull
    @Override
    public BookSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_for_donor, parent, false);

        return new BookSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSearchResultHolder holder, int position) {
        AllDonorsQuery.Donor singleDonor = results.get(position);

        holder.titleTextView.setText(singleDonor.namee());
        holder.publishedDateTextView.setText(singleDonor.ph());

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<AllDonorsQuery.Donor> results) {
        this.results = results;
        notifyDataSetChanged();
    }


    class BookSearchResultHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView authorsTextView;
        private TextView publishedDateTextView;
        private ImageView smallThumbnailImageView;

        public BookSearchResultHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.book_item_title);
            authorsTextView = itemView.findViewById(R.id.book_item_authors);
            publishedDateTextView = itemView.findViewById(R.id.book_item_publishedDate);
            smallThumbnailImageView = itemView.findViewById(R.id.book_item_smallThumbnail);
        }
    }
}

