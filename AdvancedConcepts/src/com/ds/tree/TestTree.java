package com.ds.tree;

import java.util.Scanner;

/**
 *
 */
public class TestTree {

    public static void main(String[] args) {
      /**  Node<String, HashMapChildren<String, HashMapChildren>> hashMapNode = new Node<String, HashMapChildren<String, HashMapChildren>>();
        Node<String, ArrayListChildren<String, ArrayListChildren>> arrayListNode = new Node<String, ArrayListChildren<String, ArrayListChildren>>();

        Node<String, HashMapChildren> hashMapNode1 = new Node<String, HashMapChildren>();
        Node<String, ArrayListChildren> arrayListNode1 = new Node<String, ArrayListChildren>();
        hashMapNode1.getChildren().addChild(arrayListNode1);

        HashMapChildren<String, HashMapChildren> hmc = hashMapNode.getChildren();
        hmc.addChild(hashMapNode1);
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter stop to stop");

        boolean anyInput = true;
        String input;

        while(anyInput){
           input = scanner.next();
            if(input.equals("stop")){
               anyInput = false;
            }else{
                System.out.println("You entered : " + input);
            }
        }

    }
}
