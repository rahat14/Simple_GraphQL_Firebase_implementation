package com.syntex_error.simplegraph_ql_firebase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.syntex_error.simplegraph_ql_firebase.R;
import com.syntex_error.simplegraph_ql_firebase.models.donorModel;

import java.util.ArrayList;
import java.util.List;

public  class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DonorListViewHolder> {
private List<donorModel> results = new ArrayList<>();

@NonNull
@Override
public DonorListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_for_donor, parent, false);

        return new DonorListViewHolder(itemView);
        }

@Override
public void onBindViewHolder(@NonNull DonorListViewHolder holder, int position) {
        donorModel singleDonor = results.get(position);

        holder.titleTextView.setText(singleDonor.getNamee());
        holder.publishedDateTextView.setText(singleDonor.getPh());

        }

@Override
public int getItemCount() {
        return results.size();
        }

public void setResults(List<donorModel> results) {
        this.results = results;
        notifyDataSetChanged();
        }


class DonorListViewHolder extends RecyclerView.ViewHolder {
    private TextView titleTextView;
    private TextView authorsTextView;
    private TextView publishedDateTextView;
    private ImageView smallThumbnailImageView;

    public DonorListViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.book_item_title);
        authorsTextView = itemView.findViewById(R.id.book_item_authors);
        publishedDateTextView = itemView.findViewById(R.id.book_item_publishedDate);
        smallThumbnailImageView = itemView.findViewById(R.id.book_item_smallThumbnail);
    }
}
}