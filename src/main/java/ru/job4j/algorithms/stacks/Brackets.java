package ru.job4j.algorithms.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Необходимо проверить строку.
 * Строка должна содержать валидное сочетания скобок.
 * Скобки могут быть: обычные '(', фигурные '{', квадратные '['.
 */

class Brackets {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char top;

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                top = stack.pop();
                if ((ch == ')' && top != '(')
                        || (ch == '}' && top != '{')
                        || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
