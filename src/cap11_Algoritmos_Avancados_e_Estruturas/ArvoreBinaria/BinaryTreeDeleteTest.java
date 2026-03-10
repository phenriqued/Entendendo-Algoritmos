package cap11_Algoritmos_Avancados_e_Estruturas.ArvoreBinaria;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeDeleteTest {

    private  BinaryTree<Integer> binaryTree = new BinaryTree<>();

    @BeforeEach
    void setup() {
        binaryTree = new BinaryTree<>();
        List.of(10, 5, 15, 7, 4, 20, 13, 1, 25, 30).forEach(binaryTree::add);
    }

    @Test
    @DisplayName("Deveria deletar um último dado dentro da árvore binária - a folha.")
    void testDeleteLeaf() {
        boolean result = binaryTree.delete(30);

        assertTrue(result);
        assertNull(binaryTree.find(30));
    }

    @Test
    @DisplayName("Deveria deletar node com um filho")
    void testDeleteNodeWithOneChild() {
        assertTrue(binaryTree.delete(25));
        assertEquals(30, binaryTree.find(30).getData());
        assertNull(binaryTree.find(25));
    }

    @Test
    @DisplayName("Deveria deletar node com dois filho")
    void testDeleteNodeWithTwoChildren() {
        assertTrue(binaryTree.delete(15));
        assertNull(binaryTree.find(15));
        assertEquals(List.of(1, 4, 5, 7, 10, 13, 20, 25, 30), binaryTree.inOrder(10));
    }

    @Test
    @DisplayName("Deveria deletar a raiz, alterando raiz para maior (direita) do menor (esquerda)")
    void testDeleteRoot() {
        assertTrue(binaryTree.delete(10));
        assertNull(binaryTree.find(10));
        assertEquals(13, binaryTree.getRoot());
        assertEquals(List.of(1, 4, 5, 7, 13, 15, 20, 25, 30), binaryTree.inOrder(binaryTree.getRoot()));
    }

    @Test
    @DisplayName("Não deveria excluir um node que não existe, retornando falso")
    void testShouldNotDeleteNodeThatDoesNotExist() {
        assertFalse(binaryTree.delete(999));
    }

    @Test
    @DisplayName("Deveria deletar todos os nodes")
    void testDeleteAllNodes(){
        List.of(10, 5, 15, 7, 4, 20, 13, 1, 25, 30).forEach(binaryTree::delete);
        assertEquals(0, binaryTree.getDegreeOfNo());
    }

    @Test
    @DisplayName("Deveria deletar todos os nodes")
    void testDeleteFromEmptyTree(){
        BinaryTree<Integer> emptyTree = new BinaryTree<>();
        assertFalse(emptyTree.delete(0));
        assertEquals(0, emptyTree.getDegreeOfNo());
    }






}