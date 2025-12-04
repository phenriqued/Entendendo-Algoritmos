package cap02_Vetores_Listas_e_Ordenacao_Selecao.VetorELista;

import cap02_Vetores_Listas_e_Ordenacao_Selecao.VetorELista.ImplLinkedList.ImplLinkedList;
import cap02_Vetores_Listas_e_Ordenacao_Selecao.ObjectClient.Client;

import java.util.List;

/*
Array (Vetor) é forma de armazenamento de dados sequencial, é um arranjo unidimensional, que suporta dados do mesmo tipo, ou seja, é homogênea. O array
tem o tamanho prefixado no momento de sua Instanciação  (em linguagem fortemente tipada como o Java) e cada elemento do array é fixado a um indice (posição). Portanto,
o array tem um tamanho fixado na sua Instanciação, cada elemento dentro de um array é fixado a um indice, assim, desempenhando em funções de leitura, contundo obtendo um
desempenho inferior em operações de inserções e deleções.

LinkedList (Lista Ligada) faz o armazenamento de forma aleatória, onde cada dado é armazenado por um endereço e tem como característica a inserção de dados ser ilimitada,
a lista encadeada aproveita qualquer endereço da memória que esteja vazio. A lista é homogênea, ordenada, inicia vazia e seus elementos são alocados sob demanda e cada
elemento ocupa um nó (nodo) da lista.
 */
public class MainArrayAndList {
    public static void main(String[] args) {

        //Exercicio 1: Implemente uma simples LinkedList
        ImplLinkedList<Client> listaLigadaObjetos = new ImplLinkedList<>();
        Client clientI = new Client("123456", "Joao");
        Client clientII = new Client("987654", "Maria");
        listaLigadaObjetos.add(clientI);
        listaLigadaObjetos.add(clientII);
        System.out.println("\nTamanho Lista de Clientes: "+listaLigadaObjetos.getSize());
        System.out.println("Cliente no indice 01 da lista: "+listaLigadaObjetos.get(1));

        ImplLinkedList<Integer> listaLigadaInteger = new ImplLinkedList<>();
        listaLigadaInteger.addAll(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("\nTamanho Lista de Inteiros: "+listaLigadaInteger.getSize());
        System.out.println("Removendo o \"0\" primeiro da Lista Ligada de Inteiros.");
        listaLigadaInteger.removeFirst();
        System.out.println("Primeiro elemento da lista: "+listaLigadaInteger.getFirst());
        System.out.println("Tamanho Lista de Inteiros: "+listaLigadaInteger.getSize());
        System.out.println("\nRemovendo o \"9\" último da Lista Ligada de Inteiros.");
        listaLigadaInteger.removeLast();
        System.out.println("Último elemento da lista: "+listaLigadaInteger.getLast());
        System.out.println("Tamanho Lista de Inteiros: "+listaLigadaInteger.getSize());
        System.out.println("\nRemovendo o \"5\" da Lista Ligada de Inteiros.");
        listaLigadaInteger.remove(5);
        System.out.println("Tamanho Lista de Inteiros: "+listaLigadaInteger.getSize());
        System.out.println("\nPegar o elemento no indice 2: "+listaLigadaInteger.get(2));

    }
}
