package cap03_Recursao_e_Pilhas.Recursao;

/**
 * Recursão Ocorre quando um método chama a si mesmo. Na prática, funciona de forma análoga
 * a uma estrutura de repetição {@code while}, mas utilizando a pilha de execução.
 * * Exemplo Comparativo:
 * // Abordagem Iterativa (while)
 * int i = 10;
 * while(i >= 1) {
 * System.out.println(i--);
 * }
 * * // Abordagem Recursiva
 * public static void contagem(int i) {
 * if (i >= 1) {           // Caso Recursivo
 * System.out.println(i);
 * contagem(i - 1);
 * } else {                // Caso Base
 * return;
 * }
 * }
 * <br>
 * * Conceitos Chaves:
 * Caso Base: A condição de parada que interrompe as chamadas e evita o {@link StackOverflowError}.</li>
 * Caso Recursivo: O momento em que a função invoca a si mesma para resolver uma parte menor do problema.</li>
 * <br>
 *Nota de Performance: A recursividade é poderosa para algoritmos de "Dividir e Conquistar",
 * mas cada chamada consome memória na Stack (Pilha). Chamadas excessivamente profundas
 * podem esgotar a memória disponível.
 */
public class MainRecursao {
    public static void main(String[] args) {
        //Exercício 1: Crie uma função recursiva que receba como entrada um número inteiro não negativo N e retorne o seu fatorial.
        int n = 5;
        System.out.println("Fatorial de "+ n +" é: "+ Recursao.fatorialRecursivo(n));

        //Exercício 2: Crie uma função recursiva que receba um número inteiro n (índice na sequência, começando em 0)
        // e retorne o valor do n-ésimo número da Sequência de Fibonacci.
        int fibonacci = 3;
        System.out.println("Fibonacci de "+ fibonacci +" é: "+ Recursao.fibonacciRecursivo(fibonacci));
    }

}
