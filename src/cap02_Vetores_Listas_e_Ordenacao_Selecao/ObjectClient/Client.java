package cap02_Vetores_Listas_e_Ordenacao_Selecao.ObjectClient;

import java.util.Objects;

public class Client implements Comparable<Client>{

    private String cpf;
    private String name;
    private Integer age;

    public Client(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public Client(String cpf, String name, Integer age) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + " - Name: " + name +" - Age: "+age+" | ";
    }

    @Override
    public int compareTo(Client otherClient) {
        if(Objects.equals(this.age, otherClient.age)){
            return 0;
        } else if (this.age > otherClient.age) {
            return 1;
        } else {
            return -1;
        }
    }
}
