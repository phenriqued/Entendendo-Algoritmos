package cap04_Dividir_Conquistar_Quicksort.Quicksort;

import java.util.Objects;

public class Quicksort {

    public static <T extends Comparable<T>>T[] quicksort(T[] array){
        if(Objects.isNull(array)) throw new NullPointerException("Array cannot be null");
        return quicksort(array, 0, array.length);
    }

    public static <T extends Comparable<T>>T[] quicksort(T[] array, int fromIndex, int toIndex){
        if(fromIndex + 1 >= toIndex) return array;
        int pivoIndex = partition(array, fromIndex, toIndex);
        quicksort(array, fromIndex, pivoIndex);
        quicksort(array, pivoIndex + 1, toIndex);
        return array;
    }

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
