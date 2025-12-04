package cap02_Vetores_Listas_e_Ordenacao_Selecao.Ordenacao_Selecao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    @DisplayName("Deve ordenar um array de números inteiros")
    void selectionSort() {
        Integer[] arrayDesordenado = {10, 8, 9, 7, 5, 6, 4, 3, 2, 1};
        Integer[] arrayOrdenado = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SelectionSort.selectionSort(arrayDesordenado);
        assertArrayEquals(arrayDesordenado, arrayOrdenado);
    }
    @Test
    @DisplayName("Deve ordenar um array com elementos repetidos")
    void shouldSortArrayWithDuplicates() {
        Integer[] duplicatedArray = {5, 2, 8, 2, 5, 1};
        Integer[] expected = {1, 2, 2, 5, 5, 8};
        SelectionSort.selectionSort(duplicatedArray);
        assertArrayEquals(expected, duplicatedArray);
    }

    @Test
    @DisplayName("Não deve alterar um array que já está ordenado")
    void shouldNotChangeAlreadySortedArray() {
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        SelectionSort.selectionSort(sortedArray);
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    @DisplayName("Deve lidar com array de um único elemento")
    void shouldHandleSingleElementArray() {
        Integer[] singleElementArray = {50};
        Integer[] expected = {50};
        SelectionSort.selectionSort(singleElementArray);
        assertArrayEquals(expected, singleElementArray);
    }

    @Test
    @DisplayName("Deve lidar com array vazio")
    void shouldHandleEmptyArray() {
        Integer[] emptyArray = {};
        Integer[] expected = {};
        SelectionSort.selectionSort(emptyArray);
        assertArrayEquals(expected, emptyArray);
    }

    @Test
    @DisplayName("Deve lidar com elementos nulos no meio (Se a implementação permitir)")
    void shouldHandleNullElements() {
        Integer[] arrayWithNulls = null;
        assertThrows(IllegalArgumentException.class, () -> SelectionSort.selectionSort(arrayWithNulls));
    }

    @Test
    @DisplayName("Deve ordenar corretamente números negativos")
    void shouldSortNegativeNumbers() {
        Integer[] negativeArray = {-5, -1, -10, -3};
        Integer[] expected = {-10, -5, -3, -1};
        SelectionSort.selectionSort(negativeArray);
        assertArrayEquals(expected, negativeArray);
    }
}