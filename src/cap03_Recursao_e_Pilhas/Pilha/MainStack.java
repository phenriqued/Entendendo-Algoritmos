package cap03_Recursao_e_Pilhas.Pilha;

/**
 * Estrutura de Dados: Pilha (Stack)
 * A Pilha opera sob o princípio LIFO (Last In, First Out), o que significa que o último elemento a entrar é
 * obrigatoriamente o primeiro a sair.
 * * Operações Principais:
 * Push: Adiciona um elemento ao topo da pilha (ex: colocar um prato sujo na pilha).</li>
 * Pop: Remove o elemento do topo (ex: retirar o prato de cima para lavar).</li>
 * *
 * * Relação com a Recursão:
 * A pilha é o mecanismo fundamental por trás da recursividade. Cada vez que uma função chama
 * a si mesma, o Java cria um novo "frame" na Stack de Execução.
 * As chamadas vão sendo "empilhadas" (Push) sucessivamente.
 * Ao atingir o Caso Base, a última função chamada é a primeira a ser resolvida e
 * removida da pilha (Pop).
 * Atenção: Caso o Caso-Base não seja alcançado, a pilha cresce indefinidamente
 * até causar um {@link StackOverflowError} (estouro da pilha).
 */

public class MainStack {

    public static void main(String[] args) {

        //Exercicio 1: Implemente uma pilha generica do zero usando array.
        Stack<String> stack = new Stack<>(3);
        System.out.println("Tamanho da pilha de String: "+stack.size());
        stack.pop("Elemento 1");
        stack.pop("Elemento 2");
        stack.pop("Elemento 3");
        System.out.println("Pilha está cheia? - "+ stack.isFull());
        System.out.println("Retirando Ultimo elemento da pilha: "+ stack.push());
        System.out.println("Pegando novo Ultimo elemento da pilha: "+ stack.peek());

        Stack<Integer> stackInteger = new Stack<>(5);
        System.out.println("\nTamanho da pilha de Integer: "+stackInteger.size());
        stackInteger.pop(1);
        stackInteger.pop(2);
        System.out.println("Pilha está cheia? - "+ stackInteger.isFull());
        System.out.println("Retirando Ultimo elemento da pilha: "+ stackInteger.push());
        System.out.println("Pegando novo Ultimo elemento da pilha: "+ stackInteger.peek());
    }
}
