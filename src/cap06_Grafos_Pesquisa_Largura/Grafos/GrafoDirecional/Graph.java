package cap06_Grafos_Pesquisa_Largura.Grafos.GrafoDirecional;

import java.util.ArrayList;
import java.util.Objects;

public class Graph <T>{

    private ArrayList<Vertex<T>> vertex;
    private ArrayList<Edges<T>> edges;

    public Graph() {
        this.vertex = new ArrayList<>();
        this.edges = new ArrayList<>();

    }

    public void addVertex(T data){
        Vertex<T> node = new Vertex<>(data);
        this.vertex.add(node);
    }

    public void addEdges(Double weight, T exitData, T entryData){
        var exitVertex = getVertex(exitData);
        var entryVertex = getVertex(entryData);
        if (Objects.isNull(entryData) || Objects.isNull(exitVertex)) throw new NullPointerException("It is not possible to add a node that does not exist.");
        Edges<T> edge = new Edges<>(weight, entryVertex, exitVertex);
        entryVertex.addEntryEdge(edge);
        exitVertex.addExitEdge(edge);
        this.edges.add(edge);
    }

    public Vertex<T> getVertex(T data) {
        for(Vertex<T> node : this.vertex){
            if(node.getData().equals(data)){
                return node;
            }
        }
        return null;
    }

    public ArrayList<Edges<T>> getEdges() {
        return edges;
    }

}
