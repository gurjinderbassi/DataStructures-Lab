
package bst;

import static java.util.Arrays.sort;
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
    static Node root2 = null;
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
        System.out.println("\n1. Insertion \n2. Deletion \n3. Print tree \n4. Find min \n5. Find max \n6. Ascending order "
                + "\n7. Descending order \n8. Create balanced BST \n9. kth smallest \n10. kth largest \n11. Exit");
        int choice = sc.nextInt();
        Set<Integer> choice1 = new HashSet<>();
        choice1.add(1);
        choice1.add(2);
        choice1.add(3);
        choice1.add(4);
        choice1.add(5);
        choice1.add(6);
        choice1.add(7);
        choice1.add(8);
        choice1.add(9);
        choice1.add(10);
        choice1.add(11);
        if(choice1.contains(choice)){
         if(choice==1){
             System.out.println("Enter element:");
             insertion(root,sc.nextInt());
         }
         if(choice==2){ System.out.println("Enter element to delete:");root = deletion(root,sc.nextInt());}
         if(choice==3) printInorder(root);
         if(choice==4) findmin(root); 
         if(choice==5) findmax(root);
         if(choice==6) printInorder(root);
         if(choice==7) printDesc(root);
         if(choice==8) {balBst(root2); }
         if(choice==9) findkmin(root);
         if(choice==10) findkmax(root);
         if(choice==11) return;
        }
        
        else System.out.println("Wrong choice! Please try again");
        
        }
    }
    static void findkmin(Node node){
        if(node==null) return;
        System.out.println("Enter k:");
        int k = sc.nextInt();
        Stack<Node> s = new Stack<>();
        Node curr = node;
        while(curr!=null || !s.isEmpty()){
        while(curr!=null){
            s.push(curr);
            curr = curr.lc;
           
        }
        curr = s.pop();
        k--;
        if(k==0){System.out.println(curr.data); break;}
        curr = curr.rc;
        }
//        System.out.println("Minimum value is "+curr.data);
        
    }
    static void findkmax(Node node){
        
    }
    static void balBst(Node node){
        int n;
        System.out.println("Enter number of elements:");
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<arr.length;i++) arr[i] = sc.nextInt();
        sort(arr);
        root2 = createBalbst(node,arr,0,n-1);
        printInorder(root2);
//        System.out.println(root2.lc.data);
        
    }
    static Node createBalbst(Node node,int[] arr,int start,int end){
       if(start>end) return null;
        int mid = (start+end)/2;
        node = new Node(arr[mid]);
        
            node.lc = createBalbst(node.lc,arr,start,mid-1);
            node.rc = createBalbst(node.rc,arr,mid+1,end);
        
        return node;
    }
    static void printDesc(Node node){
        if(node==null) return;
        Node curr = node;
        Stack<Node> s = new Stack<>();
        while(curr!=null || !s.isEmpty()){
            while(curr!=null){
                s.push(curr);
                curr=curr.rc;
            }
            curr = s.pop();
            System.out.print(curr.data+" ");
            curr = curr.lc;
        }
    }
    static void findmin(Node node){
        if(node==null) return;
        Node curr = node;
        while(curr.lc!=null){
            curr = curr.lc;
        }
        System.out.println("Minimum value is "+curr.data);
    }
    static void findmax(Node node){
        if(node==null) return;
        Node curr = node;
        while(curr.rc!=null){
            curr = curr.rc;
        }
        System.out.println("Maximum value is "+curr.data);
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
    static void printInorder(Node root1){
       //System.out.print(root.data+" "+root.lc.data+" "+root.rc.data);
        
            Stack<Node> s = new Stack();
            Node curr = root1;
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


