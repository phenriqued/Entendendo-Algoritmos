package cap02_Vetores_Listas_e_Ordenacao_Selecao.Ordenacao_Selecao;

import cap02_Vetores_Listas_e_Ordenacao_Selecao.ObjectClient.Client;
import java.util.Arrays;

/*
    Selection Sort ou Ordenação por Seleção é um algoritmo de ordenação que utiliza a pesquisa sequêncial para efetuar a
    ordenação, ou seja, é efetuado passagens sucessivas na estrutura de dados para ordenar sequencialmente.
    Portanto, O Selection Sort é um método de ordenação por seleção. Em uma ordenação crescente, a ordenação por seleção
    percorre a lista em busca do menor valor e o move para a posição correta precedido sempre do elemento de menor valor.

    O algoritmo de Ordenação por seleção funciona da seguinte maneira - Primeiro dentro de um array por exemplo, é escolhido o primeiro
    indice do array, a partir do elemento do indice 0 do array é comparado com os demais que seguem no array a partir do indice seguinte do primeiro elemento.
    Em uma ordenação crescente, quando comparado com um valor menor que o primeiro escolhido, este então ocupa a posição do menor elemento encontrado. Então,
    a partir do elemento encontrado continua a procura para um elemento menor, caso não encontrado, ele ocupa o indice zero ou a primeira posição vetor. O próximo
    indice, no caso (indice 1) é escolhido para fazer as comparações. É repetido esse processo até que a lista esteja ordenada de forma crescente.
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
