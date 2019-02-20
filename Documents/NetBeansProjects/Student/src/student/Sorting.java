/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Gurjinder
 */

public class Sorting implements Serializable {
    
   static  String method = null;
    static String sortBy = null;
    static String nme;
    int id;
    static String[] choice = {"Roll no","Name"};
   static  String[] algo = {"Bubble Sort","Insertion Sort","Selection Sort","Merge Sort","Quick Sort","Shell Sort","Radix Sort"};
    
    static int counter = 0;
     static JComboBox cb2 = new JComboBox(algo);
    static JComboBox cb = new JComboBox(choice);
    static JButton b = new JButton("Sort");
    
    Sorting(int id,String name){ 
        this.id = id;
         nme = name;
       
    }
    
    Sorting() throws FileNotFoundException, IOException, ClassNotFoundException{
    JFrame frame1 = new JFrame("Array(Sorting)");
    frame1.setSize(500,500);
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    panel.setSize(400,400);
    
    cb.setBounds(50,100,90,20);            
    cb2.setBounds(50,200,90,20);
    
    JLabel l1 = new JLabel("Sort by");
    l1.setBounds(30,100,90,20);
    JLabel l2 = new JLabel("Select algorithm");
    l2.setBounds(30,300,90,30);
    
    
    b.setBounds(100,200,90,20);
    frame1.add(b);
    
    panel.add(l1);
    panel.add(cb);
    frame1.add(panel);
    panel.add(l2);
    panel.add(cb2);
   
    
    cb.setVisible(true);
    cb2.setVisible(true);
     
    frame1.setVisible(true);
    frame1.setLayout(null);
    
     b.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {            
            sortBy = (cb.getItemAt(cb.getSelectedIndex()).toString());
            method = (cb2.getItemAt(cb2.getSelectedIndex())).toString();
            
            try {
                //            if(method.equals("Bubble Sort")){
//                BubbleSort(r,sortBy,counter);
//            }
//            else if(method.equals("Selection Sort")){
//                
//            }
//            else if(method.equals("Insertion Sort")){
//            
//            }
                new Sorting1(sortBy,method);
            } catch (IOException ex) {
                Logger.getLogger(Sorting.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Sorting.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }); 
    
    
    
    }
}
//    static void function() throws IOException, ClassNotFoundException{
//        Scanner sc = new Scanner(new File("D:\\stud.txt"));
//         Scanner sc1 =new Scanner(new File("D:\\stud.txt"));
//         String line = null;
//         
//         while(sc.hasNext()){
//             line = sc.next();
//             counter++;
//         }
//         
//    
//    int[] roll = new int[counter];
//        String[] name = new String[counter];
//        String[] record=new String[counter];
//      int i=0;
//        while(sc1.hasNext()){
//                line = sc1.next();
//                record = line.split(",");
//                name[i] = record[0];
//                roll[i] = parseInt(record[1]);
//                i=i+1;
//                
//        }
//        
//        
//        Sorting[] r = new Sorting[roll.length];
//        
//        for(int h=0;h<roll.length;h++){
//            r[h] = new Sorting(roll[h],name[h]);
//           
//           
//        }
//      
//        FileOutputStream fout=new FileOutputStream("D:\\g.txt");  
//        ObjectOutputStream out=new ObjectOutputStream(fout);  
//  
//        for(Sorting sort:r){
//        out.writeObject(sort);  
//        }
//      
//        out.flush();
//  
//        ObjectInputStream in=new ObjectInputStream(new FileInputStream("D:\\g.txt"));  
//        Sorting s=(Sorting)in.readObject();  
//        
//        System.out.println(s.nme+" "+s.id);
//        
//        for(Sorting sort:r)
//            System.out.println(sort.id+" "+sort.nme+" "+sort);  
//         
//        b.addActionListener(new ActionListener() {  
//        public void actionPerformed(ActionEvent e) {            
//            sortBy = (cb.getItemAt(cb.getSelectedIndex()).toString());
//            method = (cb2.getItemAt(cb2.getSelectedIndex())).toString();
//            
//            if(method.equals("Bubble Sort")){
//                BubbleSort(r,sortBy,counter);
//            }
//            else if(method.equals("Selection Sort")){
//                
//            }
//            else if(method.equals("Insertion Sort")){
//            
//            }
//          }
//        });  
//    }
//    
//
//    static void BubbleSort(Sorting[] r, String sortBy,int n){
//        int j=0;
//        Sorting temp;
//        if(sortBy.equals("Roll no")){
//          
//         while(j<r.length-1)
//         {
//         for(int i=0;i<r.length-(j+1);i++){
//             if(r[i].id > r[i+1].id){
//              temp = r[i];
//              r[i] = r[i+1];
//              r[i+1] = temp;
//             }
//         }
//         j=j+1;
//         }
//        }
//        else{
//             while(j<r.length-1)
//         {
//         for(int i=0;i<r.length-(j+1);i++){
//             if(r[i].nme.compareTo(r[i+1].nme)>0){
//              temp = r[i];
//              r[i] = r[i+1];
//              r[i+1] = temp;
//             }
//         }
//         j=j+1;
//         }
//            
//        }
//    for(Sorting sort:r)
//        System.out.println(sort.id+" "+sort.nme); 
//    }

    
    


