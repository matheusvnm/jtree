public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(T item) {
        Node<T> node = new Node<>(item);
        root = this.insert(root, node);
    }

    private Node<T> insert(Node<T> actualNode, Node<T> newNode) {
        if (actualNode == null) {
            return newNode;
        } else if (newNode.getData().compareTo(actualNode.getData()) < 0) {
            actualNode.setLeftNode(insert(actualNode.getLeftNode(), newNode));
        } else {
            actualNode.setRightNode(insert(actualNode.getRightNode(), newNode));
        }
        return actualNode;
    }

    public void remove(T item) {
        root = removeItem(root, item);
    }

    private Node<T> removeItem(Node<T> actualNode, T item) {
        if (actualNode == null)
            return null;
        if (actualNode.getData() == item) {
            actualNode = itemFound(actualNode, item);
        } else if (actualNode.getData().compareTo(item) > 0) {
            actualNode.setLeftNode(removeItem(actualNode.getLeftNode(), item));
        } else {
            actualNode.setRightNode(removeItem(actualNode.getRightNode(), item));
        }
        return actualNode;
    }

    private Node<T> itemFound(Node<T> actualNode, T item) {
        if (actualNode.getLeftNode() == null && actualNode.getRightNode() == null) {
            return null;
        } else if (actualNode.getLeftNode() == null) {
            return actualNode.getRightNode();
        } else if (actualNode.getRightNode() == null) {
            return actualNode.getLeftNode();
        } else {
            actualNode.setData(findSmallestNodeValue(actualNode.getRightNode()));
            actualNode.setRightNode(removeItem(actualNode.getRightNode(), actualNode.getData()));
            return actualNode;
        }
    }

    private T findSmallestNodeValue(Node<T> parentNode) {
        return parentNode.getLeftNode() == null ?
                parentNode.getData() :
                findSmallestNodeValue(parentNode.getLeftNode());
    }

    public boolean contains(T item) {
        return containsNode(root, item);
    }

    private boolean containsNode(Node<T> actualNode, T item) {
        if (actualNode == null)
            return false;
        if (item == actualNode.getData())
            return true;
        return actualNode.getData().compareTo(item) > 0 ?
                containsNode(actualNode.getLeftNode(), item) :
                containsNode(actualNode.getRightNode(), item);
    }

    public void traverseTree(String mode) {
        if (mode == null)
            throw new NullPointerException("The mode argument must not be null.");

        switch (mode) {
            case "preorder":
                traversePreOrder(root);
                break;
            case "inorder":
                traverseInOrder(root);
                break;
            case "postorder":
                traversePostOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Invalid argument. Please use: preorder, inorder or postorder");
        }
    }

    private void traversePreOrder(Node<?> actualNode) {
        if (actualNode == null)
            return;
        System.out.println(actualNode);
        traversePreOrder(actualNode.getLeftNode());
        traversePreOrder(actualNode.getRightNode());
    }

    private void traverseInOrder(Node<?> actualNode) {
        if (actualNode == null)
            return;

        traverseInOrder(actualNode.getLeftNode());
        System.out.println(actualNode);
        traverseInOrder(actualNode.getRightNode());
    }

    private void traversePostOrder(Node<?> actualNode) {
        if (actualNode == null)
            return;
        traversePostOrder(actualNode.getLeftNode());
        traversePostOrder(actualNode.getRightNode());
        System.out.println(actualNode);
    }
}
