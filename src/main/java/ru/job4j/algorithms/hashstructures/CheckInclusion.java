package ru.job4j.algorithms.hashstructures;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static Map<Character, Integer> toMap(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        if (s2.equals(s1)) {
            return true;
        }

        Map<Character, Integer> s1map = toMap(s1);
        Map<Character, Integer> s2submap;

        for (int r = s1.length(); r <= s2.length(); r++) {
            s2submap = toMap(s2.substring(r - (s1.length()), r));
            if (s2submap.equals(s1map)) {
                return true;
            }
        }

        return false;
    }
}
