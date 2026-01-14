package cap05_Tabela_Hash;

import cap05_Tabela_Hash.HashTable.HashTable;

import java.util.Arrays;
import java.util.Objects;

/**
 *  Tabelas Hash é uma estrutura de dados de array associativo, ou seja, uma estrutura de dados que armazena chave-valor, a tabela
 *  Hash funciona utilizando a funções hashing, daí o nome.
 *
 *  Função Hashing é a função que, dada a entrada de um dado, gera uma sequência alfanumérica de tamanho fixo.
 *  Em uma tabela hash, dada a associação entre chave-valor, a partir de uma chave a função hashing gera um valor numérico
 *  que identifica a posição (índice) do valor.
 *  Portanto, o desempenho de uma busca utilizando Tabelas Hashing é O(1) em um tempo constante.
 *
 *  CONTUDO, uma função hashing deve ser bem elaborada, uma vez que, caso uma função hashing gere um valor numérico igual para
 *  valores diferentes ocorrera COLISÕES. É de suma importância projetar funções hash inteligentes que tentam minimizar colisões.
 *  Existem diferentes formas de tratar colisões, mas existem duas mais comuns:
 *      - Encadeamento:
 *    No encadeamento, cada entrada da tabela é uma lista encadeada, assim, quando ocorre a colisão o valor é adicionado
 *    a lista encadeada correspondente ao indice do array. Ou seja, se dois valores diferentes geram funções hash iguais, estas
 *    serão adicionadas a mesma lista encadeada.
 *    A principal vantagem do encadeamento é a simplicidade de implementação, contudo a principal desvantagem é ineficiente
 *    em termos de espaço e desempenho.
 *      - Endereçamento Aberto:
 *    No endereçamento aberto, quando ocorre a colisão, a chave de pesquisa é adicionada a outra posição da tabela hash, assim,
 *    se duas chaves diferentes gera o mesmo valor da função hashing, a segunda chave é adicionada em outra posição da tabela hash.
 *    Pode ser mais eficiente em termos de espaço, mas em desempenho no pior caso pode ser também O(n) e pode ser mais complexo a
 *    implementação.
 *
 *    Uma boa função hash distribui os valores no array simetricamente, diferente de uma pessima função hash que agrupa
 *    valores e produz diversas colisões.
 *    E um bom medidor de probabilidade de colisões é o Fator de Carga que é a razão entre quantidade dados na tabela hash e
 *    número total de espaço. Quando um fator de carga mais próximo de 1 maior a probabilidade de colisão, um fator de cargar ideal
 *    é menor que 0,7, ou seja, ocupando até 70% do array associativo. E quando o Fator de Carga chega a 0,7 o ideal é redimensionar,
 *    o que pode ser custoso, uma vez que é necessário criar uma nova tabela hash contendo mais espaços para agrupar a quantidade de
 *    dados e reinserir todos os dados nesta nova tabela hash utilizando a função hashing.
 */

public class MainHashTable {

    public static void main(String[] args) {

        //Exercicio 1: Implementar uma hash table simples usando array e listas encadeadas
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("Pedro", "senha123");
        hashTable.put("Alexandre", "senha456");
        hashTable.put("Marcos", "senha789");
        hashTable.put("Gojo", "senha098");
        hashTable.put("Maria", "senha765");
        hashTable.put("Aa", "A - ColisionTest");
        hashTable.put("BB", "B - ColisionTest");

        System.out.println("Get Key Pedro: "+hashTable.get("Pedro"));
        System.out.println("Removendo Pedro: "+ hashTable.remove("Pedro"));
        System.out.println("Get Key Pedro: "+hashTable.get("Pedro"));

        //Exercicio 2: Dado um texto, percorro palavra por palavra e utilizo uma HashTable onde a chave é a palavra e o valor é um contador.
        //Se a palavra já existir, incremento o contador; caso contrário, insiro com valor inicial 1.
        HashTable<String, Integer> wordHashTable = new HashTable<>();
        String txt = """
                Tabela Hash é uma estrutura de dados de array associativo, ou seja, uma estrutura de dados que armazena chave valor
                a Tabela Hash funciona utilizando a Função Hashing, daí o nome
                Função Hashing é a função que, dada a entrada de um dado, gera uma sequência alfanumérica de tamanho fixo
                Em uma Tabela Hash, dada a associação entre chave-valor, a partir de uma chave a Função Hashing gera um valor numérico que identifica a posição (índice) do valor""";
        String[] words = txt.split(" ");
        for (String word : words){
            var quantity = wordHashTable.get(word);
            if(quantity == null){
                wordHashTable.put(word, 1);
            }else {
                quantity++;
                wordHashTable.put(word, quantity);
            }
        }
        Arrays.stream(wordHashTable.getTable())
                .forEach(word -> {
                    if(Objects.nonNull(word)) System.out.println("Palavra: "+word.getKey()+" - Quantidade: "+word.getValue());
                });

    }
}
