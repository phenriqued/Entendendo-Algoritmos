package cap04_Dividir_Conquistar_Quicksort.Dividir_Conquistar;


public class DivideConquer {

    public static int sum(int[] array){
        if (array.length == 1) return array[0];
        return array[0] + sum(array, 1);
    }
    private static int sum(int[] array, int indice){
        if (indice == array.length -1) return array[indice];
        int x = array[indice];
        indice += 1;
        return x + sum(array, indice);
    }

    public static int bigger(int[] array){
        if(array.length == 1) return array[0];
        return bigger(array, array[0], 0);
    }
    private static int bigger(int[] array, int big, int index){
        if(index >= array.length - 1) return big;
        index += 1;
        if(big > array[index]){
            return bigger(array, big, index);
        }
        return bigger(array, array[index], index);
    }




}
