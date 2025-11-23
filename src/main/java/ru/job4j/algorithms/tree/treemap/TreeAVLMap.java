package ru.job4j.algorithms.tree.treemap;

import java.util.*;

public class TreeAVLMap<K extends Comparable<K>, V> {

    private Node root;

    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }

        Node node = find(root, key);
        if (Objects.nonNull(node)) {
            node.value = value;

            return true;
        }

        root = put(root, key, value);
        return true;
    }

    public Node put(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

        int compareResult = key.compareTo(node.key);
        if (compareResult < 0) {
            node.left = put(node.left, key, value);
        } else if (compareResult > 0) {
            node.right = put(node.right, key, value);
        }

        updateHeight(node);
        return balance(node);
    }

    public boolean remove(K key) {
        boolean result = false;
        if (Objects.nonNull(key)
                && Objects.nonNull(root)
                && Objects.nonNull(find(root, key))) {
            root = remove(root, key);
            result = true;
        }

        return result;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        int comparResult = key.compareTo(node.key);
        if (comparResult < 0) {
            node.left = remove(node.left, key);
        } else if (comparResult > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if (node.left.height > node.right.height) {
                    K heir = maximum(node.left).key;
                    node.key = heir;
                    node.left = remove(node.left, heir);
                } else {
                    K heir = minimum(node.right).key;
                    node.key = heir;
                    node.right = remove(node.right, heir);
                }
            }
        }

        updateHeight(node);
        return balance(node);
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }
        Node node = root;
        Node result = find(node, key);

        return result != null ? result.value : null;
    }

    private Node find(Node node, K key) {
        if (Objects.isNull(root)) {
            return null;
        }

        int compareResult = Objects.isNull(node)
                ? 0 : key.compareTo(node.key);

        if (compareResult == 0) {
            return node;

        } else if (compareResult < 0) {
            return find(node.left, key);
        }

        return find(node.right, key);
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        Node node = root;

        return keysInSymmetricalOrder(node, keys);
    }

    private Set<K> keysInSymmetricalOrder(Node localRoot, Set<K> set) {
        if (localRoot != null) {
            keysInSymmetricalOrder(localRoot.left, set);
            set.add(localRoot.key);
            keysInSymmetricalOrder(localRoot.right, set);
        }

        return set;
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        Node node = root;

        return valuesInSymmetricalOrder(node, values);
    }

    private List<V> valuesInSymmetricalOrder(Node localRoot, List<V> list) {
        if (localRoot != null) {
            valuesInSymmetricalOrder(localRoot.left, list);
            list.add(localRoot.value);
            valuesInSymmetricalOrder(localRoot.right, list);
        }

        return list;
    }

    public K minimum() {
        return Objects.nonNull(root) ? minimum(root).key : null;
    }

    private Node minimum(Node node) {
        if (Objects.isNull(node.left)) {
            return node;
        }

        return minimum(node.left);
    }

    public K maximum() {
        return Objects.nonNull(root) ? maximum(root).key : null;
    }

    private Node maximum(Node node) {
        if (Objects.isNull(node.right)) {
            return node;
        }

        return maximum(node.right);
    }

    private void updateHeight(Node node) {
        int leftNodeHeight = Objects.isNull(node.left) ? -1 : node.left.height;
        int rightNodeHeight = Objects.isNull(node.right) ? -1 : node.right.height;
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node node) {
        Node result = node;
        if (node.balanceFactor < -1) {
            if (node.left.balanceFactor >= 0) {
                result = leftRightCase(node);
            } else {
                result = rightRotation(node);
            }
        } else if (node.balanceFactor > 1) {
            if (node.right.balanceFactor >= 0) {
                result = leftRotation(node);
            } else {
                result = rightLeftCase(node);
            }
        }

        return result;
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);

        return rightRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);

        return leftRotation(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        updateHeight(node);
        updateHeight(newParent);

        return newParent;
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        updateHeight(node);
        updateHeight(newParent);

        return newParent;
    }

    private class Node {
        private int balanceFactor;
        private K key;
        private V value;
        private int height;
        private Node left;
        private Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
