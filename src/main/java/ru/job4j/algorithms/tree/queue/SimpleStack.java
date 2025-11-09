package ru.job4j.algorithms.tree.queue;

import java.util.List;

/**
 * Реализация Stack(LIFO) на базе односвязного списка
 * @author MikhailChrn
 * @version 1.1
 * @since 07.11.2025
 */

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }

    public List<T> toList() {
        return linked.toList();
    }
}
