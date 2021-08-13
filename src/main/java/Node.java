public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> rightNode;
    private Node<T> leftNode;

    public Node(T data) {
        this.data = data;
        this.leftNode = this.rightNode = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }


    @Override
    public String toString() {
        return data.toString();
    }
}
