package cap08_Algoritmos_Gulosos;

import cap08_Algoritmos_Gulosos.Activity.Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * A estratégia gulosa ou algoritmos gulosos tentam resolver problemas fazendo a melhor escolha localmente, para chegar
 * na melhor solução global. Ou seja, o algoritmo guloso a cada iteração escolhe a melhor solução local, ao finalizar o
 * problema com a solução mais viável. Entretanto, nem sempre a melhor solução local faz parte do conjunto da melhor solução
 * global.
 * O algoritmo Guloso é muito utilizado em problemas de otimização.
 */

public class MainGreedyStrategy {
    public static void main(String[] args) {

        //Exercício 1: Você tem moedas com os seguintes valores: {1, 5, 10 e 25}. Dado um valor N, retorne o menor número de moedas necessário para formar esse valor.
        int value = 36;
        Integer[] coins = {1, 5, 10, 25};
        GreedyStrategy.problemaMoedas(coins, value).forEach(System.out::println);

        //Exercício 2: Você tem atividades com horário de início e fim - Escolha o maior número possível de atividades sem sobreposição.
        /*
        | Atividade | Início | Fim |
        | --------- | ------ | --- |
        | A         | 1      | 4   |
        | B         | 3      | 5   |
        | C         | 0      | 6   |
        | D         | 5      | 7   |
        | E         | 8      | 9   |
        | F         | 5      | 9   |

         */
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("B", 3, 5));
        activities.add(new Activity("A", 1, 4));
        activities.add(new Activity("C", 0, 6));
        activities.add(new Activity("D", 5, 7));
        activities.add(new Activity("E", 8, 9));
        activities.add(new Activity("F", 5, 8));
        GreedyStrategy.selecaoAtividades(activities).forEach(System.out::println);

    }


}
