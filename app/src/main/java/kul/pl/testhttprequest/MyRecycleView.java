package kul.pl.testhttprequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kul.pl.testhttprequest.model.LibraryBook;

public class MyRecycleView extends RecyclerView.Adapter<MyRecycleView.ViewHolder>{
    private List<LibraryBook> mData;
    private LayoutInflater mInflater;

    public MyRecycleView(List<LibraryBook> mData, Context context) {
        this.mData = mData;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = mData.get(position).getTitle();
        String author = mData.get(position).getAuthors();
        double rating = mData.get(position).getRating();

        holder.title.setText(title);
        holder.author.setText(author);
        holder.rating.setText(String.valueOf(rating));
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, author, rating;
        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            rating = itemView.findViewById(R.id.rating);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
           //...
        }
    }
}
