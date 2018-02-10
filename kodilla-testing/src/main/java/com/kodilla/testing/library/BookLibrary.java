package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookListWithCondition = new ArrayList<>();
        if (titleFragment.length() < 3) return bookListWithCondition;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookListWithCondition;
        bookListWithCondition = resultList;
        return bookListWithCondition;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> booksInHandsOfUser = libraryDatabase.listBooksInHandsOf(libraryUser);
        return booksInHandsOfUser;
    }

    public boolean rentABook(LibraryUser libraryUser, Book book) {
        return true;
    }

    public int returnBooks(LibraryUser libraryUser) {
        return 10;
    }
}
