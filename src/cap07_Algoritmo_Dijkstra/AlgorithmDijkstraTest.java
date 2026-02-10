package cap07_Algoritmo_Dijkstra;

import cap06_Grafos_Pesquisa_Largura.BFS.BFS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmDijkstraTest {

    Map<String, Map<String, Integer>> graph = new HashMap<>();

    @BeforeEach
    public void setup(){
        addEdgesWeightedGraph(graph, "A", "B", 3);
        addEdgesWeightedGraph(graph, "A", "C", 2);
        addEdgesWeightedGraph(graph, "B", "C", 1);
        addEdgesWeightedGraph(graph, "B", "D", 5);
        addEdgesWeightedGraph(graph, "C", "D", 3);
        addEdgesWeightedGraph(graph, "C", "E", 9);
        addEdgesWeightedGraph(graph, "D", "E", 4);
        addEdgesWeightedGraph(graph, "E", null, null);
        addEdgesWeightedGraph(graph, "F", null, null);
    }
    public <T> void addEdgesWeightedGraph(Map<T, Map<T, Integer>> graph, T from, T destination, Integer weight){
        graph.computeIfAbsent(from, v -> new HashMap<>());
        if (destination != null && weight != null) {
            graph.get(from).put(destination, weight);
        }
    }

    @Test
    @DisplayName("Deve retornar um List contendo o menor caminho de A para E")
    void dijkstra() {
        var result = AlgorithmDijkstra.dijkstra("A", "E", graph);

        assertEquals(Arrays.asList("A","C","D","E"), result);
        assertEquals(4, result.size());
    }
    @Test
    @DisplayName("deve retornar uma lista vazia quando o não é possivel chegar no vertice final fornecido")
    void itShouldReturnEmptyListWhenIsNotPossibleReachProvidedFinalVertex() {
        var result = AlgorithmDijkstra.dijkstra("A", "F", graph);

        assertEquals(List.of(), result);
        assertTrue(result.isEmpty());
    }
    @Test
    @DisplayName("Deve retornar uma ArrayList vazia quando o Nó não existe no grafo")
    void NodeDoesNotExist() {
        var result = AlgorithmDijkstra.dijkstra("Z", "A", graph);

        assertTrue(result.isEmpty());
    }
    @Test
    @DisplayName("Deve retornar uma ArrayList vazia quando o Nó não existe no grafo")
    void FromEqualsEnd() {
        var result = AlgorithmDijkstra.dijkstra("A", "A", graph);

        assertEquals(List.of("A"), result);
        assertEquals(1, result.size());
    }


}