public class RedBlackTree<T extends Comparable<T>> {

    private Node root;

    private enum Colour {
        RED, BLACK
    }

    private class Node {
        private T value;
        private Node leftChild;
        private Node rightChild;
        private Colour colour;
        public Node() {
            this.colour = Colour.RED;
        }
    }

    public boolean contains(T value) {
        Node node = new Node();
        node.value = value;
        while (node != null) {
            if (node.value.equals(value)) return true;
            if (node.value.compareTo(value) > 0) {
                node = node.leftChild;
            } else node = node.rightChild;
        }
        return false;
    }

    public boolean add(T value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.colour = Colour.BLACK;
            return result;
        } else {
            root = new Node();
            root.colour = Colour.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, T value) {
        if (node.value == value) return false;
        else {
            if (node.value.compareTo(value) > 0) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRe;
        do {
            needRe = false;
            if (result.rightChild != null && result.rightChild.colour == Colour.RED &&
                    (result.leftChild == null || result.leftChild.colour == Colour.BLACK)) {
                needRe = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.colour == Colour.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.colour == Colour.RED) {
                needRe = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.colour == Colour.RED &&
                    result.rightChild != null && result.rightChild.colour == Colour.RED) {
                needRe = true;
                colourSwap(result);
            }
        }
        while (needRe);
        return result;
    }

    private void colourSwap(Node node) {
        node.rightChild.colour = Colour.BLACK;
        node.leftChild.colour = Colour.BLACK;
        node.colour = Colour.RED;
    }

    private Node leftSwap(Node node) {
        Node left = node.leftChild;
        Node between = left.rightChild;
        left.rightChild = node;
        node.leftChild = between;
        left.colour = node.colour;
        node.colour = Colour.RED;
        return left;
    }

    private Node rightSwap(Node node) {
        Node right = node.rightChild;
        Node between = right.leftChild;
        right.leftChild = node;
        node.rightChild = between;
        right.colour = node.colour;
        node.colour = Colour.RED;
        return right;
    }
}
