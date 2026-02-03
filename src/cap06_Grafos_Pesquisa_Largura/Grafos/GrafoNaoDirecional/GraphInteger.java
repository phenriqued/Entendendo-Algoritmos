package cap06_Grafos_Pesquisa_Largura.Grafos.GrafoNaoDirecional;

import java.util.LinkedList;

/**
 * Implementação simples de um grafo utilizando lista de adjacência, onde os vértices e arestas são representados por
 * valores do tipo inteiros.
 * O grafo é modelado internamente por um array de listas encadeadas, no qual cada índice do array representa um vértice
 * e sua respectiva lista contém os vértices adjacentes
 *
 */
public class GraphInteger {
    private int numberOfVertices;
    private LinkedList<Integer> adjacents[];

    /**
     * Cria um grafo com um número fixo de vértices.
     * @param numberOfVertices quantidade total de vértices do grafo
     */
    public GraphInteger(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adjacents = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) adjacents[i] = new LinkedList<>();
    }

    /**
     * Adiciona uma aresta a partir de um vértice identificado pelo índice,
     * conectando-o a outro vértice representado pelo valor {@code data}.
     *
     * @param indice índice do vértice de origem
     * @param data valor do vértice de destino
     */
    public void addVertice(int indice, int data){
        adjacents[indice].add(data);
    }

    /**
     * Retorna a lista de vértices adjacentes a um determinado vértice.
     *
     * @param index índice do vértice
     * @return lista de vértices conectados ao vértice informado
     */
    public LinkedList<Integer> getEdgesNode(int index){
        return adjacents[index];
    }
}
