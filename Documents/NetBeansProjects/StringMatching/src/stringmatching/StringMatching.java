/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringmatching;

import java.util.Scanner;

/**
 *
 * @author Gurjinder Kaur
 */
public class StringMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pat,text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        text = sc.nextLine();
        System.out.println("Enter pattern to search:");
        pat = sc.nextLine();
        System.out.println("Choose algorithm:\n1. Naive 2. KMP 3. Rabin Karps 4. Finite automata");
        int choice = sc.nextInt();
        if(choice == 1) naive(text,pat);
        else if (choice==2) kmp(text,pat);
        else if(choice ==3) rabinkarps(text,pat);
        else if(choice == 4) finiteautomata(text,pat);
        else {
            System.out.println("Wrong choice!");
        }
    }
    
    static void naive(String txt,String pat){
        int n = txt.length();
        int m = pat.length();
        for (int i = 0; i <= n-m; i++) { 
  
            int j; 
            for (j = 0; j < m; j++) 
                if (txt.charAt(i + j) != pat.charAt(j)) 
                    break; 
  
            if (j == m) 
                System.out.println("Pattern found at index " + i); 
        } 
    }
    static void kmp(String txt, String pat){
        int m = pat.length();
        int n = txt.length();
        int pf[]=new int[m];
        int j=0;
        int i=0;
        calprefix(pat,m,pf);
        System.out.println("Prefix function:");
        for(int k:pf) System.out.print(k+" ");
        while(i<n){
            if(pat.charAt(j)==txt.charAt(i)){
                i++;
                j++;
            }
            if(j==m){
                System.out.println("Pattern found at index "+(i-j));
                j = pf[j-1];
            }
            else if(i<n && pat.charAt(j)!=txt.charAt(i)){
                if(j!=0)
                    j = pf[j-1];
                else
                    i=i+1;
            }
        }
    }
    static void calprefix(String pat,int m,int[] pf){
        int len=0;
        int i=1;
        pf[0]=0;
        while(i<m){
            if(pat.charAt(len)==pat.charAt(i)){
                len++;
                pf[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len = pf[len-1];
                }
                else{
                    pf[i] = len;
                    i++;
                }
            }
        }
        
    }
    static void rabinkarps(String txt,String pat){
        
    }
    static void finiteautomata(String txt,String pat){
        
    }
    
}
