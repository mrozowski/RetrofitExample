package kul.pl.testhttprequest.dataAccess;

import java.util.List;

import kul.pl.testhttprequest.exception.ApiError;
import kul.pl.testhttprequest.exception.ApiErrorParser;
import kul.pl.testhttprequest.model.LibraryBook;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

abstract class LibraryAPI {
    protected APIListener listener;

    public void setListener(APIListener listener) {
        this.listener = listener;
    }


    protected Callback<List<LibraryBook>> callbackForBooksList = new Callback<List<LibraryBook>>() {
        @Override
        public void onResponse(Call<List<LibraryBook>> call, Response<List<LibraryBook>> response) {
            if (response.isSuccessful()) {
                List<LibraryBook> books = response.body();
                listener.onBookListReceive(books);
            } else {
                ApiError apiError = ApiErrorParser.parseError(response);
                listener.onErrorReceive(apiError);
            }
        }

        @Override
        public void onFailure(Call<List<LibraryBook>> call, Throwable t) {
            System.out.println("nie dziala");
        }
    };
    protected Callback<LibraryBook> callbackForBook = new Callback<LibraryBook>() {
        @Override
        public void onResponse(Call<LibraryBook> call, Response<LibraryBook> response) {
            if (response.isSuccessful()) {
                LibraryBook book = response.body();
                listener.onBookReceive(book);
            } else {
                ApiError apiError = ApiErrorParser.parseError(response);
                listener.onErrorReceive(apiError);
            }
        }

        @Override
        public void onFailure(Call<LibraryBook> call, Throwable t) {

        }
    };
}
