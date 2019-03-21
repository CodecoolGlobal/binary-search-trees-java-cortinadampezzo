package com.codecool.javabst;

import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            numbers.add(i * 2 + 5);
        }

        BinarySearchTree myTree = new BinarySearchTree();
        myTree.build(numbers);

        // write some test code here
        System.out.println(numbers);
        System.out.println("==========================");
        System.out.println("Contains 7: " + myTree.search(7)); // should be true
        System.out.println("Contains 55: " + myTree.search(55)); // should be true
        System.out.println("Contains 34535: " + myTree.search(34535)); // should be false
        System.out.println("==========================");
        System.out.println("Before added 3: " + myTree.search(3)); //should be false
        myTree.add(3);
        System.out.println("After added 3: " + myTree.search(3)); //should be true
        myTree.remove(3);
        System.out.println("After removed 3: " + myTree.search(3)); //should be false
        System.out.println("==========================");
        System.out.println("done");
    }
}