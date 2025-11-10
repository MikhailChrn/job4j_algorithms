package ru.job4j.algorithms.tree;

import ru.job4j.algorithms.tree.queue.SimpleQueue;
import ru.job4j.algorithms.tree.queue.SimpleStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TreeUtils<T> {

    /**
     * Метод выполняет обход дерева и считает количество узлов
     *
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
     *
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

    /**
     * Метод обходит дерево root и добавляет к узлу с ключом parent
     * новый узел с ключом child, при этом на момент добавления узел с ключом parent
     * уже должен существовать в дереве, а узла с ключом child в дереве быть не должно
     *
     * @param root   корень дерева
     * @param parent ключ узла-родителя
     * @param child  ключ узла-потомка
     * @return true если добавление произошло успешно и false в обратном случае.
     * @throws IllegalArgumentException если root является null
     */
    public boolean add(Node<T> root, T parent, T child) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        Optional<Node<T>> optionalTNode = this.findByKey(root, parent);

        if (optionalTNode.isPresent()) {
            optionalTNode.get().setChildren(List.of(new Node<T>(child)));
            return true;
        }

        return false;
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key
     *
     * @param root корень дерева
     * @param key  ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> findByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        Node<T> result = null;

        SimpleStack<Node<T>> job4jSimpleStack = new SimpleStack<>();
        job4jSimpleStack.push(root);

        while (!job4jSimpleStack.isEmpty()) {
            Node<T> node = job4jSimpleStack.pop();
            if (key.equals(node.getValue())) {
                result = node;
                break;
            }
            if (!node.getChildren().isEmpty()) {
                node.getChildren().forEach(job4jSimpleStack::push);
            }
        }

        return result == null
                ? Optional.empty()
                : Optional.of(result);
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key,
     * при этом из дерева root удаляется все поддерево найденного узла
     *
     * @param root корень дерева
     * @param key  ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> divideByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        Optional<Node<T>> optionalNode = this.findByKey(root, key);

        if (optionalNode.isPresent()) {
            this.removeFromParent(root, optionalNode.get());
            return optionalNode;
        }

        return Optional.empty();
    }

    public void removeFromParent(Node<T> root, Node<T> targetNode) {
        if (root == targetNode) {
            root.clear();
        }

        SimpleStack<Node<T>> job4jSimpleStack = new SimpleStack<>();
        job4jSimpleStack.push(root);

        while (!job4jSimpleStack.isEmpty()) {
            Node<T> node = job4jSimpleStack.pop();

            if (node.getChildren().contains(targetNode)) {
                node.getChildren().remove(targetNode);
                break;
            }

            if (!node.getChildren().isEmpty()) {
                node.getChildren().forEach(job4jSimpleStack::push);
            }
        }
    }
}
