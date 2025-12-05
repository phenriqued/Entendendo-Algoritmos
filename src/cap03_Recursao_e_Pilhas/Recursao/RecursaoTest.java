package cap03_Recursao_e_Pilhas.Recursao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursaoTest {

    @Test
    @DisplayName("Deve retornar o fatorial do número inteiro dada a função")
    void fatorialRecursivo() {
        int n = 5;
        int result = Recursao.fatorialRecursivo(n);
        assertEquals(120, result);
    }

    @Test
    @DisplayName("Deve retornar uma exception quando dado um valor negativo para função Fatorial")
    void fatorialRecursivoQuandoDadoNumeroInteiroMenorQueZero() {
        int n = -1;
        assertThrows(IllegalArgumentException.class,  () -> Recursao.fatorialRecursivo(n));
    }


    @Test
    @DisplayName("Deve retornar o retorne o valor do n-ésimo número da Sequência de Fibonacci.")
    void fibonacciRecursivo() {
        int n = 5;
        int result = Recursao.fibonacciRecursivo(n);
        assertEquals(5, result);
    }
    @Test
    @DisplayName("Deve retornar uma exception quando dado um valor negativo para função Fibonacci")
    void fibonacciRecursivoQuandoDadoNumeroNegativoLancaException() {
        int n =-1;
        assertThrows(IllegalArgumentException.class,  () -> Recursao.fibonacciRecursivo(n));
    }




}