package cap02_Vetores_Listas_e_Ordenacao_Selecao.Ordenacao_Selecao;

import cap02_Vetores_Listas_e_Ordenacao_Selecao.ObjectClient.Client;
import java.util.Arrays;

/**
 * Algoritmo de Ordenação: Selection Sort (Ordenação por Seleção)
 * O Selection Sort baseia-se em buscas sequenciais sucessivas para organizar os elementos. Ou seja, é efetuado passagens
 * sucessivas na estrutura de dados para ordenar sequencialmente.
 * Portanto, O Selection Sort é um método de ordenação por seleção. Em uma ordenação crescente, a ordenação por seleção
 * percorre a lista em busca do menor valor e o move para a posição correta precedido sempre do elemento de menor valor.
 * * Funcionamento Passo a Passo:
 * Define-se uma posição inicial (ex: índice 0) como o ponto de partida.
 * Percorre-se o restante do array comparando o elemento da posição atual com os demais.
 * Ao encontrar o menor valor de todo o trecho percorrido, este é trocado de lugar
 * com o elemento da posição inicial.
 * Avança-se para a próxima posição (índice 1) e repete-se o processo até o fim do array.
 * <br>
 * * Características:
 * Complexidade: Possui complexidade O(n^2)
 * In-place: Realiza a ordenação diretamente no array original, economizando memória.
 */

public class MainSelectionSort {
    public static void main(String[] args) {

        //Exercicio 1: Implemente selection sort
        Integer[] arrayInteiros = new Integer[10];
        for(int i = 0; i < arrayInteiros.length; i++){
            arrayInteiros[i] = (int) (Math.random() * 10);
        }
        System.out.println("Array de números inteiros não ordenado: ");
        Arrays.stream(arrayInteiros).forEach(x -> System.out.print(x + " - "));

        System.out.println("\nArray de números inteiros Ordenado Pelo Selection Sort:");
        SelectionSort.selectionSort(arrayInteiros);
        Arrays.stream(arrayInteiros).forEach(x -> System.out.print(x + " - "));


        //Exercicio 2: Ordene uma lista de Strings.
        String[] array = new String[5];
        array[0] = "Pedro";
        array[1] = "Ana";
        array[2] = "Cassio";
        array[3] = "Dilma";
        array[4] = "Bianca";
        System.out.println("\n\nArray de String não ordenado: ");
        Arrays.stream(array).forEach(x -> System.out.print(x + " - "));

        System.out.println("\nArray de Nomes Ordenado Pelo Selection Sort:");
        SelectionSort.selectionSort(array);
        Arrays.stream(array).forEach(x -> System.out.print(x + " - "));


        //Exercicio 3: Ordene objetos Cliente por idade.
        Client[] clients = new Client[5];
        clients[0] = new Client("123", "Pedro", 23);
        clients[1] = new Client("456", "Ana", 14);
        clients[2] = new Client("789", "Cassio", 34);
        clients[3] = new Client("987", "Dilma", 41);
        clients[4] = new Client("076", "Bianca", 18);
        System.out.println("\n\nArray de Clientes não ordenado: ");
        Arrays.stream(clients).forEach(x -> System.out.print(x + " - "));

        System.out.println("\nArray de Clientes Ordenado por idade pelo Selection Sort:");
        SelectionSort.selectionSort(clients);
        Arrays.stream(clients).forEach(x -> System.out.print(x + " - "));

    }
}
