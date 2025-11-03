package ru.job4j.algorithms.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterReplacementTest {

    @Test
    void case1() {
        CharacterReplacement characterReplacement = new CharacterReplacement();

        String s = "ABAB";
        int k = 2;
        int expRes = 4;
        int res = characterReplacement.characterReplacement(s, k);

        assertEquals(expRes, res);
    }

    @Test
    void case2() {
        CharacterReplacement characterReplacement = new CharacterReplacement();

        String s = "AABABBA";
        int k = 1;
        int expRes = 4;
        int res = characterReplacement.characterReplacement(s, k);

        assertEquals(expRes, res);
    }

    @Test
    void case3() {
        CharacterReplacement characterReplacement = new CharacterReplacement();

        String s = "IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR";
        int k = 2;
        int expRes = 6;
        int res = characterReplacement.characterReplacement(s, k);

        assertEquals(expRes, res);
    }
}