package cap06_Grafos_Pesquisa_Largura;

import java.util.*;

public class BFS {
    /**
     * Executa o algoritmo de Pesquisa em Largura (BFS) a partir de um nó inicial em um grafo representado por lista de adjacência.
     * O algoritmo visita os nós por níveis, explorando primeiro todos os vizinhos
     * diretos do nó inicial antes de avançar para níveis mais profundos.
     * Cada nó é visitado no máximo uma vez.
     * Caso o nó inicial não exista como chave no grafo, o método retorna uma lista vazia.
     * Nós que não possuem lista de adjacência (nós isolados) são visitados, mas não geram novas expansões na busca.
     *
     * @param sourceNode o nó inicial, a partir do nó fornecido inicirá a busca
     * @param graph grafo representado por uma tabela hash onde a chave é um nó e o valor é a lista de nós adjacentes
     * @param <V> tipo genérico que representa os vértices do grafo
     *
     * @return ArrayList contendo os nós visitados em ordem de descoberta ou lista vazia caso nó inicial não esteja no
     * grafo
     */
    public static <V> ArrayList<V> pesquisaLargura(V sourceNode, Hashtable<V, List<V>> graph){
        ArrayList<V> result = new ArrayList<>();
        if(!graph.containsKey(sourceNode)) return result;

        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();

        queue.add(sourceNode);
        visited.add(sourceNode);

        while (!queue.isEmpty()){
            var node = queue.poll();
            result.add(node);
            List<V> neighbors = graph.get(node);
            if (Objects.nonNull(neighbors)){
                Iterator<V> iterator = neighbors.listIterator();
                while (iterator.hasNext()){
                    var next = iterator.next();
                    if(!visited.contains(next)){
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return result;
    }

}