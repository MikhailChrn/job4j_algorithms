package ru.job4j.algorithms.twopointer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class FourSumTest {
    private static List<List<Integer>> normalize(List<List<Integer>> lists) {
        return lists.stream()
                .map(sublist -> sublist.stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    @Test
    void case1() {
        int target = 0;
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> expected = List.of(
                List.of(-2, -1, 1, 2),
                List.of(-2, 0, 0, 2),
                List.of(-1, 0, 0, 1)
        );
        List<List<Integer>> result = FourSum.fourSum(nums, target);

        assertThat(normalize(result))
                .containsExactlyInAnyOrderElementsOf(normalize(expected));
    }

    @Test
    void case2() {
        int target = 8;
        int[] nums = new int[]{2, 2, 2, 2, 2};
        List<List<Integer>> expected = List.of(
                List.of(2, 2, 2, 2)
        );
        List<List<Integer>> result = FourSum.fourSum(nums, target);

        assertThat(normalize(result))
                .containsExactlyInAnyOrderElementsOf(normalize(expected));
    }

    @Test
    void case3() {
        int target = 0;
        int[] nums = new int[]{-2, -1, -1, 1, 1, 2, 2};
        List<List<Integer>> expected = List.of(
                List.of(-2, -1, 1, 2),
                List.of(-1, -1, 1, 1)
        );
        List<List<Integer>> result = FourSum.fourSum(nums, target);

        assertThat(normalize(result))
                .containsExactlyInAnyOrderElementsOf(normalize(expected));
    }

    @Test
    void case4() {
        int target = -294967296;
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> expected = new ArrayList<>();
        List<List<Integer>> result = FourSum.fourSum(nums, target);

        assertThat(normalize(result)).isEqualTo(expected);

    }
}