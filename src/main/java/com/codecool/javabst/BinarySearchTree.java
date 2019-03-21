package com.codecool.javabst;

import java.util.ArrayList;

public class BinarySearchTree {

    private Node actualNode;

    private Node createBinaryTree(ArrayList<Integer> numbers, int startNode, int endNode) {
        if (startNode > endNode) {
            return null;
        }
        int middleNode = startNode + (endNode - startNode) / 2;
        Node node = new Node(numbers.get(middleNode));
        node.setLeft(createBinaryTree(numbers, startNode, middleNode - 1));
        node.setRight(createBinaryTree(numbers, middleNode + 1, endNode));
        return node;
    }

    public void build(ArrayList<Integer> numbers) {
        actualNode = createBinaryTree(numbers, 0, numbers.size() - 1);
        System.out.println(actualNode);
    }


    public boolean search(Integer toFind) {
        Node actualNode = this.actualNode;
        while (actualNode != null) {
            if (!toFind.equals(actualNode.getValue())) {
                if (toFind > actualNode.getValue()) {
                    actualNode = actualNode.getRight();
                } else {
                    actualNode = actualNode.getLeft();
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public void add(Integer toAdd) {
        Node actualNode = this.actualNode;
        while (actualNode != null) {
            if (!toAdd.equals(actualNode.getValue())) {
                if (toAdd > actualNode.getValue()) {
                    if (actualNode.getRight() != null) {
                        actualNode = actualNode.getRight();
                    } else {
                        actualNode.setRight(new Node(toAdd));
                        break;
                    }
                } else {
                    if (actualNode.getLeft() != null) {
                        actualNode = actualNode.getLeft();
                    } else {
                        actualNode.setLeft(new Node(toAdd));
                        break;
                    }
                }
            }
        }
    }

    public void remove(Integer toRemove) {
        Node actualNode = this.actualNode;
        while (actualNode != null) {
            if (toRemove.equals(actualNode.getValue())) {
                actualNode.setValue(null);
            } else if (toRemove > actualNode.getValue()) {
                if (toRemove.equals(actualNode.getRight().getValue())) {
                    actualNode.setRight(null);
                }
                actualNode = actualNode.getRight();
            } else {
                if (toRemove.equals(actualNode.getLeft().getValue())) {
                    actualNode.setLeft(null);
                }
                actualNode = actualNode.getLeft();

            }
        }
    }
}
