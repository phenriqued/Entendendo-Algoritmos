package cap06_Grafos_Pesquisa_Largura.BFS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    @Test
    @DisplayName("Deve retornar um ArrayList contendo a pesquisa em Largura a partir de um Nó fornecido")
    void pesquisaLargura() {
        Hashtable<String, List<String>> grafo = new Hashtable<>();
        grafo.put("A", List.of("B", "C"));
        grafo.put("B", List.of("A", "D", "E"));
        grafo.put("C", List.of("A", "F"));
        grafo.put("D", List.of("B"));
        grafo.put("E", List.of("B"));
        grafo.put("F", List.of("C"));

        ArrayList<String> result = BFS.pesquisaLargura("A", grafo);

        assertEquals(Arrays.asList("A", "B", "C", "D", "E", "F"), result);
        assertEquals(6, result.size());
    }

    @Test
    @DisplayName("Valida tratamento de lista de adjacência vazia / inexistente")
    void IsolatedStartingNode() {
        Hashtable<String, List<String>> grafoNoIsolado = new Hashtable<>();
        grafoNoIsolado.put("A", List.of());

        ArrayList<String> result = BFS.pesquisaLargura("A", grafoNoIsolado);

        assertEquals(List.of("A"), result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("BFS não entra em loop infinito, cada nó aparece apenas uma vez - Valida o controle de visited")
    void SimpleCycle() {
        Hashtable<String, List<String>> grafo = new Hashtable<>();
        grafo.put("A", List.of("B", "C"));
        grafo.put("B", List.of("A", "C"));
        grafo.put("C", List.of("A", "B"));

        ArrayList<String> result = BFS.pesquisaLargura("A", grafo);

        assertEquals(List.of("A", "B", "C"), result);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Deve retornar uma ArrayList vazia quando o Nó não existe no grafo")
    void NodeDoesNotExist() {
        Hashtable<String, List<String>> grafo = new Hashtable<>();
        grafo.put("A", List.of("B", "C"));
        grafo.put("B", List.of("A", "C"));
        grafo.put("C", List.of("A", "B"));

        ArrayList<String> result = BFS.pesquisaLargura("Z", grafo);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Deve retonar uma List contendo o menor caminho do Nó inicial até o Nó destino")
    void menorCaminho() {
        Hashtable<String, List<String>> caminho = new Hashtable<>();
        caminho.put("SP", List.of("MG", "PR", "RJ", "MS"));
        caminho.put("PR", List.of("SP", "MS"));
        caminho.put("MS", List.of("SP", "PR", "GO"));
        caminho.put("RJ", List.of("ES", "MG", "SP"));
        caminho.put("MG", List.of("ES", "BA", "RJ", "GO"));
        caminho.put("GO", List.of("BA", "MS", "MG"));
        caminho.put("ES", List.of("BA", "MG", "RJ"));
        caminho.put("BA", List.of("ES", "GO"));

        List<String> result = BFS.pesquisaLargura("SP", "BA", caminho);

        assertEquals(Arrays.asList("SP", "MG", "BA"), result);
        assertEquals(3, result.size());
    }
    @Test
    @DisplayName("Deve retonar uma List vazia quando o Nó de destino não existe no grafo")
    void destinationNodeNotExistInGraph() {
        Hashtable<String, List<String>> caminho = new Hashtable<>();
        caminho.put("SP", List.of("MG", "PR", "RJ"));
        caminho.put("MG", List.of("SP", "RJ", "GO"));
        caminho.put("PR", List.of("SP", "MS"));
        caminho.put("RJ", List.of("ES", "MG", "SP"));
        caminho.put("MS", List.of("PR"));
        caminho.put("GO", List.of("BA", "MG"));
        caminho.put("ES", List.of("BA", "RJ"));
        caminho.put("BA", List.of("ES", "GO"));

        List<String> result = BFS.pesquisaLargura("SP", "TE", caminho);

        assertTrue(result.isEmpty());
    }

}