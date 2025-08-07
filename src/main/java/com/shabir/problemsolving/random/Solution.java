package com.shabir.problemsolving.random;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {

        String input = "ababcdcegfde";
        //String input = "ababcdd";
        System.out.println(findFirstChar(input));
    }

    private static char findFirstChar(String input) {

        Map<Character, Integer> charCountMap = new LinkedHashMap<>();
        char[] chars = input.toCharArray();
        for (char character : chars) {
            if (charCountMap.containsKey(character)) {
                charCountMap.put(character, charCountMap.get(character) + 1);
                continue;
            }
            charCountMap.put(character, 1);
        }

        System.out.println(charCountMap);

        Set<Data> dataSet = new TreeSet<>((data1, data2) -> {
            if (data1.getCount() < data2.getCount()) {
                return -1;
            }
            return 1;
        });

        for (Map.Entry<Character, Integer> mapEntry : charCountMap.entrySet()) {
            Data data = new Data(mapEntry.getKey(), mapEntry.getValue());
            dataSet.add(data);
        }

        System.out.println(dataSet);
        return dataSet.iterator().next().getKey();
    }
}

class Data {

    private Character key;
    private Integer count;
    Data(Character key, Integer count) {
        this.key = key;
        this.count = count;
    }

    public String toString() {
        return key + ":" + count;
    }

    public Character getKey() {
        return key;
    }

    public Integer getCount() {
        return count;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
