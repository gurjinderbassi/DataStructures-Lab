/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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
public class AddRecord implements Serializable {
    
    int id;
    String name;
    
    AddRecord(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    AddRecord() {
        JFrame frame = new JFrame("Add records");
         JPanel p = new JPanel();
         JTextField t1 = new JTextField();
         JTextField t2 = new JTextField();
         t1.setBounds(100,100,120,30);
         t2.setBounds(100,200,120,30);
         frame.setSize(500,600);
         frame.add(t1);
         frame.add(t2);
         JLabel l1 = new JLabel("Roll no");
         l1.setBounds(20,100,50,30);
         JLabel l2 = new JLabel("Name");
         l2.setBounds(20,200,120,30);
         JButton b = new JButton("Add");
         b.setBounds(50,300,90,50);
         
         b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    add_record(l1.getText(), l2.getText());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AddRecord.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
             
         });
        
         frame.add(l1);
         frame.add(l2);
         frame.add(b);
         
         
         frame.setLayout(null);
         frame.setVisible(true);
        
       
    }
     static void add_record(String rollno, String name ) throws FileNotFoundException{
         Scanner sc = new Scanner(new File("D:\\student.txt"));
         Scanner sc1 =new Scanner(new File("D:\\student.txt"));
         String line = null;
         int counter = 0;
         while(sc.hasNext()){
             line = sc.next();
             counter++;
         }
         sc.close();
         
         
         
         
         
         System.out.print(counter);
         
         
         
     }
    
}
