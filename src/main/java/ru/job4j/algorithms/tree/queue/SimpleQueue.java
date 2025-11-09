package ru.job4j.algorithms.tree.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Реализация Queue(FIFO) на базе двух Stack
 * @author MikhailChrn
 * @version 1.1
 * @since 07.11.2025
 */

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIn;
    private int sizeOut;

    public T poll() {
        if (sizeIn == 0 && sizeOut == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (sizeOut == 0) {
            while (sizeIn > 0) {
                out.push(in.pop());
                sizeIn--;
                sizeOut++;
            }
        }
        sizeOut--;
        return out.pop();
    }

    public void push(T value) {
        sizeIn++;
        in.push(value);
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }

    public List<T> toList() {
        List<T> result = out.toList();
        List<T> inElements = in.toList();
        Collections.reverse(inElements);
        result.addAll(inElements);
        return result;
    }
}
