package com.kodilla.patterns2.adapter.company.bookclasifier;

import com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.company.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics statisticsProcessor = new Statistics();
        return statisticsProcessor.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        Statistics statisticsProcessor = new Statistics();
        return statisticsProcessor.medianPublicationYear(books);
    }
}
