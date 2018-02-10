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
        boolean resultRentABook = false;
        List<Book> searchResultList = listBooksWithCondition(book.getTitle());
        if (searchResultList.contains(book) && book.getIsAvailable()) {
            book.setAvailable(false);
            resultRentABook = true;
            /*Place for code that will add information to database about rented book by libraryUser.
            Another team is preparing database that implements interface with method listBookInHandsOf.
             */
        }
        return resultRentABook;
    }

    public int returnBooks(LibraryUser libraryUser) {
        int returnedBooksCounter = 0;
        List<Book> usersRentedBooksList = libraryDatabase.listBooksInHandsOf(libraryUser);
        if (!usersRentedBooksList.isEmpty()) {
            for (Book aBook : usersRentedBooksList) {
                aBook.setAvailable(true);
                returnedBooksCounter++;
            }
        }
        return returnedBooksCounter;
    }
}
