package ru.job4j.algorithms.hashstructures;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] key = str.toCharArray();
            Arrays.sort(key);
            List<String> value = map.get(String.valueOf(key));
            if (value == null) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(String.valueOf(key), list);
            } else {
                value.add(str);
            }
        }

        return map.entrySet().stream()
                .map(Map.Entry::getValue)
                .toList();
    }
}

