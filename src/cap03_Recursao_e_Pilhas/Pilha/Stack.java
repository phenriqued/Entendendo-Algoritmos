package cap03_Recursao_e_Pilhas.Pilha;

public class Stack<T>{

    private T[] elements;
    private int top = -1; // pilha vazia


    @SuppressWarnings("unchecked")
    public Stack(int stackSize) {
        this.elements = (T[]) new Object[stackSize];
    }


    public void pop(T element){
        if(isFull()){
            throw new StackOverflowError();
        }
        top ++;
        elements[top] = element;
    }

    public T push() {
        if (isEmpty()){
            throw new NullPointerException("It is not possible to remove an element from an empty stack.");
        }
        T element = elements[top];
        elements[top] = null;
        top --;
        return element;
    }

    public T peek(){
        if (isEmpty()){
            throw new NullPointerException("It is not possible to peek an element from an empty stack.");
        }
        return elements[top];
    }

    public int size(){
        return elements.length;
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == elements.length -1;
    }

}
