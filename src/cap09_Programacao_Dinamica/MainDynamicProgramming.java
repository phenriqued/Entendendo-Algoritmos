package cap09_Programacao_Dinamica;

import cap09_Programacao_Dinamica.Itens.Item;

import java.util.ArrayList;
import java.util.List;

/**
 *  Programação dinâmica é uma abordagem que busca solucionar problemas sub dividindo-os em problemas menores solucionando
 *  e armazenando para que o resultado dos problemas menores possam ser reutilizados para solução do problema como um todo.
 *
 *  Programação Dinâmica X Dividir para Conquista
 *  Apesar de ambos conceitos terem um definição levemente parecida, os dois são abordagem diferentes. Assim como o conceito de
 *  Dividir para conquistar, onde o problema é sub dividido em problemas menores a Programação Dinâmica tem a mesma abordagem, mas
 *  o que as difere é que na Programação dinâmica os subproblemas se sobrepõem, armazenam o resultado de cada subproblema para evitar o
 *  retrabalho, já em dividir para conquistar a solução dos sub problemas não são armazenados e cada sub problema é independente, onde de forma
 *  recursiva cada sub problema é resolvido até a solução final.
 *
 */

public class MainDynamicProgramming {

    public static void main(String[] args) {

        /**
         * Exercicio 1: Você tem uma mochila com capacidade máxima de 6kg.
         * Você pode escolher entre os seguintes itens:
         *
         * Item	      Peso (kg)	    Valor
         * Notebook	     3	        2000
         * Headset	     1	        500
         * Livro Técnico 2	        800
         * Mouse Gamer	 1	        400
         * Qual é o valor máximo que você consegue carregar sem ultrapassar 6kg?
         * */
        ArrayList<Item> items = new ArrayList<>(List.of(
                new Item("Notebook", 2000, 3),
                new Item("Headset", 500, 1),
                new Item("Livro Técnico", 800, 2),
                new Item("Mouse Gamer", 400, 1),
                new Item("Camera", 2500, 4)));
        List<Item> result = DynamicProgramming.knapsack(6, items);
        System.out.println("Valor máximo que consegue carregar é de " + result.stream().mapToInt(Item::getPrice).sum());
        System.out.println("Os produtos são:");
        result.forEach(System.out::println);

        /**
         * Exercicio 2: Dadas as strings:
         * String A = "ABCDGH"
         * String B = "AEDFHR"
         * Responda:
         * Qual é o tamanho da maior subsequência comum?
         * Qual é a subsequência?
         */
        String a = "ABCDGH";
        String b = "AEDFHR";
        var resultLcs = DynamicProgramming.lcs(a, b);
        System.out.println("Qual é o tamanho da maior subsequência comum?\n"+resultLcs.length());
        System.out.println("Qual é a subsequência?\n"+resultLcs);

    }

}
