package com.myworkspace.java.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        String[] stringArray = new String[]{"NewYork","Atlanta", "NewZealand","Chicago","Denver", "Colorado", "LosAngeles", "Nainital"};

        List<String> stringList = Arrays.asList(stringArray);
        Collections.sort(stringList);
        binarySearchStrings(stringList);

     /*   Integer[] integerArray = new Integer[]{102, 103, 109, 110, 120, 178, 890};
        //binarySearchStrings(stringArray);
        binarySearchIntegers(integerArray, 103);*/


    }

    private static void binarySearchIntegers(Integer[] integerArray, int integerToFind) {
        int low = 0;
        int high = integerArray.length - 1;
        int mid = 0;

        if (integerArray[mid] == integerToFind) {
            System.out.println("Hurrah i found the Integer and the integer is ::" + integerToFind);
        } else {
            while (low <= high) {
                System.out.println("low::" + low + "and high::" + high);
                mid = (low + high) / 2;
                System.out.println("mid::" + mid);
                if (integerArray[mid] == integerToFind) {
                    System.out.println("Hurrah i found the Integer and the integer is ::" + integerToFind);
                    return;
                }
                if (integerArray[mid].compareTo(integerToFind) > 0) {
                    low = mid + 1;
                } else {
                    low = mid - 1;
                }
            }
        }
    }


    private static void binarySearchStrings(List<String> listOfStrings) {
        int low = 0;
        int high = listOfStrings.size();
        int mid = 0;

        String toFind = "Nainital";
        System.out.println("Sorted Strings:" + listOfStrings.toString());

        while (low < listOfStrings.size()) {
            if ( ! listOfStrings.contains(toFind)){
                return;
            }
            System.out.println("low::" + low + "::mid:" + mid + "and high::" + high);
            mid = (low + high) / 2;
            System.out.println("Mid now !!" + mid);
            if (listOfStrings.get(mid).equals(toFind)) {
                System.out.println("String found and value is::" + listOfStrings.get(mid));
                return;
            }
            if (toFind.compareTo(listOfStrings.get(mid)) > 0) {
                System.out.println("toFind.compareTo(stringArray[mid]): > mid::" + listOfStrings.get(mid));
                low = mid + 1;
            } else {
                System.out.println("toFind.compareTo(stringArray[mid]): < mid::" + listOfStrings.get(mid));
                high = mid - 1;
            }

        }
    }
}

