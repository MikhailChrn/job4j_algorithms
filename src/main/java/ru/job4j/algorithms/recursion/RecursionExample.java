package ru.job4j.algorithms.recursion;

public class RecursionExample {
    /**
     *  По результату работы видно, что сначала несколько раз отрабатывает та часть кода метода sum,
     *  которая расположена ДО рекурсивного вызова, и только после того,
     *  как условие if (index > 0) не выполняется, все открытые методы,
     *  начиная с последнего (номер 6 в квадратных скобках на скрине с отладчиком, затем 5 и так далее),
     *  начинают закрываться и дорабатывать оставшуюся часть кода - располагающуюся ПОСЛЕ рекурсивного вызова.
     */
    public int sum(int summary, int index) {
        if (index > 0) {
            summary += index;
            index--;
            System.out.println(" ".repeat(index) + "before " + index);
            summary = sum(summary, index);
            System.out.println(" ".repeat(index) + "after " + index);
        }
        return summary;
    }

    public static void main(String[] args) {
        RecursionExample recursion = new RecursionExample();
        int result = recursion.sum(10, 5);
        System.out.println("result = " + result);
    }
}
