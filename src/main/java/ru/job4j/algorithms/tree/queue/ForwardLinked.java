package ru.job4j.algorithms.tree.queue;

import java.util.*;

/**
 * Реализация односвязного списка
 * @author MikhailChrn
 * @version 1.1
 * @since 07.11.2025
 */

public class ForwardLinked<T> implements Iterable<T> {
    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null);
        modCount++;
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(newNode);
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> point = head;
        int i = 0;
        while (i < index) {
            point = point.getNext();
            i++;
        }
        return point.getItem();
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T result = head.getItem();
        Node<T> newHead = head.getNext();
        head.setItem(null);
        head.setNext(null);
        head = newHead;
        modCount++;
        size--;
        return result;
    }

    public void addFirst(T value) {
        head = new Node<>(value, head);
        modCount++;
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> iNode = head;
            private int iteratorControler = modCount;

            @Override
            public boolean hasNext() {
                if (iteratorControler != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T item = iNode.getItem();
                iNode = iNode.getNext();
                return item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }
    }
}
