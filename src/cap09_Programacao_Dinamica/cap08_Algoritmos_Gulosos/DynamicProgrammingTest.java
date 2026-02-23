package cap09_Programacao_Dinamica.cap08_Algoritmos_Gulosos;

import cap09_Programacao_Dinamica.cap08_Algoritmos_Gulosos.Itens.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingTest {

    private ArrayList<Item> items = new ArrayList<>(List.of(
            new Item("Notebook", 2000, 3),
            new Item("Headset", 500, 1),
            new Item("Livro Técnico", 800, 2),
            new Item("Mouse Gamer", 400, 1)));


    @Test
    @DisplayName("Deve retornar uma list de items com valor máximo que é possível carregar sem ultrapassar 6kg")
    void knapsack() {
        List<Item> knapsack = DynamicProgramming.knapsack(6, items);

        List<Item> result = new ArrayList<>(List.of(
                new Item("Notebook", 2000, 3),
                new Item("Headset", 500, 1),
                new Item("Livro Técnico", 800, 2)));

        assertEquals(result, knapsack);
        assertEquals(3, knapsack.size());
    }
    @Test
    @DisplayName("Deve retornar uma IllegalArgumentException quando o capacidade é menor que um")
    void shouldThrowExceptionWhenCapacityIsLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DynamicProgramming.knapsack(0, items));
        assertEquals("Invalid argument, the capacity and the list of items must be greater than one.", exception.getMessage());
    }
    @Test
    @DisplayName("Deve retornar uma IllegalArgumentException quando a lista de itens é menor que um")
    void shouldThrowExceptionWhenItensIsLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DynamicProgramming.knapsack(0, List.of()));
        assertEquals("Invalid argument, the capacity and the list of items must be greater than one.", exception.getMessage());
    }


    @Test
    @DisplayName("Deve retornar uma sequencia de caracteres comum")
    void lcs() {
        String a = "ABCDGH";
        String b = "AEDFHR";

        String result = DynamicProgramming.lcs(a, b);

        assertEquals("ADH", result);
    }
    @Test
    @DisplayName("Deve retornar uma IllegalArgumentException quando uma das String é vazia ou null")
    void shouldThrowExceptionWhenSomeStringIsEmptyOrNull() {
        String StringEmpty = "";
        String StringNull = null;
        String b = "AEDFHR";

        Exception exceptionStringEmpty = assertThrows(IllegalArgumentException.class, () -> DynamicProgramming.lcs(StringEmpty, b));
        Exception exceptionStringNull  = assertThrows(IllegalArgumentException.class, () -> DynamicProgramming.lcs(StringNull, b));

        assertEquals("Invalid argument, the String a and String b must be different from null or empty.", exceptionStringEmpty.getMessage());
        assertEquals("Invalid argument, the String a and String b must be different from null or empty.", exceptionStringNull.getMessage());
    }
    @Test
    @DisplayName("Deve retornar uma String vazia quando não há nenhuma caracter em comum")
    void shouldReturnEmptyStringWhenThereIsNoCommonString() {
        String a = "GHIJKL";
        String b = "ABCDEF";

        String result = DynamicProgramming.lcs(a, b);

        assertTrue(result.isEmpty());
    }

}