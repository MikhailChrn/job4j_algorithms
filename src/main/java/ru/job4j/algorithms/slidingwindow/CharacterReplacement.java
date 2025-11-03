package ru.job4j.algorithms.slidingwindow;


import java.util.*;

/**
 * You are given a string 's' and an integer 'k'.
 * You can choose any character of the string
 * and change it to any other uppercase English character.
 * You can perform this operation at most 'k' times.
 *
 * Return 'the length of the longest substring'
 * containing the same letter you can get after performing the above operations.
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int lastCharLen = 0;
        int maxLen = 0;

        for (int r = 0; r < chars.length; r++) {
            map.put(chars[r], map.getOrDefault(chars[r], 0) + 1);

            lastCharLen = Math.max(lastCharLen, map.get(s.charAt(r)));

            if (r - l + 1 - lastCharLen > k) {
                map.put(chars[l], map.get(chars[l]) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
