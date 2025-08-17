package ru.job4j.algorithms.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GcdOfStringsTest {

    @Test
    void case1() {
        String str1 = "ABCABC";
        String str2 = "ABC";
        String expected = "ABC";

        assertEquals(expected, GcdOfStrings.gcdOfStrings(str1, str2));
    }

    @Test
    void case2() {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        String expected = "AB";

        assertEquals(expected, GcdOfStrings.gcdOfStrings(str1, str2));
    }

    @Test
    void case3() {
        String str1 = "LEET";
        String str2 = "CODE";
        String expected = "";

        assertEquals(expected, GcdOfStrings.gcdOfStrings(str1, str2));
    }

    @Test
    void case4() {
        String str1 = "ABCDEF";
        String str2 = "ABC";
        String expected = "";

        assertEquals(expected, GcdOfStrings.gcdOfStrings(str1, str2));
    }

    @Test
    void case5() {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        String expected = "TAUXX";

        assertEquals(expected, GcdOfStrings.gcdOfStrings(str1, str2));
    }

    @Test
    void case6() {
        String str1 = "ABABABAB";
        String str2 = "ABAB";
        String expected = "ABAB";

        assertEquals(expected, GcdOfStrings.gcdOfStrings(str1, str2));
    }
}