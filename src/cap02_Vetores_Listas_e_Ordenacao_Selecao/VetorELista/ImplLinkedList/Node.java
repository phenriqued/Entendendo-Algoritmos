package cap02_Vetores_Listas_e_Ordenacao_Selecao.VetorELista.ImplLinkedList;

import java.util.Objects;

public class Node<T>{
    private T item;
    private Node<T> next;
    private Node<T> previous;

    public Node(T item, Node<T> next, Node<T> previous) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }

    public Node(T item) {
        checkObjectNotNull(item);
        this.item = item;
    }

    public boolean hasNext(){
        return Objects.nonNull(this.next);
    }
    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }
    Node<T> getNext() {
        return next;
    }
    void setNext(Node<T> next) {
        this.next = next;
    }
    Node<T> getPrevious() {
        return previous;
    }
    void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    private void checkObjectNotNull(T node){
        if (Objects.isNull(node)) throw new NullPointerException("It is not possible to create a null object.");
    }
}
