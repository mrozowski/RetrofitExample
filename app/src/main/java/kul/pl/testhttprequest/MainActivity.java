package kul.pl.testhttprequest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import kul.pl.testhttprequest.dataAccess.APIListener;
import kul.pl.testhttprequest.dataAccess.LibraryAccess;
import kul.pl.testhttprequest.exception.ApiError;
import kul.pl.testhttprequest.model.LibraryBook;
import kul.pl.testhttprequest.utils.Direction;
import kul.pl.testhttprequest.utils.Sorting;

public class MainActivity extends AppCompatActivity implements APIListener {
    RecyclerView recyclerView;
    LibraryAccess api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_view);
        setRecyclerView();

        api = LibraryAccess.getInstance();
        api.setListener(this);
    }

    public void clickButton(View view){
        api.getBooks(10, -1, Sorting.TITLE);
    }

    public void clickButton2(View view){
        api.getBooks(10, 0, Sorting.RATING, Direction.DESC);
    }

    public void clickButton3(View view){
        api.getBookById(1);
    }

    @Override
    public void onBookListReceive(List<LibraryBook> books) {
        MyRecycleView adapter = new MyRecycleView(books, this);

        //adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onErrorReceive(ApiError error) {
        Toast.makeText(this, "Status: " + error.getStatus() + " \nMessage: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBookReceive(LibraryBook book) {
        Toast.makeText(this, "Status: " + book.getTitle() +
                "\nMessage: " + book.getAuthors() +
                "\nRating: " + book.getRating() +
                "\nPages: " + book.getPages(),
                Toast.LENGTH_LONG).show();
    }

    private void setRecyclerView() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}