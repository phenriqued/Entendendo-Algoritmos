package extra_Outros_Algoritmos_Ordenacao.Merge_Sort;

/**
 * Merge Sort é o algoritmo de ordenação por divisões, ou seja, merge sort é um algoritmo que se baseia no paradigma Dividir para Conquistar
 * *{@link MainDivideConquer}. Assim, o problema de ordernar uma estrutura de dados por inteiro se torna em subproblemas com a estrutura
 * diminuindo até que se torne individual. Então, cada subproblema resolvido, isto é, cada estrutura é ordenada e combinada até a estrutura está ordenada por inteira,
 * funcionando assim:
 * 1 - Inicia dividindo-se ao meio de forma recursiva até que não seja mais possivel dividir-se, ou seja, até restar um elemento;
 * 2 - Começa a comparar cada elemento dos arrays temporários para combinar em um único array ordenado
 * 3 - No fim haverá dois sub-arrays temporarios ordenados, de formar cada elemento é comparado e sendo inserido dentro do array resultante, de formar que, ao final das comparações o
 * array resultante estará ordenado.
 */

import java.util.ArrayList;

public class MergeSort {
    /**
     * Implementa o algoritmo Merge Sort usando um Comparable.
     * @param <T> O tipo dos elementos.
     * @param array O array a ser ordenado.
     */
    public static <T extends Comparable<T>> void mergesort(T[] array){
        mergesort(array, 0, array.length-1);
    }

    /**
     * Implementa o algoritmo Merge Sort usando um Comparable.
     * @param <T> O tipo dos elementos.
     * @param array O array a ser ordenado.
     * @param fromIndex o index inicial do array a ser ordenado.
     * @param toIndex  o index final do array a ser ordenado.
     * Caso-base é o index inicial ser maior que o index final, representando que não há mais nenhum elemento para o caso recursivo
     * Caso-recursivo é quando há ao menos dois elementos dentro do array
     */
    public static  <T extends Comparable<T>>void mergesort(T[] array, int fromIndex, int toIndex){
        if (fromIndex >= toIndex) return;
        if(array.length < 2) return;

        int middleIndex = (fromIndex + toIndex) / 2;
        mergesort(array, fromIndex, middleIndex);
        mergesort(array, middleIndex + 1, toIndex);

        merge(array, fromIndex, middleIndex, toIndex);
    }

    /**
     * Implementa o algoritmo Merge Comparable, ou seja, a rotina que combina dois arrays ordenado.
     * @param <T> O tipo dos elementos.
     * @param array O array a ser ordenado.
     * @param fromIndex o index inicial do array a ser ordenado.
     * @param middleIndex o index central do array a ser ordenado.
     * @param toIndex  o index final do array a ser ordenado.
     */
    private static <T extends Comparable<T>> void merge(T[] array, int fromIndex, int middleIndex, int toIndex) {

        int leftArrayLength = middleIndex - fromIndex + 1;
        int rightArrayLength = toIndex - middleIndex;

        ArrayList<T> leftArray = new ArrayList<>();
        ArrayList<T> rightArray = new ArrayList<>();

        for(int i = 0; i < leftArrayLength; i++)
            leftArray.add(array[fromIndex + i]);
        for(int j = 0; j < rightArrayLength; j++)
            rightArray.add(array[middleIndex + j + 1]);

        int i = 0, j = 0;

        int k = fromIndex;
        while (i < leftArrayLength && j < rightArrayLength){
            if (leftArray.get(i).compareTo(rightArray.get(j)) <= 0){
                array[k] = leftArray.get(i);
                i++;
            }else{
                array[k] = rightArray.get(j);
                j++;
            }
            k++;
        }

        while(i < leftArrayLength){
            array[k] = leftArray.get(i);
            i++;
            k++;
        }
        while(j < rightArrayLength){
            array[k] = rightArray.get(j);
            j++;
            k++;
        }
    }

}
