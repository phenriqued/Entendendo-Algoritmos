package cap02_Vetores_Listas_e_Ordenacao_Selecao.VetorELista;

import cap02_Vetores_Listas_e_Ordenacao_Selecao.VetorELista.ImplLinkedList.ImplLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class ImplLinkedListTest {

    @Test
    @DisplayName("Deve retornar o tamanho da lista")
    void getSize() {
        ImplLinkedList<Integer> linkedList = new ImplLinkedList<>(List.of(1, 2, 3));
        assertEquals(3, linkedList.getSize());
    }

    @Test
    @DisplayName("Deve adicionar cada elemento individualmente a lista, alterando o tamanho da lista")
    void add() {
        ImplLinkedList<Integer> linkedList = new ImplLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        assertTrue(linkedList.getFirst().equals(1));
        assertEquals(3, linkedList.getSize());
    }

    @Test
    @DisplayName("Deve adicionar uma lista de elementos a listas, alterando o tamanho da lista")
    void addAll() {
        ImplLinkedList<Integer> linkedList = new ImplLinkedList<>();
        linkedList.addAll(List.of(1, 2, 3));
        assertTrue(linkedList.getFirst().equals(1));
        assertEquals(3, linkedList.getSize());
    }

    @Test
    @DisplayName("Deve remover um elemento da lista, diminuindo o tamanho da lista")
    void remove() {
        ImplLinkedList<Integer> linkedList = new ImplLinkedList<>(List.of(1, 2, 3));
        linkedList.remove(2);

        assertEquals(2, linkedList.getSize());
    }

    @Test
    @DisplayName("Deve remover o primeiro elemento da lista, diminuindo o tamanho da lista")
    void removeFirst() {
        ImplLinkedList<Integer> linkedList = new ImplLinkedList<>(List.of(1, 2, 3));
        linkedList.removeFirst();
        assertTrue(linkedList.getFirst().equals(2));
        assertEquals(2, linkedList.getSize());
    }

    @Test
    @DisplayName("Deve remover o último elemento da lista, diminuindo o tamanho da lista")
    void removeLast() {
        ImplLinkedList<Integer> linkedList = new ImplLinkedList<>(List.of(1, 2, 3));
        linkedList.removeLast();
        assertTrue(linkedList.getLast().equals(2));
        assertEquals(2, linkedList.getSize());
    }

}