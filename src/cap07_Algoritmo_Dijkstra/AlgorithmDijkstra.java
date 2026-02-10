package cap07_Algoritmo_Dijkstra;

import cap06_Grafos_Pesquisa_Largura.BFS.BFS;

import java.util.*;

public class AlgorithmDijkstra {

    public static <T> List<T> dijkstra(T source, T end, Map<T, Map<T, Integer>> weightedGraph){
        Map<T, T> parent = new HashMap<>();
        if(!weightedGraph.containsKey(source) || !weightedGraph.containsKey(end)) return new ArrayList<>();

        Map<T, Integer> distance = new HashMap<>();
        for(T vertex : weightedGraph.keySet())
            distance.put(vertex, Integer.MAX_VALUE);

        Set<T> visited = new HashSet<>();

        parent.put(source, null);
        distance.put(source, 0);

        while (true){
            T smallestVertex = getSmallestVertex(visited, distance);
            if (Objects.isNull(smallestVertex) || smallestVertex.equals(end)) break;

            visited.add(smallestVertex);
            Map<T, Integer> adjacentEdge = weightedGraph.get(smallestVertex);
            for (T vertex : adjacentEdge.keySet()){
                if(!visited.contains(vertex)){
                    int newDistance = distance.get(smallestVertex) + adjacentEdge.get(vertex);

                    if(newDistance < distance.get(vertex)){
                        distance.put(vertex, newDistance);
                        parent.put(vertex, smallestVertex);
                    }
                }
            }
        }

        return BFS.buildPath(end, parent);
    }

    private static <T> T getSmallestVertex(Set<T> visited, Map<T, Integer> distance) {
        T smallestVertex = null;
        int minDistance = Integer.MAX_VALUE;
        for (T vertex : distance.keySet()){
            int distanceActual = distance.get(vertex);
            if(distanceActual < minDistance && !visited.contains(vertex)){
                minDistance = distanceActual;
                smallestVertex = vertex;
            }
        }
        return smallestVertex;
    }


}
