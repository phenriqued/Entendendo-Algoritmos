package cap06_Grafos_Pesquisa_Largura;

import java.util.LinkedList;

public class Graph<T> {
    private int numberOfVertices;
    private LinkedList<T> adjacents[];

    public Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.adjacents = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) adjacents[i] = new LinkedList<>();
    }

    public void addVertice(int indice, T data){
        adjacents[indice].add(data);
    }

    public int getIndexVertice(T data){
        for(int i = 0; i < numberOfVertices; i++){
            for (T node : adjacents[i]){
                if (node.equals(data))
                    return i;
            }
        }
        return -1;
    }

    public LinkedList<T> getEdgesNode(int index){
        return adjacents[index];
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }
}
