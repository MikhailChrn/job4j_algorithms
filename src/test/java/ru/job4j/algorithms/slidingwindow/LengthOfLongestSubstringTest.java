package ru.job4j.algorithms.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest {

    @Test
    void case1() {
        String s = "abcabcbb";
        int exp = 3;
        int res = LengthOfLongestSubstring.lengthOfLongestSubstring(s);
        assertEquals(exp, res);
    }

    @Test
    void case2() {
        String s = "bbbbb";
        int exp = 1;
        int res = LengthOfLongestSubstring.lengthOfLongestSubstring(s);
        assertEquals(exp, res);
    }

    @Test
    void case3() {
        String s = "pwwkew";
        int exp = 3;
        int res = LengthOfLongestSubstring.lengthOfLongestSubstring(s);
        assertEquals(exp, res);
    }

    @Test
    void case4() {
        String s = "aab";
        int exp = 2;
        int res = LengthOfLongestSubstring.lengthOfLongestSubstring(s);
        assertEquals(exp, res);
    }

}