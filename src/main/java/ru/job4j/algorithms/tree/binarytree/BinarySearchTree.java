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
        int compareResult = key.compareTo(node.key);

        if (compareResult == 0) {
            return false;

        } else if (compareResult < 0) {
            if (node.left == null) {
                node.left = new Node(key);
                return true;
            } else {
                return put(node.left, key);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(key);
                return true;
            } else {
                return put(node.right, key);
            }
        }
    }

    public boolean contains(T key) {
        if (Objects.isNull(root)) {
            return false;
        }

        return !Objects.isNull(find(root, key));
    }

    private Node find(Node node, T key) {
        int compareResult = Objects.isNull(node)
                ? 0 : key.compareTo(node.key);

        if (compareResult == 0) {
            return node;

        } else if (compareResult < 0) {
            return find(node.left, key);
        }

        return find(node.right, key);
    }

    /**
     * Как видим, в конце метода remove() узел 'cursorNode' имеет необнуленные ссылки - на потомков.
     * Доработайте метод remove() так, чтобы избежать утечки памяти.
     * Проверьте работу всех методов дерева. Добавьте необходимые тесты.
     */

    public boolean remove(T key) {
        boolean result = false;
        if (Objects.nonNull(key) && Objects.nonNull(root)) {
            result = removePrivat(key);
        }
        return result;
    }

    /**
     * Удаляет узел с заданным ключом из бинарного дерева поиска, корректно обрабатывая все возможные случаи.
     * Случай 1: Узел - лист (нет потомков);
     * Случай 2: Только левый потомок;
     * Случай 3: Только правый потомок;
     * Случай 4: Есть оба потомка.
     *
     * nodeToRemove - удаляемый узел
     * parentNodeToRemove - родительский узел для 'nodeToRemove'
     * nodeToReplace - узел заменяет 'nodeToRemove' в структуре дерева
     */

    private boolean removePrivat(T key) {
        boolean result = true;
        Node nodeToRemove = root;
        Node parentNodeToRemove = root;
        boolean isLeftBranch = true;

        while (result && !Objects.equals(nodeToRemove.key, key)) {
            parentNodeToRemove = nodeToRemove;
            int compareResult = key.compareTo(nodeToRemove.key);
            if (compareResult < 0) {
                isLeftBranch = true;
                nodeToRemove = nodeToRemove.left;
            } else if (compareResult > 0) {
                isLeftBranch = false;
                nodeToRemove = nodeToRemove.right;
            }
            if (Objects.isNull(nodeToRemove)) {
                result = false;
            }
        }

        if (result) {
            if (Objects.isNull(nodeToRemove.left) && Objects.isNull(nodeToRemove.right)) {
                swap(isLeftBranch, parentNodeToRemove, nodeToRemove, null);
            } else if (Objects.nonNull(nodeToRemove.left) && Objects.isNull(nodeToRemove.right)) {
                swap(isLeftBranch, parentNodeToRemove, nodeToRemove, nodeToRemove.left);
            } else if (Objects.isNull(nodeToRemove.left)) {
                swap(isLeftBranch, parentNodeToRemove, nodeToRemove, nodeToRemove.right);
            } else {
                Node nodeToReplace = getHeir(nodeToRemove);
                swap(isLeftBranch, parentNodeToRemove, nodeToRemove, nodeToReplace);
                nodeToReplace.left = nodeToRemove.left;
            }

            nodeToRemove.left = null;
            nodeToRemove.right = null;
        }

        return result;
    }

    /**
     * Метод заменяет узел 'nodeToRemove' на узел 'nodeToReplace' в структуре дерева,
     * правильно обновляя связи с родительским узлом.
     */
    private void swap(boolean isLeft,
                      Node parentNodeToRemove,
                      Node nodeToRemove,
                      Node nodeToReplace) {
        if (Objects.equals(nodeToRemove, root)) {
            root = nodeToReplace;
        } else if (isLeft) {
            parentNodeToRemove.left = nodeToReplace;
        } else {
            parentNodeToRemove.right = nodeToReplace;
        }
    }

    /**
     * Находит минимальный элемент в правом поддереве удаляемого узла
     * Этот элемент становится заменой для удаляемого узла
     * @param nodeToRemove - удаляемый узел
     * @return возвращаем подходящего преемника для замены удаляемого узла
     */
    private Node getHeir(Node nodeToRemove) {
        Node parentNodeToReplace = nodeToRemove;
        Node nodeToReplace = nodeToRemove;
        Node cursor = nodeToRemove.right;
        while (cursor != null) {
            parentNodeToReplace = nodeToReplace;
            nodeToReplace = cursor;
            cursor = cursor.left;
        }
        if (nodeToReplace != nodeToRemove.right) {
            parentNodeToReplace.left = nodeToReplace.right;
            nodeToReplace.right = nodeToRemove.right;
        }

        return nodeToReplace;
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
        return root.toString();
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

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] array = new int[]{2, 1, 10, 6, 14, 4, 8, 12, 16, 11, 9, 13, 15, 17, 3, 5, 7};
        for (int i : array) {
            bst.put(i);
        }
        System.out.println(bst);
        System.out.println(bst.remove(10));
        System.out.println("После удаления узла 10 :");
        System.out.println(bst);
    }
}
