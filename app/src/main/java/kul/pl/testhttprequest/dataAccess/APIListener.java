package kul.pl.testhttprequest.dataAccess;

import java.util.List;

import kul.pl.testhttprequest.model.LibraryBook;
import kul.pl.testhttprequest.exception.ApiError;

public interface APIListener {
     void onBookListReceive(List<LibraryBook> books);
     void onErrorReceive(ApiError error);
     void onBookReceive(LibraryBook book);
}
