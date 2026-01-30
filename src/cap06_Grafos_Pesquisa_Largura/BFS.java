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

    /**
     * Executa o algoritmo de Pesquisa em Largura (BFS) para encontrar o menor caminho em um grafo representado por lista de adjacência.
     * O algoritmo visita os nós por níveis, garantindo a descoberta do caminho com menor número de arestas entre o nó de origem e o de destino.
     * Caso o nó inicial ou nó de destino não exista como chave no grafo, o método retorna uma lista vazia.
     *
     *
     * @param sourceNode o nó inicial, a partir do nó fornecido inicirá a busca
     * @param endNode o nó destino, nó fornecido para finalizar e chamar o método buildPath
     * @param graph grafo representado por uma tabela hash onde a chave é um nó e o valor é a lista de nós adjacentes
     * @param <V> tipo genérico que representa os vértices do grafo
     *
     * @return Uma lista ordenada contendo o caminho da origem ao destino, ou uma lista vazia caso o caminho não exista.
     */
    public static <V> List<V> pesquisaLargura(V sourceNode, V endNode, Hashtable<V, List<V>> graph) {
        List<V> path = new ArrayList<>();
        if (!graph.containsKey(sourceNode) || !graph.containsKey(endNode)) return path;

        Set<V> visited = new HashSet<>();
        Queue<V> queue = new LinkedList<>();
        Map<V, V> parent = new HashMap<>();

        queue.add(sourceNode);
        visited.add(sourceNode);
        parent.put(sourceNode, null);

        while (!queue.isEmpty()) {
            V node = queue.poll();
            if (node.equals(endNode)) return buildPath(endNode, parent);
            List<V> neighbors = graph.get(node);
            if (neighbors != null){
                for (V next : neighbors) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                        parent.put(next, node);
                    }
                }
            }
        }
        return path;
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