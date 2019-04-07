/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Gurjinder Kaur
 */
public class Graph {

    private int V;   
    private LinkedList<Integer> adj[];  
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
   void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
    } 
    public static void main(String[] args) {
        Graph g = new Graph(5); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2);
        g.addEdge(1,4);
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        g.addEdge(3,4);
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose algorithm:\n1. BFS 2. DFS");
        int choice = sc.nextInt();
        switch(choice){
            case 1: 
                System.out.println("Enter source vertex:");
                int s = sc.nextInt();
                g.bfs(s);
                break;
            case 2:
                System.out.println("Enter source vertex:");
                s = sc.nextInt();
                g.dfs(s);
                break;
        }
  
    }
    void bfs(int s){
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[s] = true;
        q.add(s);
        while(q.size()!=0){
            s = q.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    q.add(n); 
                } 
            } 
        }
    }
    void dfs(int s){
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(s);
        while(!stack.isEmpty()){
            s = stack.pop();
            if(visited[s]==false){
                System.out.print(s+" ");
                visited[s] = true;
            }
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    stack.push(n);
                }
            }
        }
    }
}
