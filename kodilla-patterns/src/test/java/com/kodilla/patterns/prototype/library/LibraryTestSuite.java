package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        final Library library = new Library("Libray 1");

        IntStream.iterate(1, n -> n + 1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("Simple title no " + n, "Simple author no " + n,
                        LocalDate.of(1950 + n, 5 + n, 10 + n))));

        //ShallowClone of library class
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowClone();
            shallowClonedLibrary.setName("Library 2 // shallowCloned //");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //DeepClone of Library class
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepClone();
            deepClonedLibrary.setName("Library 3 // deepCloned //");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(library.getName());
        library.getBooks().forEach(System.out::println);

        System.out.println(shallowClonedLibrary.getName());
        shallowClonedLibrary.getBooks().forEach(System.out::println);

        System.out.println(deepClonedLibrary.getName());
        deepClonedLibrary.getBooks().forEach(System.out::println);

        //When
        final Book newBook = new Book("newBook", "newBook", LocalDate.now());
        deepClonedLibrary.getBooks().clear();
        deepClonedLibrary.getBooks().add(newBook);
        shallowClonedLibrary.getBooks().add(newBook);

        final int libraryBooksNo = library.getBooks().size();
        final int shallowClonedLibraryBooksNo = shallowClonedLibrary.getBooks().size();
        final int deepClonedLibraryBooksNo = deepClonedLibrary.getBooks().size();

        //Then
        System.out.println("\n" + library.getName());
        library.getBooks().forEach(System.out::println);

        System.out.println(shallowClonedLibrary.getName());
        shallowClonedLibrary.getBooks().forEach(System.out::println);

        System.out.println(deepClonedLibrary.getName());
        deepClonedLibrary.getBooks().forEach(System.out::println);

        Assert.assertEquals(6, libraryBooksNo);
        Assert.assertEquals(6, shallowClonedLibraryBooksNo);
        Assert.assertEquals(1, deepClonedLibraryBooksNo);

    }
}
