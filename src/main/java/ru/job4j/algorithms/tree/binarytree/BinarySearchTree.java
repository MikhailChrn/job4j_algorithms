package ru.job4j.algorithms.tree.binarytree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public boolean put(T key) {
        if (Objects.isNull(root)) {
            root = new Node(key);
            return true;
        }

        return put(root, key);
    }

    private boolean put(Node node, T key) {
        int matchRes = key.compareTo(node.key);

        if (matchRes == 0) {
            return true;

        } else if (matchRes < 0) {
            if (node.left == null) {
                node.left = new Node(key);
                return true;
            }
            put(node.left, key);

        } else {
            if (node.right == null) {
                node.right = new Node(key);
                return true;
            }
            put(node.right, key);
        }

        return false;
    }

    public boolean contains(T key) {
        if (Objects.isNull(root)) {
            return false;
        }

        return !Objects.isNull(find(root, key));
    }

    private Node find(Node node, T key) {
        int matchRes = Objects.isNull(node)
                ? 0 : key.compareTo(node.key);

        if (matchRes == 0) {
            return node;

        } else if (matchRes < 0) {
            return find(node.left, key);
        }

        return find(node.right, key);
    }

    public boolean remove(T key) {
        
        return false;
    }

    public List<T> inSymmetricalOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inSymmetricalOrder(node, result);
    }

    private List<T> inSymmetricalOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inSymmetricalOrder(localRoot.left, list);
            list.add(localRoot.key);
            inSymmetricalOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPreOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inPreOrder(node, result);
    }

    private List<T> inPreOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            list.add(localRoot.key);
            inPreOrder(localRoot.left, list);
            inPreOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPostOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inPostOrder(node, result);
    }

    private List<T> inPostOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inPostOrder(localRoot.left, list);
            inPostOrder(localRoot.right, list);
            list.add(localRoot.key);
        }
        return list;
    }

    public T minimum() {
        return Objects.nonNull(root) ? minimum(root).key : null;
    }

    private Node minimum(Node node) {
        if (Objects.isNull(node.left)) {
            return node;
        }

        return minimum(node.left);
    }

    public T maximum() {
        return Objects.nonNull(root) ? maximum(root).key : null;
    }

    private Node maximum(Node node) {
        if (Objects.isNull(node.right)) {
            return node;
        }

        return maximum(node.right);
    }

    @Override
    public String toString() {
        return PrintTree.getTreeDisplay(root);
    }

    private class Node implements VisualNode {
        private T key;
        private Node left;
        private Node right;

        public Node(T key) {
            this.key = key;
        }

        @Override
        public VisualNode getLeft() {
            return left;
        }

        @Override
        public VisualNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return key.toString();
        }
    }
}
