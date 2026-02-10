package cap07_Algoritmo_Dijkstra;

import java.util.*;

public class AlgorithmDijkstra {

    /**
     * Executa o algoritmo de Dijkstra para encontrar o menor caminho em grafo ponderado, o algoritmo inicia com inicializa
     * as distâncias de todos os vértices como infinito, exceto a origem (zero), posteriormente, adiciona a uma fila de
     * prioridade de @class Node<T>, retornando da fila o Vertice com menor caminho, então executa uma estrutura de repetição
     * até que a fila de prioridade esteja vazia. E a cada iteração e atualizado o valor do menor caminho do vertice atual até
     * os vertices adjacentes.
     *
     * @param source vertice inicial, a partir do nó fornecido inicirá a busca
     * @param end vertice destino, o vertice onde se encerra a busca
     * @param weightedGraph grafo representado por Map onde a chave é um Vertice generico e valor é Map com Vertices e Arestas com peso
     * @param <T> tipo genérico que representa os vértices do grafo
     *
     * @return Uma {@code List<T>} representando o caminho mais curto.
     * Retorna uma lista vazia se não houver caminho.
     */

    public static <T> List<T> dijkstra(T source, T end, Map<T, Map<T, Integer>> weightedGraph){
        Map<T, T> parent = new HashMap<>();
        if(!weightedGraph.containsKey(source) || !weightedGraph.containsKey(end)) return new ArrayList<>();

        Map<T, Integer> distance = new HashMap<>();
        Set<T> visited = new HashSet<>();
        PriorityQueue<Node<T>> priorityQueue = new PriorityQueue<>();

        for(T vertex : weightedGraph.keySet())
            distance.put(vertex, Integer.MAX_VALUE);

        parent.put(source, null);
        distance.put(source, 0);
        priorityQueue.add(new Node<>(source, 0));

        while (!priorityQueue.isEmpty()){
            T smallestVertex = priorityQueue.poll().vertex;

            if(visited.contains(smallestVertex)) continue;
            visited.add(smallestVertex);

            if (Objects.isNull(smallestVertex) || smallestVertex.equals(end)) break;

            Map<T, Integer> adjacentEdge = weightedGraph.get(smallestVertex);
            for (T vertex : adjacentEdge.keySet()){
                if(!visited.contains(vertex)){
                    int newDistance = distance.get(smallestVertex) + adjacentEdge.get(vertex);

                    if(newDistance < distance.get(vertex)){
                        distance.put(vertex, newDistance);
                        parent.put(vertex, smallestVertex);
                        priorityQueue.add(new Node<>(vertex, newDistance));
                    }
                }
            }
        }
        if(distance.get(end) != Integer.MAX_VALUE) return buildPath(end, parent);
        return new ArrayList<>();
    }

    /**
     * Classe utilitária para representar um nó na Fila de Prioridade.
     * Armazena o vértice e a menor distância calculada até ele para facilitar a comparação.
     * @param <T>
     */
    private static class Node<T> implements Comparable<Node<T>>{
        T vertex;
        Integer distance;

        public Node(T vertex, Integer distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node<T> other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    /**
     * Executa o algoritmo que reconstrói o caminho percorrido do destino até a origem utilizando o mapa de precedência, assim,
     * a partir do Nó destino, inicia-se a busca pegando um Nó Pai até chegar no Nó pai seja igual a NULL, ou seja, o Nó inicial
     * e por fim reverte a lista retornando o caminho mais curto para o Nó Destino
     *
     * @param endNode o nó destino, nó fornecido para finalizar e chamar o método buildPath
     * @param parent Mapa contendo a relação (Nó -> Pai) estabelecida durante o BFS.
     * @param <V> tipo genérico que representa os vértices do grafo
     * @return Lista contendo o caminho reconstruído e invertido (origem para destino).
     */
    private static <V> List<V> buildPath(V endNode, Map<V, V> parent) {
        List<V> path = new ArrayList<>();
        V current = endNode;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }

}
