package cap06_Grafos_Pesquisa_Largura;

import java.util.*;

public class BFS {

    public static <V> ArrayList<V> pesquisaLargura(V sourceNode, Hashtable<V, List<V>> graph){
        ArrayList<V> result = new ArrayList<>();
        if(Objects.isNull(graph.get(sourceNode))) return result;

        Hashtable<V, Boolean> visited = new Hashtable<>();
        LinkedList<V> queue = new LinkedList<>();

        queue.add(sourceNode);
        visited.put(sourceNode, true);

        while (!queue.isEmpty()){
            var node = queue.poll();
            result.add(node);
            List<V> edges = graph.get(node);
            if (Objects.nonNull(edges)){
                Iterator<V> iterator = edges.listIterator();
                while (iterator.hasNext()){
                    var next = iterator.next();
                    if(Objects.isNull(visited.get(next))){
                        visited.put(next, true);
                        queue.add(next);
                    }
                }
            }
        }
        return result;
    }

}
