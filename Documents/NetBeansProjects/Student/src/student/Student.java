/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Gurjinder
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Student {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Arrays");
       
        frame.setSize(500,500);
        
        JButton search_button = new JButton("Searching");
        search_button.setBounds(100,100,150,50);
        JButton sort_button = new JButton("Sorting");
        sort_button.setBounds(100,200,150,50);
        JButton add_button = new JButton("Add record(s)");
        add_button.setBounds(100,300,150,50);
        
        frame.add(search_button);
        frame.add(sort_button);
//        frame.add(add_button);
        
        frame.setLayout(null);
        frame.setVisible(true);
        search_button.setVisible(true);
        sort_button.setVisible(true);
        add_button.setVisible(true);
        
        sort_button.addActionListener(new ActionListener() {  

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Sorting();
                } catch (IOException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
        
//         add_button.addActionListener(new ActionListener() {  
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            new AddRecord();
//            }
//        });   
//         
         search_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Searching();
//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
       
        
    }
    
}
