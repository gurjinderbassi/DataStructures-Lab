
package bst;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Gurjinder
 */
public class BST {

    static Scanner sc = new Scanner(System.in);
 
    static Node root = null;
	static class Node{
		Node lc,rc;
		int data;
		public Node(int data){
			this.data = data;
                        this.rc = null;
                        this.lc = null;
		}
        }
		
    public static void main(String[] args) {        
       while(true){
        System.out.println("\n1. Insertion \n2. Deletion \n3. Print tree \n4. Exit");
        int choice = sc.nextInt();
        Set<Integer> choice1 = new HashSet<>();
        choice1.add(1);
        choice1.add(2);
        choice1.add(3);
        choice1.add(4);
        if(choice1.contains(choice)){
         if(choice==1){
             System.out.println("Enter element:");
             insertion(root,sc.nextInt());
         }
         if(choice==2){ System.out.println("Enter element to delete:");root = deletion(root,sc.nextInt());}
         if(choice==3) printTree(root);
         if(choice==4) return;
        }
        
        else System.out.println("Wrong choice! Please try again");
        
        }
    }
     static void insertion(Node root1,int data){
        
        if(root1==null){
            root = new Node(data);         }
        else if(data<=root1.data){
            if(root1.lc==null) root1.lc=new Node(data);
            else
             insertion(root1.lc,data);
        
        }
        else{
            if(root1.rc==null) root1.rc=new Node(data);
            else
            insertion(root1.rc,data);
        }
    }
    static void printTree(Node root1){
       //System.out.print(root.data+" "+root.lc.data+" "+root.rc.data);
        
            Stack<Node> s = new Stack();
            Node curr = root;
			while(curr!=null || !s.isEmpty()){
				while(curr!=null)
				{
					s.push(curr);
					curr = curr.lc;
				}
				curr = s.pop();
				System.out.print(curr.data+" ");
				
				curr = curr.rc;
			}

        }
    
   
    static Node deletion(Node root1, int data){
      
      if(data<root1.data) root1.lc = deletion(root1.lc,data);
      else if(data>root1.data) root1.rc = deletion(root1.rc,data);
      else{
          if(root1.rc==null) return root1.lc;
          else if(root1.lc==null) return root1.rc;
         root1.data = minVal(root1.rc);
         root1.rc = deletion(root1.rc,root1.data);
      }
      return root1;
     }
    
    static int minVal(Node root1){
       
       Node curr = root1;
       while(curr.lc!=null){
           curr = curr.lc;
       }
       return curr.data;
    }
    }


