package org.example;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> dateStrings = Arrays.asList(
                "2005-07-01", "2005-01-02", "2005-01-01", "2005-05-03"
        );
        Comparators.compareDate(dateStrings);
    }
}