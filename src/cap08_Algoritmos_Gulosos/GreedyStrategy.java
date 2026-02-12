package cap08_Algoritmos_Gulosos;


import cap04_Dividir_Conquistar_Quicksort.Quicksort.Quicksort;
import cap08_Algoritmos_Gulosos.Activity.Activity;

import java.util.*;

public class GreedyStrategy {

    /**
     * Executa a solução para o problema das moedas, retornando uma lista contendo o menor número de moedas com maior valor
     *
     * @param coins array contendo quais moedas iram utilizar
     * @param value valor que deseja fracionar em moedas
     *
     * @return Uma {@code List<Integer>} cotendo quais moedas para chegar ao Value
     */
    public static List<Integer> problemaMoedas(Integer[] coins, Integer value){
        List<Integer> list = new ArrayList<>(Arrays.stream(Quicksort.quicksort(coins)).toList());
        Collections.reverse(list);
        List<Integer> coinsToReturn = new ArrayList<>();
        int result = 0;

        for (Integer coin : list){
            while (result <= value && (result + coin) <= value){
                coinsToReturn.add(coin);
                result += coin;
            }
        }

        return coinsToReturn;
    }

    /**
     * Executa a solução para o problema das atividades, selecionando maior quantidade de atividades para fazer sem sobrepor
     * uma a outra.
     *
     * @param activities lista de atividades
     *
     * @return Uma {@code List<Activity>} cotendo quais atividades fazer
     */
    public static List<Activity> selecaoAtividades(List<Activity> activities){
        activities.sort(Comparator.comparing(Activity::getEnd));
        List<Activity> activitySelection = new ArrayList<>();
        activitySelection.add(activities.getFirst());
        int control = 0;

        for(int i = 1; i < activities.size(); i++){
            var activity = activities.get(i);
            var activityPrevious = activitySelection.get(control);
            if (activityPrevious.getEnd() < activity.getStart()){
                activitySelection.add(activity);
                control++;
            }
        }
        return activitySelection;
    }





}
