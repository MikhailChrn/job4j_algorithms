package ru.job4j.algorithms.hashstructures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CheckInclusionTest {
    @Test
    void case1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean expected = true;
        CheckInclusion c = new CheckInclusion();
        assertThat(c.checkInclusion(s1, s2)).isEqualTo(expected);
    }

    @Test
    void case2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean expected = false;
        CheckInclusion c = new CheckInclusion();
        assertThat(c.checkInclusion(s1, s2)).isEqualTo(expected);
    }

    @Test
    void case3() {
        String s1 = "adc";
        String s2 = "dcda";
        boolean expected = true;
        CheckInclusion c = new CheckInclusion();
        assertThat(c.checkInclusion(s1, s2)).isEqualTo(expected);
    }
}