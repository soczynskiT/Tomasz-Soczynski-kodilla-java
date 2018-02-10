package com.kodilla.testing.library;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class BookDirectoryTestSuite {
    private static int testCounter = 1;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        final List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n, true);
            resultList.add(theBook);
        }
        return resultList;
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting tests...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("End of all tests...");
    }

    @Before
    public void before() {
        System.out.println("----------\nStart of test #" + testCounter);
    }

    @After
    public void after() {
        System.out.println("End of test #" + testCounter + "\n----------");
        testCounter++;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        final Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, true);
        final Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016, true);
        final Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010, true);
        final List<Book> resultListOfBooks = Arrays.asList(book1, book2, book3, book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);
        // When
        final List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        Assert.assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final List<Book> resultListOf0Books = new ArrayList<>();
        final List<Book> resultListOf15Books = generateListOfNBooks(15);
        final List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);
        // When
        final List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        final List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        final List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);
        // When
        final List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        // Then
        Assert.assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfUserWithNullListOfBooks() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser libraryUser = new LibraryUser("First", "Last", "55120145784");
        final List<Book> resultListBooksInHandsOfUser = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListBooksInHandsOfUser);
        //When
        final List<Book> theListBooksInHandsOfUSer = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(0, theListBooksInHandsOfUSer.size());
    }

    @Test
    public void testListBooksInHandsOfUserWithOneBookInLIst() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser libraryUser = new LibraryUser("First", "Last", "55120145784");
        final List<Book> resultListOneBookInHandsOfUser = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOneBookInHandsOfUser);
        //When
        final List<Book> theListBooksInHandsOfUSer = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(1, theListBooksInHandsOfUSer.size());
    }

    @Test
    public void testListBooksInHandsOfUserWithMoreThanOneBookInLIst() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser libraryUser = new LibraryUser("First", "Last", "55120145784");
        final List<Book> resultListFiveBooksInHandsOfUser = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListFiveBooksInHandsOfUser);
        //When
        final List<Book> theListBooksInHandsOfUSer = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        Assert.assertEquals(5, theListBooksInHandsOfUSer.size());
    }

    @Test
    public void testRentABookNotExistingInLibrary() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final Book book = new Book("Not existing title", "Not existing author", 1, true);
        final LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        final Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        final Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, true);
        final List<Book> resultListOfBooks = Arrays.asList(book1, book2);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        final boolean resultRentABook = bookLibrary.rentABook(aLibraryUser, book);
        //Then
        Assert.assertFalse(resultRentABook);
        Assert.assertFalse(bookLibrary.listBooksWithCondition("Secret").contains(book));
    }

    @Test
    public void testRentABookExistingAndAvailable() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        final Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        final Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, true);
        final Book book3 = new Book("Secrets of Java", "Ian Tenewitch", 2010, true);
        final List<Book> resultListOfBooks = Arrays.asList(book1, book2, book3);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOfBooks);
        //When
        final boolean resultRentABook = bookLibrary.rentABook(aLibraryUser, book1);
        //Then
        Assert.assertTrue(resultRentABook);
        Assert.assertFalse(book1.getIsAvailable());
    }

    @Test
    public void testRentABookExistingAndNotAvailable() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        final Book book1 = new Book("Secrets of Alamo", "John Smith", 2008, true);
        final Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, false);
        final Book book3 = new Book("Secrets of Java", "Ian Tenewitch", 2010, true);
        final List<Book> resultListOfBooks = Arrays.asList(book1, book2, book3);
        when(libraryDatabaseMock.listBooksWithCondition("Secrets")).thenReturn(resultListOfBooks);
        //When
        final boolean resultRentABook = bookLibrary.rentABook(aLibraryUser, book2);
        //Then
        Assert.assertTrue(bookLibrary.listBooksWithCondition("Secrets").contains(book2));
        Assert.assertFalse(resultRentABook);
        Assert.assertFalse(book2.getIsAvailable());
    }

    @Test
    public void testReturnBooksForEmptyBooksList() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        final List<Book> resultListOfBooksInHandsOfUser = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(aLibraryUser)).thenReturn(resultListOfBooksInHandsOfUser);
        //When
        final int resultReturnBooks = bookLibrary.returnBooks(aLibraryUser);
        //Then
        Assert.assertEquals(0, resultReturnBooks);
    }

    @Test
    public void testReturnBooksFor5BooksList() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        final List<Book> resultListOfBooksInHandsOfUser = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(aLibraryUser)).thenReturn(resultListOfBooksInHandsOfUser);
        //When
        final int resultReturnBooks = bookLibrary.returnBooks(aLibraryUser);
        //Then
        Assert.assertEquals(resultListOfBooksInHandsOfUser.size(), resultReturnBooks);
    }

    @Test
    public void testReturnBooksForMakingReturnedBooksAvailable() {
        //Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser aLibraryUser = new LibraryUser("First", "Last", "PESEL");
        final Book book1 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012, false);
        final List<Book> resultListOfBooksInHandsOfUser = Arrays.asList(book1);
        when(libraryDatabaseMock.listBooksInHandsOf(aLibraryUser)).thenReturn(resultListOfBooksInHandsOfUser);
        //When
        bookLibrary.returnBooks(aLibraryUser);
        //Then
        Assert.assertTrue(book1.getIsAvailable());
    }
}