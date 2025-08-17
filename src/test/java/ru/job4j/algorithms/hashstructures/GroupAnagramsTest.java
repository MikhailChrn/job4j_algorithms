package ru.job4j.algorithms.hashstructures;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class GroupAnagramsTest {
    private static List<List<String>> normalize(List<List<String>> lists) {
        return lists.stream()
                .map(sublist -> sublist.stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Test
    void case1() {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = List.of(List.of("bat"),
                List.of("nat", "tan"),
                List.of("ate", "eat", "tea")
        );
        List<List<String>> result = GroupAnagrams.groupAnagrams(input);

        assertThat(normalize(result))
                .containsExactlyInAnyOrderElementsOf(normalize(expected));
    }

    @Test
    void case2() {
        String[] input = new String[]{""};
        List<List<String>> expected = List.of(List.of(""));
        List<List<String>> result = GroupAnagrams.groupAnagrams(input);
        assertThat((result)).isEqualTo(expected);
    }

    @Test
    void case3() {
        String[] input = new String[]{"a"};
        List<List<String>> expected = List.of(List.of("a"));
        List<List<String>> result = GroupAnagrams.groupAnagrams(input);
        assertThat((result)).isEqualTo(expected);
    }
}