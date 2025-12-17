package cap04_Dividir_Conquistar_Quicksort.Quicksort;

import java.util.Objects;

public class Quicksort {
    /**
     * Implementa o algoritmo Quick Sort usando um Comparable.
     * @param <T> O tipo dos elementos.
     * @param array O array a ser ordenado.
     */
    public static <T extends Comparable<T>>T[] quicksort(T[] array){
        if(Objects.isNull(array)) throw new NullPointerException("Array cannot be null");
        return quicksort(array, 0, array.length);
    }

    /**
     * Implementa o algoritmo Merge Sort usando um Comparable.
     * @param <T> O tipo dos elementos.
     * @param array O array a ser ordenado.
     * @param fromIndex o index inicial do array a ser ordenado.
     * @param toIndex  o index final do array a ser ordenado.
     * Caso-base é o index inicial ser maior que o index final, representando que não há mais nenhum elemento para o caso recursivo
     * Partition é feito a ordenação do array a partir de um PIVO, inserido elementos menores a esquerda e maiores a direita, não necessariamente
     * em ordem.
     * Caso-recursivo é quando há ao mais de dois elementos dentro do array
     */
    public static <T extends Comparable<T>>T[] quicksort(T[] array, int fromIndex, int toIndex){
        if(fromIndex + 1 >= toIndex) return array;
        int pivoIndex = partition(array, fromIndex, toIndex);
        quicksort(array, fromIndex, pivoIndex);
        quicksort(array, pivoIndex + 1, toIndex);
        return array;
    }

    /**
     * Implementa o algoritmo Partição (Partition) usando um Comparable.
     * @param <T> O tipo dos elementos.
     * @param array O array a ser ordenado.
     * @param fromIndex o index inicial do array a ser ordenado.
     * @param toIndex  o index final do array a ser ordenado.
     * A partir de um PIVO (inicial, ou seja, elemento inicial do @param array) todos elementos até toIndex é comparado com
     * PIVO sendo inserido na frente deste, por fim o PIVO faz a troca com o ultimo elemento menor que ele mesmo, assim, todos elementos
     * menores que PIVO ficam a esquerda e os maiores a direita
     */
    private static <T extends Comparable<T>>int partition(T[] array, int fromIndex, int toIndex){
        if(fromIndex >= toIndex) return -1;
        T pivo = array[fromIndex];
        int j = fromIndex;
        T aux;
        for(int i = fromIndex; i < toIndex; i++){
            if(pivo.compareTo(array[i]) > 0 && i != fromIndex){
                j++;
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        aux = array[j];
        array[j] = pivo;
        array[fromIndex] = aux;
        return j;
    }

}
