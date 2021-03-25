package kul.pl.testhttprequest.dataAccess;

import java.util.List;

import kul.pl.testhttprequest.model.LibraryBook;
import kul.pl.testhttprequest.utils.Direction;
import kul.pl.testhttprequest.utils.Sorting;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HTTPMethods {

    @GET("api/library/books")
    Call<List<LibraryBook>> getBooks(@Query("limit") int limit,
                                     @Query("page") int page,
                                     @Query("sort") Sorting sort);

    @GET("api/library/books")
    Call<List<LibraryBook>> getBooks(@Query("limit") int limit,
                                     @Query("page") int page,
                                     @Query("sort") Sorting sort,
                                     @Query("order") Direction direction);

    @GET("api/library/books/id/{id}")
    Call<LibraryBook> getBookById(@Path("id") int bookId);

}
