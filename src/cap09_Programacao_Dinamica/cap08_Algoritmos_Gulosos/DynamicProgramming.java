package cap09_Programacao_Dinamica.cap08_Algoritmos_Gulosos;


import cap09_Programacao_Dinamica.cap08_Algoritmos_Gulosos.Itens.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DynamicProgramming {

    /**
     * Executa o algoritmo que encontra a maior quantidade de items valiosos que juntos tenham o peso igual à capacidade
     * fornecida. O algoritmo inicia-se criando uma matriz de inteiros para armazenar o maior valor em cada capacidade até
     * a capacidade final fornecida, para cada item é verificado se o mesmo tem o peso menor que a capacidade e se seu valor
     * é maior que valor da celula atual.
     *
     * @param items Lista de items.
     * @param capacity o peso total.
     * @return Lista contendo o maior valor de soma dos preços de cada item
     */
    public static List<Item>  knapsack(int capacity, List<Item> items){
        if(capacity < 1 || items.isEmpty()) throw new IllegalArgumentException("Invalid argument, the capacity and the list of items must be greater than one.");
        int[][] table = new int[items.size()+1][capacity+1];

        for(int i = 1; i <= items.size(); i++){
            var item = items.get(i-1);

            for (int j = 1; j <= capacity; j++){
                if(item.getWeight() <= j){
                    table[i][j] = Math.max(table[i-1][j], item.getPrice() + table[i - 1][j - item.getWeight()]);
                }else {
                    table[i][j] = table[i-1][j];
                }
            }
        }
        return buildPath(table, items, capacity);
    }
    /**
     * Executa o algoritmo que reconstrói o caminho percorrido na matriz até o valor final, na matriz quando a diferença entre
     * uma celula e outra, significa que o item atual foi escolhido, assim o mesmo é adicionado na list result.
     *
     * @param table matriz solucionado com maior valor possível.
     * @param items Lista de itens.
     * @param capacity o peso total.
     * @return Lista contendo todos os itens utilizando para o valor final
     */
    private static List<Item> buildPath(int[][] table, List<Item> items, int capacity){
        List<Item> result = new ArrayList<>();
        int i = items.size();
        int w = capacity;

        while(i > 0 && w > 0){
            if(table[i][w] != table[i-1][w]){
                var item = items.get(i-1);
                result.add(item);
                w -= item.getWeight();
            }
            i --;
        }
        Collections.reverse(result);
        return result;
    }
    /**
     * Executa o algoritmo que encontra a maior subsequencia de caracteres em comum entre uma String A e uma String .
     * O Algoritmo inicia-se com uma matriz do tamanho da String A e String B e para cada caracter e comparado se forem iguais
     * a celula atual recebe o valor dela mais o valor da celular na diagonal cima direita, ao final das iterações a ultima celula
     * é quantidade de caracteres que são comuns entre si.
     *
     * @param a String contendo a sequencia de caracteres.
     * @param b String contendo a sequencia de caracteres.
     * @return String contendo a sequencia de caracteres comum entre String A e String B.
     */
    public static String lcs(String a, String b) {
        if (Objects.isNull(a) || Objects.isNull(b)) throw new IllegalArgumentException("Invalid argument, the String a and String b must be different from null or empty.");
        if (a.isEmpty() || b.isEmpty()) throw new IllegalArgumentException("Invalid argument, the String a and String b must be different from null or empty.");
        int[][] table = new int[a.length() + 1][b.length() +1];

        for (int i = 1; i <= a.length(); i++){
            char characterLine = a.charAt(i-1);
            for (int j = 1; j <= b.length(); j++){
                char characterColumn = b.charAt(j-1);

                if(characterLine == characterColumn){
                    table[i][j] = 1 + table[i - 1][j - 1];
                }else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }
        return buildString(table, a, b);
    }
    /**
     * Executa o algoritmo que reconstrói o caminho percorrido na matriz do valor final ao valor inicial, comparando cada caracter
     * quando os caracteres são iguais, a próxima celula a ser comparada é a celular na diagonal cima direita e caso o caracteres sejam
     * diferente e corampado a celula de maior valor entre o lado direito e cima priorizando a celula superior caso haja empate.
     *
     * @param table matriz solucionado com maior quantidade de caracteres comuns.
     * @param a String contendo a sequencia de caracteres.
     * @param b String contendo a sequencia de caracteres.
     * @return String contendo a sequencia de caracteres comum entre String A e String B.
     */
    private static String buildString(int[][] table, String a, String b){
        StringBuilder st = new StringBuilder();
        int i = a.length();
        int j = b.length();

        while (i > 0 && j > 0){

            if (a.charAt(i - 1) == b.charAt(j - 1)){
                st.append(a.charAt(i - 1));
                j--;
                i--;
            }else {
                if (table[i][j-1] >= table[i-1][j]){
                    j--;
                }else {
                    i--;
                }
            }
        }
        return st.reverse().toString();
    }

}
