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

public class BinarySearchConcept {

    //Função Binária levando em consideração um array de número inteiros ordenados.
    public static Object binarySearchInt(int[] arrayInt, int valueSought){
        int start = 0;
        int end = arrayInt.length - 1;

        while (start <= end){
            int half = (start + end) / 2;
            int value = arrayInt[half];
            if(value == valueSought){
                return half;
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


    public static Object recursiveBinarySearchInt(int start, int end, int[] arrayInt, int valueSought){
        int half = (start + end) / 2;
        int value = arrayInt[half];
        if(value == valueSought){
            return value;
        } else if (value > valueSought) {
            return recursiveBinarySearchInt(start, half - 1, arrayInt, valueSought);
        }else {
            return recursiveBinarySearchInt(half + 1, end, arrayInt, valueSought);
        }
    }


}
