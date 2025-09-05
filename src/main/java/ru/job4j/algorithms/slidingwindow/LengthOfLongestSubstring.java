package ru.job4j.algorithms.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int l = 0;
        int maxLen = 0;

        for (int r = 0; r < chars.length; r++) {

                while (set.contains(chars[r])) {
                    set.remove(chars[l]);
                    l++;
                }

                set.add(chars[r]);
                maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}
