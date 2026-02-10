package cap07_Algoritmo_Dijkstra;

import java.util.HashMap;
import java.util.Map;

/**
 *  Algoritmo de Dijkstra é um algoritmo de busca de caminho mínimo utilizando grafos ponderados, ou seja, é um
 *  algoritmo que encontra a menor rota de um ponto A ao ponto B levando em consideração a distância entre cada ponto do
 *  início ao destino.
 *  Para que o algoritmo de Dijkstra seja eficiênte deve cumprir alguns requisitos, como o primeiro o algoritmo de Dijkstra
 *  obrigatoriamente iterage sobre um grafo ponderado com peso positivos, ou seja, as arestas devem obrigatóriamente ter pesos
 *  positivos, isso implica diretamente na lógica do algoritmo, com um peso negativo a escolhe do menor caminho pode ser
 *  comprometida
 *  Como funciona:
 *  Ao inicializar o algoritmo de Dijkstra definido um ponto de partida em grafo ponderado, o algoritmo
 *  inicializa colocando todas as distâncias como infinito, somente o ponto inicial é marcado como zero. Na primeira iteração
 *  é buscado todos os vertices adjacentes ao ponto inicial, atualizando a suas respectivas distâncias, ou seja, é o momento de
 *  relaxamento das arestas, onde é somando a distância inicial + peso até chegar ao respectivo vertice < infinito, atualizando
 *  a distância entre os vertices adjacentes ao ponto inicial, após a primeira iteração é escolhido o menor caminho, assim,
 *  o vertice adjacente ao ponto inicial que tem o menor caminho é escolhido para repetir o processo, assim sucessivamente até
 *  encontrar o destino ou iterar sobre grafo por completo.
 */

public class MainDijkstra {
    public static void main(String[] args) {

        //Exercicio 1: Implemente o algoritmo de Dijkstra utilizando Map<String, Map<String, Integer>>
        //Vértices: A, B, C, D, E
        //Arestas: (A,B,3), (A,C,2), (B,C,1), (B,D,5), (C,D,3), (C,E,7), (D,E,4)
        Map<String, Map<String, Integer>> graph = new HashMap<>();

        addEdgesWeightedGraph(graph, "A", "B", 3);
        addEdgesWeightedGraph(graph, "A", "C", 2);
        addEdgesWeightedGraph(graph, "B", "C", 1);
        addEdgesWeightedGraph(graph, "B", "D", 5);
        addEdgesWeightedGraph(graph, "C", "D", 3);
        addEdgesWeightedGraph(graph, "C", "E", 6);
        addEdgesWeightedGraph(graph, "D", "E", 4);
        addEdgesWeightedGraph(graph, "E", null, null);

        System.out.println(graph);
        System.out.println("Solução exercicio 1: ");
        AlgorithmDijkstra.dijkstra("A", "E", graph).forEach(v -> System.out.print(" - "+v));

        //Exercicio 2: Resolver o problema da rota mais barata entre cidades
        Map<String, Map<String, Integer>> distanceCity = new HashMap<>();
        addEdgesWeightedGraph(distanceCity, "SP", "MG", 102);
        addEdgesWeightedGraph(distanceCity, "SP", "RJ", 80);
        addEdgesWeightedGraph(distanceCity, "MG", "ES", 75);
        addEdgesWeightedGraph(distanceCity, "MG", "BA", 100);
        addEdgesWeightedGraph(distanceCity, "RJ", "ES", 75);
        addEdgesWeightedGraph(distanceCity, "ES", "BA", 100);
        addEdgesWeightedGraph(distanceCity, "BA", null, null);
        System.out.println("\nSolução exercicio 2: ");
        AlgorithmDijkstra.dijkstra("SP", "BA", distanceCity).forEach(v -> System.out.print(" | "+v));

        //Exercicio 3: Implementar sua própria fila de prioridade
        //-> Na classe Algorithm Dijkstra

    }

    public static <T> void addEdgesWeightedGraph(Map<T, Map<T, Integer>> graph, T from, T destination, Integer weight){
        graph.computeIfAbsent(from, v -> new HashMap<>());
        if (destination != null && weight != null) {
            graph.get(from).put(destination, weight);
        }
    }
}
