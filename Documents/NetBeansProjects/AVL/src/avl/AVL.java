/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.util.Stack;

/**
 *
 * @author Gurjinder
 */
public class AVL {
   Node root;
   static class Node{
       int key;
       Node left,right;
       int height;
       Node(int data){
           key = data;
           left = right = null;
           height = 0;
       }
   }
   
   int height(Node node){
       if(node==null) return 0;
       return node.height;
           
   }
   
   int max(int a,int b){
       return (a>b)?a:b;
   }
   int getBalance(Node node){
       if(node==null) return 0;
       return height(node.left)-height(node.right);
   }
   Node insert(Node node,int  key){
       if (node == null) 
            return (new Node(key)); 
  
        if (key < node.key) 
            node.left = insert(node.left, key); 
        else if (key > node.key) 
            node.right = insert(node.right, key); 
        else 
            return node; 
       node.height = 1 + max(height(node.left), 
                              height(node.right)); 
       
       int balance = getBalance(node);
       
       System.out.println("Balance factor of node "+node.key+" = "+balance);
       
       return node;
   }
    public static void main(String[] args) {
        AVL tree = new AVL(); 
  
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        System.out.println();
        tree.root = tree.insert(tree.root, 20); 
        System.out.println();
        tree.root = tree.insert(tree.root, 30); 
        System.out.println();
        tree.root = tree.insert(tree.root, 40); 
        System.out.println();
        tree.root = tree.insert(tree.root, 50); 
        System.out.println();
        tree.root = tree.insert(tree.root, 25); 
        
        System.out.println();
        tree.printTree(tree.root);
    }
    public  void printTree(Node root1){
       //System.out.print(root.data+" "+root.lc.data+" "+root.rc.data);
        
            Stack<Node> s = new Stack();
            Node curr = root;
			while(curr!=null || !s.isEmpty()){
				while(curr!=null)
				{
					s.push(curr);
					curr = curr.left;
				}
				curr = s.pop();
				System.out.print(curr.key+" ");
				
				curr = curr.right;
			}

        }
}
