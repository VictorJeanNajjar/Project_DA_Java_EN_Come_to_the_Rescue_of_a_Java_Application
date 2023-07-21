package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        /**
         * Create an instance of AnalyticsCounter with input and output file names.
         * Also, call the symptomorganiser method to organize symptoms and get the TreeMap.
         *
         */
        TreeMap <String, Integer> treeMapSymptoms = new AnalyticsCounter("symptoms.txt", "result.out").symptomOrganiser();
        try {
            // Call the filewriter method to write the TreeMap to the "results.out" file
            new AnalyticsCounter("symptoms.txt", "results.out").filewriter(treeMapSymptoms);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
