package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer> evenNumbersList = new ArrayList<>();
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
