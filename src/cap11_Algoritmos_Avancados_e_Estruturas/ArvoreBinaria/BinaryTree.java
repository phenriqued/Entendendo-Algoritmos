package cap11_Algoritmos_Avancados_e_Estruturas.ArvoreBinaria;

import cap11_Algoritmos_Avancados_e_Estruturas.ArvoreBinaria.Node.NodeTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {

    private NodeTree<T> root;
    private int degreeOfNo;
    public BinaryTree(T root) {
        this.root = new NodeTree<>(root);
        this.degreeOfNo = 1;
    }
    public BinaryTree() {
        this.degreeOfNo = 0;
    }

    public int getDegreeOfNo() {
        return degreeOfNo;
    }
    public T getRoot() {
        return root.getData();
    }

    public void add(T node){
        NodeTree<T> no = new NodeTree<>(node);
        if(degreeOfNo < 1){
            this.root = no;
            degreeOfNo += 1;
            return;
        }
        NodeTree<T> father = root;
        while (true) {
            int comparable = father.comparable(node);

            if (comparable < 0) {
                if (father.getRight() == null) {
                    father.setRight(no);
                    break;
                }
                father = father.getRight();
            } else if (comparable > 0){
                if (father.getLeft() == null) {
                    father.setLeft(no);
                    break;
                }
                father = father.getLeft();
            }else {
                throw new IllegalArgumentException("It is not possible to add identical value in the tree.");
            }
        }
        degreeOfNo ++;
    }

    public NodeTree<T> find(T node){
        if (node.equals(root.getData())){
            return root;
        }

        NodeTree<T> father = root;
        while (true){
            if (father.comparable(node) < 0){
                if (father.getRight() == null){
                    return null;
                }else if (father.getRight().getData().equals(node)){
                    return father.getRight();
                }
                father = father.getRight();
            }else {
                if (father.getLeft() == null){
                    return null;
                }else if (father.getLeft().getData().equals(node)){
                    return father.getLeft();
                }
                father = father.getLeft();
            }
        }
    }

    public T search(T node){
        if (node.equals(root.getData())){
            return root.getData();
        }
        return search(root, node);
    }
    public T search(NodeTree<T> node, T value){
        int comparable = node.comparable(value);
        if (comparable < 0){
            if (node.getRight() == null) return null;

            return search(node.getRight(), value);
        }else if (comparable > 0){
            if (node.getLeft() == null) return null;

            return search(node.getLeft(), value);
        }else {
            if (node.getData() == value){
                return node.getData();
            }else {
                return null;
            }
        }
    }


    public Boolean delete(T node){
        try{
            this.root = delete(this.root, node);
            degreeOfNo -= 1;
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private NodeTree<T> delete(NodeTree<T> node, T value){
        if (Objects.isNull(node)) throw new IllegalArgumentException("It is not possible to delete a value that does not exist in the tree!");

        if(node.comparable(value) > 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (node.comparable(value) < 0) {
            node.setRight(delete(node.getRight(), value));
        }else {

            if (node.getLeft() == null && node.getRight() == null){
                return null;
            } else if (node.getLeft() != null && node.getRight() != null) {
                var nodeMin = findMin(node.getRight());
                node.setData(nodeMin.getData());
                node.setRight(delete(node.getRight(), nodeMin.getData()));
            }else {
                if (node.getLeft() != null && node.getRight() == null){
                    return node.getLeft();
                }else {
                    return node.getRight();
                }
            }

        }
        return node;
    }

    private NodeTree<T> findMin(NodeTree<T> value){
        while (value.getLeft() != null){
            value = value.getLeft();
        }
        return value;
    }


    public List<T> inOrder(T source){
        List<T> nodeTrees = new ArrayList<>();
        return inOrder(find(source), nodeTrees);
    }
    private List<T> inOrder(NodeTree<T> source, List<T> nodeTrees){
        if (Objects.nonNull(source)){
            inOrder(source.getLeft(), nodeTrees);
            nodeTrees.add(source.getData());
            inOrder(source.getRight(), nodeTrees);
        }
        return nodeTrees;
    }

    public List<T> preOrder(T source){
        List<T> nodeTrees = new ArrayList<>();
        return preOrder(find(source), nodeTrees);
    }
    private List<T> preOrder(NodeTree<T> source, List<T> nodeTrees){
        if (Objects.nonNull(source)){
            nodeTrees.add(source.getData());
            preOrder(source.getLeft(), nodeTrees);
            preOrder(source.getRight(), nodeTrees);
        }
        return nodeTrees;
    }

    public List<T> postOrder(T source){
        List<T> nodeTrees = new ArrayList<>();
        return postOrder(find(source), nodeTrees);
    }
    private List<T> postOrder(NodeTree<T> source, List<T> nodeTrees){
        if (Objects.nonNull(source)){
            postOrder(source.getLeft(), nodeTrees);
            postOrder(source.getRight(), nodeTrees);
            nodeTrees.add(source.getData());
        }
        return nodeTrees;
    }




}
