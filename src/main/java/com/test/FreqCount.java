package com.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FreqCount {
	private static void countAndDisplay(String text) {
        String[] words = text.split("\\W+");

        Map<String, Integer> freqMap = new HashMap<String, Integer>();

        for (String w : words) {
            freqMap.merge(w, 1, Integer::sum);
        }

        // Sort and Print
        HashMap<String, Integer> temp = freqMap.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<String, Integer> en : temp.entrySet()) {
            System.out.println(en.getValue() + " " + en.getKey());
        }
    }

    public static void main(String[] args)
            throws IOException {

        String text = "the cat is in the bag";

        countAndDisplay(text);
    }
}
