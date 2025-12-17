package cap04_Dividir_Conquistar_Quicksort.Dividir_Conquistar;

import extra_Outros_Algoritmos_Ordenacao.Merge_Sort.MergeSort;
import java.util.Arrays;

/**
 * Dividir e Conquista é um paradigma de algoritmo baseado em recursão. Assim, os algoritmos baseados em DC são recursivos,
 * o paradigma de dividir e conquistar consiste em dado um problema subdividir este em problemas menores até seu caso-base
 * e dado a resolução de cada subproblema combinar a soluções deste para resolver o problema inicial. Ou seja, dividir para conquistar
 * resolve subproblemas recursivamente, onde cada subproblema é menor que o problema original, onde cada subproblema em um momento existirá
 * um caso-base, uma resolução, e dado a solução para o subproblema o mesmo inicia-se a combinação de cada solução de cada subproblema até a
 * solução final problema original.
 * A resolução segue três etapas fundamentais:
 * 1. Dividir: o problema e problemas menores (subproblemas)
 * 2. Conquistar: Resolver os subproblemas recursivamente.
 * 3. Combinar: Unir as soluções para resolver o problema original.
 */

public class MainDivideConquer {
    public static void main(String[] args) {
        //Exercicio 1: Aplique a estratégia da divisão e conquista ao problema de calcular a soma dos elementos de um vetor A[1..n] de números inteiros.
        // Estime o consumo de tempo do algoritmo.
        Integer[] array = {3, 2, 5, 7, 4, 8, 9, 1, 10, 6};
        long end;
        long start = System.currentTimeMillis();
        int result = DivideConquer.sum(array);
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução utilizando Dividir para conquistar: "+ (end - start)+ "\nResultado da soma: "+result);

        //Exercicio 2: Escreva um algoritmo de divisão e conquista para encontrar o valor de um elemento máximo de um vetor A[p..r] de números inteiros.
        System.out.println("\nO maior inteiro do array é: "+ DivideConquer.bigger(array));

        //Exercicio 3: Implemente o algoritmo de ordenação de números inteiro utilizando o MERGESORT
        System.out.println("\n\nArray Inteiros desordenado: ");
        Arrays.stream(array).forEach(x -> System.out.print(x + " - "));
        MergeSort.mergesort(array);
        System.out.println("\n\nArray Inteiros Ordenado utilizando MERGE SORT: ");
        Arrays.stream(array).forEach(x -> System.out.print(x + " - "));



    }

}
