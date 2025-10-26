package ru.job4j.algorithms.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Необходимо проверить строку.
 * Строка должна содержать валидное сочетания скобок.
 * Скобки могут быть: обычные '(', фигурные '{', квадратные '['.
 */

class Brackets {
    private static final Map<Character, Character> BRACKETS_PAIRS = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char top;

        for (char ch : s.toCharArray()) {
            if (BRACKETS_PAIRS.containsValue(ch)) {
                stack.push(ch);
                continue;
            }
            if (BRACKETS_PAIRS.containsKey(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                top = stack.pop();
                if (BRACKETS_PAIRS.get(ch) != top) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
