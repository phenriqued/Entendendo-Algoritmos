package cap11_Algoritmos_Avancados_e_Estruturas.ArvoreBinaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeInsertSearchTest {

    private BinaryTree<Integer> binaryTree = new BinaryTree<>();

    @BeforeEach
    void setup() {
        binaryTree = new BinaryTree<>();
        List.of(10, 5, 15, 7, 4, 20, 13, 1, 25, 30).forEach(binaryTree::add);
    }

    @Test
    @DisplayName("deveria adicionar um dado a árvore binária.")
    void testAdd() {
        assertEquals(10, binaryTree.getDegreeOfNo());
        binaryTree.add(22);
        assertEquals(11, binaryTree.getDegreeOfNo());
        assertEquals(List.of(1, 4, 5, 7, 10, 13, 15, 20, 22, 25, 30), binaryTree.inOrder(10));
    }

    @Test
    @DisplayName("não deveria adicionar um dado idêntico ao que já existe na árvore binária.")
    void testNotAddIdenticalValueInTree() {
        assertEquals(10, binaryTree.getDegreeOfNo());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> binaryTree.add(10));
        assertEquals("It is not possible to add identical value in the tree.", exception.getMessage());
    }

    @Test
    @DisplayName("deveria adicionar dados de forma consistente mais profundamente")
    void testDeepInsertion() {
        BinaryTree<Integer> deepTree = new BinaryTree<>();
        deepTree.add(10);
        deepTree.add(5);
        deepTree.add(3);
        deepTree.add(2);
        deepTree.add(1);

        assertEquals(5, deepTree.getDegreeOfNo());
        assertEquals(List.of(1, 2, 3, 5, 10), deepTree.inOrder(10));
    }

    @Test
    @DisplayName("deveria encontrar um dado que esteja dentro da árvore")
    void testSearch() {
        assertEquals(20, binaryTree.search(20));
    }
    @Test
    @DisplayName("deveria retornar null quando dado não encontrado dentro da árvore")
    void testFindReturnNullForNonExistData() {
        assertNull(binaryTree.search(999));
    }

    @Test
    @DisplayName("deveria retornar uma lista com o percurso em ordem")
    void testInOrder() {
        assertEquals(binaryTree.inOrder(binaryTree.getRoot()), List.of(1, 4, 5, 7, 10, 13, 15, 20, 25, 30));
    }
    @Test
    @DisplayName("deveria retornar uma lista vazia quando o inicio do percurso em ordem é inexistente.")
    void testInOrderReturnEmptyListWhenSourceNonExist() {
        assertEquals(binaryTree.inOrder(999), List.of());
    }

    @Test
    @DisplayName("deveria retornar uma lista com o percurso em ordem")
    void testInPreOrder() {
        assertEquals(binaryTree.preOrder(binaryTree.getRoot()), List.of(10, 5, 4, 1, 7, 15, 13, 20, 25, 30));
    }
    @Test
    @DisplayName("deveria retornar uma lista vazia quando o inicio do percurso em pre-ordem é inexistente.")
    void testPreOrderReturnEmptyListWhenSourceNonExist() {
        assertEquals(binaryTree.preOrder(999), List.of());
    }

    @Test
    @DisplayName("deveria retornar uma lista com o percurso em ordem")
    void testInPostOrder() {
        assertEquals(binaryTree.postOrder(binaryTree.getRoot()), List.of(1, 4, 7, 5, 13, 30, 25, 20, 15, 10));
    }
    @Test
    @DisplayName("deveria retornar uma lista vazia quando o inicio do percurso em pós ordem é inexistente.")
    void testPostOrderReturnEmptyListWhenSourceNonExist() {
        assertEquals(binaryTree.postOrder(999), List.of());
    }

}