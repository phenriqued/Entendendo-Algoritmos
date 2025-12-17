package cap04_Dividir_Conquistar_Quicksort.Quicksort;

import java.util.Arrays;

 /**
 *    O Quicksort é um algoritmo de ordenação baseado no paradigma Dividir para conquistar, este funciona assim:
 *    1 - Faz a escolha de um elemento de um array por exemplo, denominado de *pivô*
 *    2 - A partir do pivô escolhido é feita ordenação de todos elementos menores que o pivô ficam a esquerda e todos elementos
 *       maiores que pivô ficam a direita, assim, dividindo-se em dois arrays, um com todos elementos menores que pivô e outro
 *       com todos elementos maiores que o pivô
 *   3 - então de forma recursiva é feito novamente a partir de um pivô de um novo sub-array, até chegar o caso-base de tem um array
 *       com apenas dois elementos
 *   4 - Subsequente, inicia-se a combinação de cada sub-array previamente ordenado, para no final voltar o primeiro pivô com
 *      o array a esquerda (elementos menores) ordenados, assim como o array da direita (Elementos maiores).
 *      <br>
 *  A complexidade do Quicksort depende do elemento pivô, em caso médio/melhor sua complexidade de tempo é de O(n log n) que
 *  ocorre quando o pivo divide o array em duas parte iguais, é no pior caso possível ocorre quando o pivô não divide de forma
 *  igualitária o array, levando a uma complexidade quadratica.
 */

public class MainQuicksort {
    public static void main(String[] args) {

        //Exercicio 1: Implemente Quicksort utilizando generics
        Integer[] arrayInteger = {3, 0, 2, 1, 4, 7, 6, 3, 33, 20, 5, 8};
        Arrays.stream(Quicksort.quicksort(arrayInteger)).forEach(x -> System.out.print(x + " - "));

        System.out.println("\nArray de String:");
        String[] arrayString = {"Pedro", "Ana", "Fabricio", "Caio", "Dalmo", "Bianca", "Estevan"};
        Arrays.stream(Quicksort.quicksort(arrayString)).forEach(x -> System.out.print(x + " - "));

    }
}
