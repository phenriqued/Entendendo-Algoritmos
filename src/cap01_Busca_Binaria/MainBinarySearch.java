package cap01_Busca_Binaria;

/**
 * Algoritmo: Pesquisa Binária (Binary Search)
 * A Pequisa Binária é um algoritmo de busca que utiliza como estrátegia de divisão de metades até encontrar o
 * elemento, caso o mesmo não se encontre retorna NULL
 * Requisito fundamental: A lista ou array deve estar obrigatoriamente ORDENADO.

 * Funcionamento:
 * Encontra-se o elemento central (meio) da lista.
 * Compara-se o valor central com o valor buscado:
 * Se forem iguais, a busca termina com sucesso.
 * SE o valor buscado for MENOR, descarta-se toda a metade superior.
 * SE o valor buscado for MAIOR, descarta-se toda a metade inferior.
 * O processo se repete com a metade restante até encontrar o valor ou a lista se esgotar.
 * <br>
 * Análise de Performance:
 * Notação Big O: O(\log n) - Tempo logarítmico.
 * Vantagem: É extremamente mais rápida que a busca linear em grandes volumes de dados.
 */

public class MainBinarySearch {
    public static void main(String[] args) {

        int[] arrayInt = new int[10];

        for (int i = 0; i<arrayInt.length; i++){
            arrayInt[i] = i;
        }
        // Exercicio 1: Implemente a busca binária recursiva e iterativa.
        System.out.println("Iterative Binary Search: " +
                BinarySearch.binarySearchInt(arrayInt, 8));

        System.out.println("Recursive Binary Search: " +
                BinarySearch.recursiveBinarySearchInt(0, arrayInt.length - 1, arrayInt, 8));

        //Exercicio 2: Dado um array ordenado, determine o índice de um número ou retorne -1.
        int number = 3;
        System.out.println("The number " + number + " is at index " +
                BinarySearch.searchIndexUsingBinarySearch(arrayInt, number) + " of the array.");


        //Exercicio 3: Quantos passos a busca binária faz para uma lista de 1 milhão de elementos?
        int[] arrayOneMillion = new int[1000000];

        for (int i = 0; i<arrayOneMillion.length; i++){
            arrayOneMillion[i] = i;
        }
        System.out.println("In a binary search, " +
                BinarySearch.binarySearchPerformance(arrayOneMillion, 1) +" steps are performed");

    }
}
