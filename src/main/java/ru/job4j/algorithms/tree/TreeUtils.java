package ru.job4j.algorithms.tree;

import ru.job4j.algorithms.tree.queue.SimpleQueue;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils<T> {

    /**
     * Метод выполняет обход дерева и считает количество узлов
     * @param root корневой узел дерева
     * @return количество узлов
     * @throws IllegalArgumentException если root является null
     */
    public int countNode(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        List<T> list = (List<T>) findAll(root);

        return list.size();
    }

    /**
     * Метод выполняет обход дерева и возвращает коллекцию ключей узлов дерева
     * @param root корневой узел
     * @return коллекция с ключами, реализующая интерфейс Iterable<E>
     * @throws IllegalArgumentException если root является null
     */
    public Iterable<T> findAll(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        List<T> list = new ArrayList<>();

        SimpleQueue<Node<T>> job4jSimpleQueue = new SimpleQueue<>();
        job4jSimpleQueue.push(root);

        while (!job4jSimpleQueue.isEmpty()) {
            Node<T> node = job4jSimpleQueue.poll();
            list.add(node.getValue());

            if (!node.getChildren().isEmpty()) {
                node.getChildren().forEach(job4jSimpleQueue::push);
            }
        }

        return list;
    }
}
