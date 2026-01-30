package cap06_Grafos_Pesquisa_Largura;

import java.util.Hashtable;
import java.util.List;

/**
 * Grafos são estrutura de dados que consiste em vértices (nó) conectados pelas arestas. O grafo é amplamente utilizado
 * em diversas áreas como matemática, biologia, ciência da computação, etc.
 * Portanto, um modelo de grafo é um conjunto de conexões entre vértices por meio das arestas, onde:
 *  - Vértices: É cada entidade representada dependendo do problema pode ser pessoas, cruzamentos, etc.
 *  - Arestas: É o que associa a dois vértices (v1 e v2), ou seja, diz qual a relação entre eles
 * Os grafos podem ser direcionais e não direcionais, grafos direcionais são aqueles que existe uma orientação em qual
 * sentido está aresta, se há uma seta que conecta V1 para V2, conclui-se que, V1 pode ir para V2, mas V2 não pode ir para V1.
 * Já grafos não direcionais, são grafos que não existe uma orientação nas arestas, portanto, uma aresta que conecta V3 para V4,
 * conclui-se que, V3 pode ir para V4, assim como V4 pode ir para V3.
 *
 * Há também o grau e ordem de cada vértice, a ordem de um grafo é a quantidade de vértices que há dentro deste grafo, já
 * o grau é quantidade de aresta que partem ou chegam no vértice, ou seja, quantidade de arestas que tocam no vértice, no caso de um
 * grafo direcionais refere-se ao grau de entrada e grau de saída.
 *
 */


public class MainGraphsBFS {
    public static void main(String[] args) {

        //Exercicio 1: Implemente um grafo não direcional
        GraphInteger graphInteger = new GraphInteger(4);
        graphInteger.addVertice(0, 1);
        graphInteger.addVertice(0, 3);
        graphInteger.addVertice(1, 2);
        graphInteger.addVertice(1, 3);
        graphInteger.addVertice(2, 3);
        graphInteger.addVertice(2, 4);
        graphInteger.addVertice(3, 4);


        //Exercicio 2: Implemente a pesquisa em largura
        System.out.println("\nExercicio 2:");
        Hashtable<String, List<String>> grafo = new Hashtable<>();

        grafo.put("Jesus", List.of("José", "Maria", "João"));
        grafo.put("José", List.of("Jesus", "Maria", "Davi", "Abner"));
        grafo.put("Maria", List.of("Jesus", "José", "João", "Abner"));
        grafo.put("João", List.of("Jesus", "Pedro", "Andre"));
        grafo.put("Davi", List.of("José"));
        grafo.put("Abner", List.of("José", "Maria", "Pedro"));
        grafo.put("Pedro", List.of("Abner", "João", "Andre", "Mateus"));
        grafo.put("Mateus", List.of("Pedro"));
        grafo.put("Andre", List.of("Tiago"));
        grafo.put("Tiago", List.of("Andre"));
        BFS.pesquisaLargura("João", grafo).forEach(System.out::println);

        //Exercicio 3: Elabore um algoritmo de Pesquisa em Largura (BFS) capaz de encontrar o menor caminho entre duas cidades
        System.out.println("\nExercicio 3:");
        Hashtable<String, List<String>> caminhos = new Hashtable<>();
        caminhos.put("São Paulo", List.of("Campinas", "Santos"));
        caminhos.put("Campinas", List.of("São Paulo", "Ribeirão Preto", "Valinhos"));
        caminhos.put("Valinhos", List.of("Campinas", "Sorocaba"));
        caminhos.put("Santos", List.of("São Paulo", "Cubatão"));
        caminhos.put("Cubatão", List.of("São Paulo"));
        caminhos.put("Ribeirão Preto", List.of("Campinas"));
        BFS.pesquisaLargura("São Paulo", "Ribeirão Preto", caminhos).forEach(System.out::println);

    }
}
