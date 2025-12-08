package cap03_Recursao_e_Pilhas.Pilha;

/*
    Pilha ou Stack (em inglês) é uma estrutura de dados do tipo LIFO (Last In First Out), ou seja, o último a entrar é o primeiro
    a sair.
    Exemplo: na limpeza de pratos, ao inserir (pop) pratos dentro da pia, quando o último prato for inserido em uma pilha vertical de
    pratos sujos, o último a ser inserido é o primeiro a ser removido (push) para ser limpo.
    Ou seja, a Pilha tem duas ações POP (inserir) e PUSH (remover e ler).
    A pilha é fundamental para a *Recursão, isso porque para cada função que é executada no programa que por sua vez chama a si mesma, inicia-se uma
    pilha de execuções da mesma função até que o caso-base seja atigindo com a última função onde a mesma é a primeira a sair da pilha de execuções.
    Por isso, quando não programado corretamente o *caso-base da *Recursão é estourada a exception "StackOverflowException" ou execeção de estouro da pilha em português.
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
