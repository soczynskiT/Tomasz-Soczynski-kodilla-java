package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
        ArrayList<Integer> evenNumbersList = new ArrayList<>();
        if (!numbers.isEmpty()) {
         for (Integer anInt : numbers) {
             if (anInt % 2 == 0) {
                 evenNumbersList.add(anInt);
             }
         }
     }
     return evenNumbersList;
    }

}
