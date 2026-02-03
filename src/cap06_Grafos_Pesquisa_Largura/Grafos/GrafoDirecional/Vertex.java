package cap06_Grafos_Pesquisa_Largura.Grafos.GrafoDirecional;

import java.util.ArrayList;

public class Vertex<T> {

    private T data;
    private ArrayList<Edges<T>> ExitEdges;
    private ArrayList<Edges<T>> EntryEdges;

    public Vertex(T data) {
        this.data = data;
        this.ExitEdges = new ArrayList<>();
        this.EntryEdges = new ArrayList<>();
    }

    public void addExitEdge(Edges<T> edge){
        this.ExitEdges.add(edge);
    }
    public void addEntryEdge(Edges<T> edge){
        this.EntryEdges.add(edge);
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public ArrayList<Edges<T>> getExitEdges() {
        return ExitEdges;
    }
    public ArrayList<Edges<T>> getEntryEdges() {
        return EntryEdges;
    }

    @Override
    public String toString() {
        return ""+data;
    }
}
