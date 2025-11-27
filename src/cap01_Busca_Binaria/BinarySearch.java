package cap01_Busca_Binaria;

public class BinarySearch {

    //Função Binária iterativa levando em consideração um array de número inteiros ordenados.
    public static Object binarySearchInt(int[] arrayInt, int valueSought){
        int start = 0;
        int end = arrayInt.length - 1;

        while (start <= end){
            int half = (start + end) / 2;
            int value = arrayInt[half];
            if(value == valueSought){
                return value;
            } else if (value > valueSought) {
                // inicio = meio
                end = half - 1;
            }else {
                // inicio = meio
                start = half + 1;
            }
        }
        return null;
    }

    //Função Binária recursiva levando em consideração um array de número inteiros ordenados.
    public static Object recursiveBinarySearchInt(int start, int end, int[] arrayInt, int valueSought){
        int half = (start + end) / 2;
        int value = arrayInt[half];
        if (start > end) return null;
        if(value == valueSought){
            return value;
        } else if (value > valueSought) {
            return recursiveBinarySearchInt(start, half - 1, arrayInt, valueSought);
        }else{
            return recursiveBinarySearchInt(half + 1, end, arrayInt, valueSought);
        }
    }

    //Procurar onde está o indice utilizando Busca binaria
    public static int searchIndexUsingBinarySearch(int[] arrayInt, int valueSought){
        int start = 0;
        int end = arrayInt.length - 1;
        while (start <= end){
            int half = (start + end) / 2;
            int value = arrayInt[half];
            if(value == valueSought){
                return half;
            } else if (value > valueSought) {
                end = half - 1;
            }else {
                start = half + 1;
            }
        }
        return -1;
    }

    //Contar a perfomace de uma busca binaria pela quantidade de passo que a mesma efetua
    public static int binarySearchPerformance(int[] arrayInt, int valueSought){
        int steps = 0;
        int start = 0;
        int end = arrayInt.length - 1;
        while (start <= end){
            steps += 1;
            int half = (start + end) / 2;
            int value = arrayInt[half];
            if(value == valueSought){
                break;
            } else if (value > valueSought) {
                end = half - 1;
            }else {
                start = half + 1;
            }
        }
        return steps;
    }


}
