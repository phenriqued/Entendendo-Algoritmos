package cap04_Dividir_Conquistar_Quicksort.Dividir_Conquistar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideConquerTest {

    private Integer[] array = {1, 2, 10, 4, 5};

    @Test
    @DisplayName("Deve somar todos os números inteiros de um array")
    void sum() {
        int result = DivideConquer.sum(array);
        assertEquals(result, 22);
    }
    @Test
    @DisplayName("Deve somar todos os números inteiros de um array")
    void somaArrayTamanho1() {
        Integer[] littleArray = {10};
        Integer result = DivideConquer.sum(littleArray);
        assertEquals(result, 10);
    }

    @Test
    @DisplayName("Deve retornar o maior número de um array de inteiros")
    void bigger() {
        Integer result = DivideConquer.bigger(array);
        assertEquals(result, 10);
    }
}