package cap02_Vetores_Listas_e_Ordenacao_Selecao.Ordenacao_Selecao;

public class SelectionSort {
    /**
     * Implementa o algoritmo Selection Sort usando um Comparable.
     * @param <T> O tipo dos elementos.
     * @param array O array a ser ordenado.
     * @return O array ordenado.
     */
    public static <T extends Comparable<T>> T[] selectionSort(T[] array){
        if(array == null || array.length < 2) {
            if (array == null) throw new IllegalArgumentException("It is not possible to sort an array that has a size less than 2.");
            return array;
        }

        for(int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for(int j = i+1; j <array.length; j++){
                if(array[j].compareTo(array[minIndex]) < 0){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                T swap = array[i];
                array[i] = array[minIndex];
                array[minIndex] = swap;
            }
        }
        return array;
    }

}
