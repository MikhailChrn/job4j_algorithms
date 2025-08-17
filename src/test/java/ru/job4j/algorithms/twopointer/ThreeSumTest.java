package ru.job4j.algorithms.twopointer;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ThreeSumTest {

    private static List<List<Integer>> normalize(List<List<Integer>> lists) {
        return lists.stream()
                .map(sublist -> sublist.stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Test
    void case1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = List.of(
                List.of(-1, 0, 1),
                List.of(-1, -1, 2)
        );
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertThat(normalize(result))
                .containsExactlyInAnyOrderElementsOf(normalize(expected));
    }

    @Test
    void case2() {
        int[] nums = new int[]{0, 1, 1};
        List<List<Integer>> expected = List.of(List.of());
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertThat(normalize(result)).isEmpty();
    }

    @Test
    void case3() {
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> expected = List.of(
                List.of(0, 0, 0)
        );
        List<List<Integer>> result = ThreeSum.threeSum(nums);

        assertThat(normalize(result))
                .containsExactlyInAnyOrderElementsOf(normalize(expected));

    }

}