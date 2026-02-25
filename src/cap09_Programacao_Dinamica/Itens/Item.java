package cap09_Programacao_Dinamica.Itens;

import java.util.Objects;

public class Item {

    private String name;
    private Integer price;
    private Integer weight;

    public Item(String name, Integer price, Integer weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  name + " - R$" + price + " peso: " + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(weight, item.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }
}
