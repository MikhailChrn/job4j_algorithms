package ru.job4j.algorithms.hashstructures;

import java.util.*;

/**
 * Моё решение
 * В качестве 'key' для 'Map' добавляем кол-во символов строки из неповторяющихся символов,
 * в качестве 'value' = позиция первого символа этой подстроки.
 * 'Set' используем для проверки неповторяемости символов.
 *
 * Анализ моего решения:
 * Сложность O(n²) – из-за вложенных циклов (для каждой позиции i проверяются все последующие символы j).
 * Лишние операции – set.clear() на каждой итерации и повторная проверка символов.
 * Нет необходимости в Map – можно просто отслеживать максимальную длину и её начальный индекс.
 *
 * DeepSeek предложил улучшенный вариант 'со скользящим окном':
 *     Сложность O(n) – каждый символ обрабатывается только дважды (добавление и удаление из Set).
 *     Один проход – вместо вложенных циклов используется два указателя (left и right).
 *     Прямое вычисление подстроки – не нужна Map, так как startIndex и maxLength обновляются на ходу.
 */

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        if (str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < chars.length - 1; i++) {
            set.clear();

            for (int j = i; j < chars.length; j++) {
                if (set.contains(chars[j])) {
                    map.put(set.size(), i);
                    break;
                }
                if (j == chars.length - 1) {
                    map.put(set.size() + 1, i);
                    break;
                }

                set.add(chars[j]);
            }
        }

        int maxLength = Collections.max(map.keySet());

        return str.substring(map.get(maxLength), map.get(maxLength) + maxLength);
    }

    public static String longestUniqueSubstringDeepSeek(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        Set<Character> set = new HashSet<>();
        int left = 0, maxLength = 0, startIndex = 0;

        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);

            // Если символ уже есть в окне, двигаем левую границу 'скользящего окна'
            while (set.contains(currentChar)) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(currentChar);

            // Обновляем максимум и левую границу 'скользящего окна'
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }

        return str.substring(startIndex, startIndex + maxLength);
    }
}
