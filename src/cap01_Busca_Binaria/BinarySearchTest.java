package cap01_Busca_Binaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

class BinarySearchTest {

    int[] arrayInt = new int[10];

    @BeforeEach
     void setup(){
        for (int i = 0; i<arrayInt.length; i++){
            arrayInt[i] = i+1;
        }
    }

    @Test
    @DisplayName("Deve retornar o número que equivale ao valor buscado dentro de um array de inteiros ordenados utilizando pesquisa binaria")
    void shouldReturnSearchedNumberUsingBinarySearch() {
        var result = BinarySearch.binarySearchInt(arrayInt, 9);
        assertEquals(9, result);
    }
    @Test
    @DisplayName("Deve retornar NULL quando procura um valor inexistente dentro array utilizando busca binária")
    void shouldReturnNullWhenSearchedValueNotExistInArray() {
        assertNull(BinarySearch.binarySearchInt(arrayInt, 50));
    }

    @Test
    @DisplayName("Deve retornar o número que equivale ao valor buscado dentro de um array de inteiros ordenados utilizando recursividade de pesquisa binaria")
    void shouldReturnSearchedNumberUsingRecursiveBinarySearchInt() {
        var result = BinarySearch.recursiveBinarySearchInt(0, arrayInt.length- 1, arrayInt, 9);
        assertEquals(9, result);
    }
    @Test
    @DisplayName("Deve retornar NULL quando procura um valor inexistente dentro array utilizando busca binária")
    void shouldReturnNullWhenSearchedValueNotExistInArrayUseRecursiveBinarySearch() {
        assertNull(BinarySearch.recursiveBinarySearchInt(0, arrayInt.length -1, arrayInt, 50));
    }

    @Test
    @DisplayName("Deve retornar index de onde o valor buscado está localizado dentro de um array ordenado utilizando busca binária")
    void shouldReturnIndexOfAGivenNumberInSortedArray(){
        var result = BinarySearch.searchIndexUsingBinarySearch(arrayInt, 9);
        assertEquals(8, result);
    }
    @Test
    @DisplayName("Deve retornar -1 quando o valor buscado não foi localizado dentro do array")
    void shouldReturnNegativeOneWhenSearchValueNotExistInArray(){
        var result = BinarySearch.searchIndexUsingBinarySearch(arrayInt, 99);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Deve retornar a quantidade de passos que uma pesquisa binária efetua para achar um valor")
    void shouldReturnNumberOfStepsBinarySearchOerforms(){
        var result = BinarySearch.binarySearchPerformance(arrayInt, 1);
        assertEquals(3, result);
    }


}