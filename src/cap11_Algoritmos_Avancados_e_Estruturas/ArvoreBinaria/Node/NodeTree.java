package cap11_Algoritmos_Avancados_e_Estruturas.ArvoreBinaria.Node;

public class NodeTree<T extends Comparable<T>> {
    private T data;
    private NodeTree<T> left, right;

    public NodeTree(T data, NodeTree<T> left, NodeTree<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public NodeTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public NodeTree<T> getLeft() {
        return left;
    }
    public void setLeft(NodeTree<T> left) {
        this.left = left;
    }

    public NodeTree<T> getRight() {
        return right;
    }
    public void setRight(NodeTree<T> right) {
        this.right = right;
    }

    public int comparable(T obj2) {
        return this.getData().compareTo(obj2);
    }

    @Override
    public String toString() {
        return ""+data;
    }
//    @Override
//    public String toString() {
//        return " |data: " + data + " - Menor: " + left + " - Maior: " + right +"| ";
//    }
}
