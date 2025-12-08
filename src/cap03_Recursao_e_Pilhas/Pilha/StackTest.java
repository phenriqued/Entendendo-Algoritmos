package cap03_Recursao_e_Pilhas.Pilha;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class StackTest {

    private Stack<Integer> stack = new Stack<>(3);

    @Test
    @DisplayName("Deve adicionar a pilha")
    void pop() {
        stack.pop(1);
        stack.pop(2);
        stack.pop(3);

        assertEquals(3, stack.size());
    }
    @Test
    @DisplayName("Deve lança uma StackOverflowException quando tentar adicionar mais elementos que tamanho da pilha")
    void deveLancaExceptionQuandoEstourarTamanhoPilha() {
        stack.pop(1);
        stack.pop(2);
        stack.pop(3);

        assertThrows(StackOverflowError.class, () -> stack.pop(4));
    }

    @Test
    @DisplayName("Deve remover e ler o último elemento da lista")
    void push() {
        stack.pop(1);
        stack.pop(2);

        assertTrue(stack.push().equals(2));
        assertTrue(stack.push().equals(1));
    }
    @Test
    @DisplayName("Deve lançar uma exception quando tentar remover um elemento de uma pilha vazia")
    void deveLancarExceptionQuandoRetirarElementoPilhaVazia() {
        stack.pop(1);
        stack.pop(2);

        assertTrue(stack.push().equals(2));
        assertTrue(stack.push().equals(1));
        Exception exception = assertThrows(NullPointerException.class, () -> stack.push());
        assertEquals(exception.getMessage(), "It is not possible to remove an element from an empty stack.");
    }

    @Test
    @DisplayName("Deve retornar o último elemento da Pilha")
    void peek() {
        stack.pop(1);
        stack.pop(2);

        assertTrue(stack.peek().equals(2));
    }
    @Test
    @DisplayName("Deve lançar uma NullPointerException quando tentar ler um elemento de uma pilha vazia")
    void deveLancarExceptionQuandoLerElementoPilhaVazia() {
        Exception exception = assertThrows(NullPointerException.class, () -> stack.peek());
        assertEquals(exception.getMessage(), "It is not possible to peek an element from an empty stack.");
    }

    @Test
    @DisplayName("Deve retornar true para Pilha vazia e false para Pilha com um ou mais elementos")
    void isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar true para Pilha no limite do tamanho e false para Pilha com espaço vazio")
    void isFull() {
        assertFalse(stack.isFull());
    }
}