package cap06_Grafos_Pesquisa_Largura.Grafos.GrafoDirecional;

public class Edges<T> {

    private Double weight;
    private Vertex<T> initiation;
    private Vertex<T> end;

    public Edges(Double weight, Vertex<T> initiation, Vertex<T> end) {
        this.weight = weight;
        this.initiation = initiation;
        this.end = end;
    }

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public T getInitiation() {
        return initiation.getData();
    }
    public void setInitiation(Vertex<T> initiation) {
        this.initiation = initiation;
    }

    public T getEnd() {
        return end.getData();
    }
    public void setEnd(Vertex<T> end) {
        this.end = end;
    }
}
