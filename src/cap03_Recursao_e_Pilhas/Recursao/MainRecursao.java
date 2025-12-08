package cap03_Recursao_e_Pilhas.Recursao;

/*
    Recursão é quando uma função chama a si mesmo. Na teoria é "parecido" com a estrutura de repetição *while()*, um exemplo
    prático é um programa que imprima uma contagem regressiva de 10 a 0, utilizando a estrutura de repetição seria algo como:
        int i = 10;
        while(i >= 1){
            System.out.println(i);
            i--;
        }
    Utilizando recursividade ficaria assim:
        public static void main(String[] args) {
            int i = 10;
            recursividade(i);
        }
        public static void recursividade(int i){
            if(i >= 1){ //*Caso recursivo*
                System.out.println(i);
                recursividade(i-1);
            }else { //*Caso Base*
                return;
            }
        }

    Toda função recursiva tem o Caso Recursivo que é o caso que vai chamar a si mesmo e o Caso Base que é a codição para retornar
    e parar de chamar a si mesmo, evitando assim (no Java) um StackOverflowException.

    A recursividade é um conceito bastante importante para otimização de algumas estruturas de dados e para construção de algoritmos,
    contudo é importante entender que para cada recursão utiliza-se da memória (Pilha ou Stack), ou seja, salvar todas infomarções de cada
    caso recursivo pode ocupar muita memória
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
