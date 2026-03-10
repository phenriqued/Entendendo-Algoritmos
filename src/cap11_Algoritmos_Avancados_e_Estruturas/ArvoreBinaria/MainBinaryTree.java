package cap11_Algoritmos_Avancados_e_Estruturas.ArvoreBinaria;


/**
 *  Árvore Binária é uma estrutura de dados que permite armazenar dados e pesquisar de forma eficiênte, esta estrutura é composta
 *  por nós, onde para cada um nó a dois filhos nós, ou seja, a partir do primeiro nó inserido na árvore binária, também denominado de raiz,
 *  este pode ter até dois nós denominados filhos, e o mesmo serve para os filhos da raiz, podem ter dois filhos e assim sucessivamente, até
 *  o ponto em que não haverá mais filhos chegando ao fim da árvore, este por sua vez são chamados de folhas.
 *
 *
 */

public class MainBinaryTree {

    public static void main(String[] args) {

        //Exercicio 1: Implemente uma árvore binária de busca com insert e search
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(20);
        binaryTree.add(15);
        binaryTree.add(30);
        binaryTree.add(10);
        binaryTree.add(17);
        binaryTree.add(25);
        binaryTree.add(33);
        binaryTree.add(5);
        binaryTree.add(11);
        binaryTree.add(19);
        binaryTree.add(23);
        binaryTree.add(27);
        binaryTree.add(31);
        binaryTree.add(40);
        //System.out.println(binaryTree.search(40));

        //Exercicio 2: Implemente percursos de pre ordem, ordem e pos ordem
        binaryTree.preOrder(20).forEach(System.out::println);
//        binaryTree.inOrder(20).forEach(System.out::println);
//        binaryTree.postOrder(20).forEach(System.out::println);

        //Exercicio 3: Implemente deleção
        binaryTree.delete(10);

    }
}
