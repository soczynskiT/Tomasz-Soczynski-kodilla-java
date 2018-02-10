package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n, true);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, true);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016, true);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010, true);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);
        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        // Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfUserWithNullListOfBooks() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("First", "Last", "55120145784");
        List<Book> resultListBooksInHandsOfUser = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListBooksInHandsOfUser);
        //When
        List<Book> theListBooksInHandsOfUSer = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertTrue(theListBooksInHandsOfUSer.isEmpty());
    }

    @Test
    public void testListBooksInHandsOfUserWithOneBookInLIst() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("First", "Last", "55120145784");
        List<Book> resultListOneBookInHandsOfUser = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOneBookInHandsOfUser);
        //When
        List<Book> theListBooksInHandsOfUSer = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(1, theListBooksInHandsOfUSer.size());
    }

    @Test
    public void testListBooksInHandsOfUserWithMoreThanOneBookInLIst() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("First", "Last", "55120145784");
        List<Book> resultListFiveBooksInHandsOfUser = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListFiveBooksInHandsOfUser);
        //When
        List<Book> theListBooksInHandsOfUSer = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(5, theListBooksInHandsOfUSer.size());
    }

    @Test
    public void testRentABookNotExistingInLibrary() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        Book book = new Book("Not existing title", "Not existing author", 1, true);
        LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, true);
        List<Book> resultListOfBooks = new ArrayList<>(Arrays.asList(book1, book2));
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        boolean resultRentABook = bookLibrary.rentABook(aLibraryUser, book);
        //Then
        Assert.assertFalse(resultRentABook);
        Assert.assertFalse(bookLibrary.listBooksWithCondition("Secret").contains(book));
    }

    @Test
    public void testRentABookExistingAndAvailable() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, true);
        Book book3 = new Book("Secrets of Java", "Ian Tenewitch", 2010, true);
        List<Book> resultListOfBooks = new ArrayList<>(Arrays.asList(book1, book2, book3));

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOfBooks);
        //When
        boolean resultRentABook = bookLibrary.rentABook(aLibraryUser, book1);
        //Then
        Assert.assertTrue(resultRentABook);
        Assert.assertFalse(book1.getIsAvailable());
    }

    @Test
    public void testRentABookExistingAndNotAvailable() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, false);
        Book book3 = new Book("Secrets of Java", "Ian Tenewitch", 2010, true);
        List<Book> resultListOfBooks = new ArrayList<>(Arrays.asList(book1, book2, book3));

        when(libraryDatabaseMock.listBooksWithCondition("Secrets")).thenReturn(resultListOfBooks);
        //When
        boolean resultRentABook = bookLibrary.rentABook(aLibraryUser, book2);
        //Then
        Assert.assertTrue(bookLibrary.listBooksWithCondition("Secrets").contains(book2));
        Assert.assertFalse(resultRentABook);
        Assert.assertFalse(book2.getIsAvailable());
    }

    @Test
    public void testReturnBooksForEmptyBooksList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        List<Book> resultListOfBooksInHandsOfUser = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(aLibraryUser)).thenReturn(resultListOfBooksInHandsOfUser);
        //When
        int resultReturnBooks = bookLibrary.returnBooks(aLibraryUser);
        //Then
        Assert.assertEquals(0, resultReturnBooks);
    }

    @Test
    public void testReturnBooksFor5BooksList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        List<Book> resultListOfBooksInHandsOfUser = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(aLibraryUser)).thenReturn(resultListOfBooksInHandsOfUser);
        //When
        int resultReturnBooks = bookLibrary.returnBooks(aLibraryUser);
        //Then
        Assert.assertEquals(resultListOfBooksInHandsOfUser.size(), resultReturnBooks);
    }

    @Test
    public void testReturnBooksForMakingReturnedBooksAvailable() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        List<Book> resultListOfBooksInHandsOfUser = new ArrayList<>();
        Book book1 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, false);
        resultListOfBooksInHandsOfUser.add(book1);

        when(libraryDatabaseMock.listBooksInHandsOf(aLibraryUser)).thenReturn(resultListOfBooksInHandsOfUser);
        //When
        bookLibrary.returnBooks(aLibraryUser);
        //Then
        Assert.assertTrue(book1.getIsAvailable());
    }
}