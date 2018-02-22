package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main (String args[]) {
        final FileReaderWithoutHandling fileReader2 = new FileReaderWithoutHandling();
        try {
            fileReader2.readFile();
        } catch (IOException a) {
            a.printStackTrace();
        }

        final FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException fe) {
            fe.printStackTrace();
        }

    }
}
