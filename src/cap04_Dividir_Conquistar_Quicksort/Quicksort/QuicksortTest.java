package cap04_Dividir_Conquistar_Quicksort.Quicksort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuicksortTest {

    @Test
    @DisplayName("Deve ordenar array de números inteiros")
    void quicksort() {
        Integer[] arrayInteger = {3, 0, 2, 1, 4, 7, 6, 3, 33, 20, 5, 8};
        Integer[] arrayOrdered = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 20, 33};

        Quicksort.quicksort(arrayInteger);

        assertArrayEquals(arrayOrdered, arrayInteger);
    }

    @Test
    @DisplayName("Deve ordenar um array com elementos repetidos")
    void shouldSortArrayWithDuplicates() {
        Integer[] duplicatedArray = {5, 2, 8, 2, 5, 1};
        Integer[] expected = {1, 2, 2, 5, 5, 8};

        Quicksort.quicksort(duplicatedArray);
        assertArrayEquals(expected, duplicatedArray);
    }

    @Test
    @DisplayName("Não deve alterar um array que já está ordenado")
    void shouldNotChangeAlreadySortedArray() {
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        Quicksort.quicksort(sortedArray);
        assertArrayEquals(expected, sortedArray);
    }

    @Test
    @DisplayName("Deve lidar com array de um único elemento")
    void shouldHandleSingleElementArray() {
        Integer[] singleElementArray = {50};
        Integer[] expected = {50};
        Quicksort.quicksort(singleElementArray);
        assertArrayEquals(expected, singleElementArray);
    }

    @Test
    @DisplayName("Deve lidar com array vazio")
    void shouldHandleEmptyArray() {
        Integer[] emptyArray = {};
        Integer[] expected = {};
        Quicksort.quicksort(emptyArray);
        assertArrayEquals(expected, emptyArray);
    }

    @Test
    @DisplayName("Deve lidar com array nulo")
    void shouldHandleNullElements() {
        Integer[] arrayNull = null;
        Exception exception = assertThrows(NullPointerException.class, () -> Quicksort.quicksort(arrayNull));
        assertEquals(exception.getMessage(), "Array cannot be null");
    }

    @Test
    @DisplayName("Deve ordenar corretamente números negativos")
    void shouldSortNegativeNumbers() {
        Integer[] negativeArray = {-5, -1, -10, -3};
        Integer[] expected = {-10, -5, -3, -1};
        Quicksort.quicksort(negativeArray);
        assertArrayEquals(expected, negativeArray);
    }



}