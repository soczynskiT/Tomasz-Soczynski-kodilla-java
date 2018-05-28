package com.kodilla.patterns2.adapter.company.bookclasifier;

import com.kodilla.patterns2.adapter.company.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedian() {
        //Given
        final Set<Book> bookSet = new HashSet<>();
        bookSet.addAll(Arrays.asList(
                new Book("author1", "title1", 1986, "1"),
                new Book("author3", "title1", 1945, "3"),
                new Book("author1", "title1", 1922, "4"),
                new Book("author3", "title1", 1911, "5"),
                new Book("author2", "title1", 1750, "6"),
                new Book("author5", "title1", 1999, "7"),
                new Book("author2", "title1", 1941, "8")));
        final MedianAdapter medianAdapter = new MedianAdapter();
        //When
        final int result = medianAdapter.publicationYearMedian(bookSet);
        System.out.println(result);
        //Then
        assertEquals(1941, result);
    }
}