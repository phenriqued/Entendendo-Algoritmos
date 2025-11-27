package cap01_Busca_Binaria;

/*
A Pequisa Binária é um algoritmo de busca que utiliza como estrátegia de divisão de metades até encontrar o
elemento, caso o mesmo não se encontre retorna NULL, está busca ocorre dentro de um lista ORDENADA.
Portanto, a pesquisa binária é uma forma de otimizar a busca de um elemento, onde está pesquisa é feita dividindo
a quantidade de dados pela metade repetidamente até o encontro do elemento buscado.
Consiste em: Pegar o tamanho total da lista e encontrar o CENTRO -> Comparando o valor central com o valor que deseja encontrar
    -> Caso não sejam diferentes, o valor é comparado, SE o valor buscado for menor todas as posições maiores que o centro e descartada
    SE o valor buscado for maior, todas as posições menores são descartas -> O processo se repete até encontrar o valor Buscando.

Em questão de anotação Big O a pesquisa bbinária é expressa pela anotação O(Log n)
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
