package cap02_Vetores_Listas_e_Ordenacao_Selecao.VetorELista.ImplLinkedList;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ImplLinkedList <T> {
    private Node<T>  first;
    private Node<T>  last;
    private int size;

    public ImplLinkedList() {
        this.size = 0;
    }
    public ImplLinkedList(T object) {
        add(object);
    }
    public ImplLinkedList(Collection<T> collection) {
        addAll(collection);
    }

    public void add(T node){
        Node<T> newNode = new Node<>(node);
        if (size == 0){
            setFirst(newNode);
        }else if(size == 1){
            this.first.setNext(newNode);
            newNode.setPrevious(first);
        }else {
            newNode.setPrevious(last);
            last.setNext(newNode);
        }
        setLast(newNode);
        size ++;
    }
    public void addAll(Collection<T> collection){
        for(T object : collection){
            add(object);
        }
    }
    public void remove(T object){
        if (object.equals(first.getItem())) {
            removeFirst();
            return;
        }
        if (object.equals(last.getItem())){
            removeLast();
            return;
        }
        var nextNode = first.getNext();
        for(int i = 1; i < size-1; i++){
            if (object.equals(nextNode.getItem())){
                var previous = nextNode.getPrevious();
                var next = nextNode.getNext();
                previous.setNext(nextNode.getNext());
                next.setPrevious(next.getPrevious());
                size--;
                break;
            }
            nextNode = nextNode.getNext();
        }

    }
    public void removeFirst(){
        if(Objects.isNull(first.getNext())){
            setFirst(null);
            setLast(null);
            size--;
            return;
        }
        Node<T> secondNode = first.getNext();
        if (Objects.isNull(secondNode.getNext())) setLast(secondNode);
        secondNode.setPrevious(null);
        setFirst(secondNode);
        size --;
    }
    public void removeLast(){
        if(Objects.isNull(last.getPrevious())){
            setLast(null);
            setFirst(null);
            size --;
            return;
        }
        Node<T> penultimate = last.getPrevious();
        if(Objects.isNull(penultimate.getPrevious())) setFirst(penultimate);
        penultimate.setNext(null);
        setLast(penultimate);
        size --;
    }

    public T get(int index){
        var currentNode = this.first;
        for(int i = 0; i <= size; i++){
            if(index == i){
                return currentNode.getItem();
            }else if (Objects.nonNull(currentNode.getNext())){
                currentNode = currentNode.getNext();
            }
        }
        throw new ArrayIndexOutOfBoundsException("Index: "+ index+ ", Size: "+ size + " - Please enter an index equal to or less than "+size);
    }
    public int getSize() {
        return size;
    }
    public T getLast() {
        if (Objects.isNull(last)) throw new NoSuchElementException("There is no node");
        return last.getItem();
    }
    public T getFirst() {
        if (Objects.isNull(first)) throw new NoSuchElementException("There is no node");
        return first.getItem();
    }
    private void setLast(Node<T> last) {
        this.last = last;
    }
    private void setFirst(Node<T> first) {
        this.first = first;
    }


}
