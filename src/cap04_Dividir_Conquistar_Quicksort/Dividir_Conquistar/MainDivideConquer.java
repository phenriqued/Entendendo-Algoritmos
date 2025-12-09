package cap04_Dividir_Conquistar_Quicksort.Dividir_Conquistar;

/*
    Dividir e Conquista é um paradigma de algoritmo baseado em recursão. Assim, os algoritmos baseados em DC são recursivos,
    o paradigma de dividir e conquistar consiste em dado um problema subdividir este em problemas menores até seu caso-base
    e dado a resolução de cada subproblema combinar a soluções deste para resolver o problema inicia.
    Ou seja, dividir para conquistar resolve subproblemas recursivamente, onde cada subproblema é menor que o problema original,
    onde cada subproblema em um momento existirá um caso-base, uma resolução, e dado a solução para o subproblema o mesmo inicia-se
    a combinação de cada solução de cada subproblema até a solução final problema original, algo como:
    1. Dividir o problema e problemas menores (subproblemas)
    2. Conquistar os subproblemas resolvendo-os, quando cada subproblema é pequeno haverá um caso-base uma resolução para o mesmo
    3. Combinar cada solução de cada subproblema para solução final do problema inicial/original

 */

public class MainDivideConquer {
    public static void main(String[] args) {
        //Exercicio 1: Aplique a estratégia da divisão e conquista ao problema de calcular a soma dos elementos de um vetor A[1..n]
        // de números inteiros. Estime o consumo de tempo do algoritmo. Compare o resultado com o consumo de tempo do algoritmo trivial de soma

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++){
            array[i] = i + 1;
        }
        long end;
        long start = System.currentTimeMillis();
        DivideConquer.sum(array);
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução utilizando Dividir para conquistar: "+ (end - start));

        start = System.currentTimeMillis();
        int result = 0;
        for(int i = 0;  i < array.length; i++){
            result += array[i];
        }
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução utilizando Looping for: "+ (end - start));

        //Exercicio 2: Escreva um algoritmo de divisão e conquista para encontrar o valor de um elemento máximo de um vetor A[p..r] de números inteiros.
        System.out.println("O maior inteiro do array é: "+ DivideConquer.bigger(array));



    }

}
