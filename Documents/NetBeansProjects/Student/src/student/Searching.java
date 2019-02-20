/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static student.Sorting1.swaps;

/**
 *
 * @author Gurjinder
 */
public class Searching implements Serializable {
    static String search_by;
    static String[] name;
    static int[] id;
    static JLabel l = new JLabel();
    static JLabel l2 = new JLabel();
    static JFrame f = new JFrame("Searching");
    static JFrame f1 = new JFrame("Result");
    static JFrame f2 = new JFrame("Result");
    static int n=0,cmp=0;
    static JButton linear_button;
    static JButton binary_button;
    static JDialog d = new JDialog(f1 , "Results", true); 
    static JDialog d2 = new JDialog(f2 , "Results", true); 
    Searching() throws FileNotFoundException{
       
        
        JLabel l1 = new JLabel("Search by:");
        String[] str = {"Roll no","Name"};
        JComboBox cb = new JComboBox(str);
        JPanel p = new JPanel(new FlowLayout(SwingConstants.LEADING,10,10));
         f.add(p);
         linear_button = new JButton("Linear Search");
         binary_button =new JButton("Binary Search");
         
         
        p.setBounds(0,0,500,500);
       
        
        //JLabel l2 = new JLabel("Roll no: ");
        //JLabel l3 = new JLabel("Name ");
        JTextField t1 = new JTextField(8);
        t1.setBounds(100, 10, 100, 40);
        //JTextField t2 = new JTextField();
        JButton b = new JButton("Search");
         l.setBounds(50,400,200,40);
         p.add(l1);
          p.add(cb);
            p.add(t1);
        linear_button.setBounds(50,300,90,40);
        binary_button.setBounds(50,400,90,40);
       
        p.add(linear_button);
        p.add(binary_button);
        p.add(l);
        p.add(l2);
        l.setVisible(false);
        l2.setVisible(false);
        
        d.setLayout( new FlowLayout() );
        d2.setLayout( new FlowLayout() );
        
        JButton close_button = new JButton("Close");
        JButton close_button2 = new JButton("Close");
        d.add(close_button);
        close_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               d.setVisible(false);
            }
        });
        d2.add(close_button2);
        close_button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               d2.setVisible(false);
            }
        });
        d.setSize(300,200);
        d2.setSize(300,200);
       
        
       // f.add(t2);
        f.setSize(600,600);
        f.setLayout(null);
        f.setVisible(true);
        
        binary_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                String key = t1.getText().toString();
                System.out.println(key);
                search_by = (cb.getItemAt(cb.getSelectedIndex())).toString();
                d2.setVisible(true);
                try {
                    binarySearch(search_by,key);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                d2.add(new JLabel("Number of comparisons "+cmp));
            }
        });
        
        linear_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String key = t1.getText().toString();
                    System.out.println(key);
                    search_by = (cb.getItemAt(cb.getSelectedIndex())).toString();
//                    System.out.print(search_by);
                    d.setVisible(true);
                try {
                    linearSearch(search_by,key);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                    d.add(new JLabel("Number of comparisons "+cmp));
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
      
        
    }
    static void linearSearch(String search_by,String key) throws FileNotFoundException{
        readFile();
        int k,j=0,flag=0;
        int[] foundid = new int[id.length];
        String[] foundname = new String[name.length];
        if(search_by.equals("Roll no")){
               d.add(new JLabel("Linear Search:"));
              k = parseInt(key);
              for(int i=0;i<id.length;i++){
                  cmp++;
                  if(id[i]==k){
//                      n++;
                      foundid[j] = id[i];
                      foundname[j]=name[i];
                      flag=1;
                      d.add(new JLabel("Record found: "+foundid[j]+","+foundname[j]));
                     return;
                  }
                  
                  
              }
             
              
        }
        else{
            for(int i=0;i<name.length;i++){
                cmp++;
                if(name[i].equals(key)){
//                     n++;
                      foundid[j] = id[i];
                      foundname[j]=name[i];
                      flag=1;
                      d.add(new JLabel("Record found: "+foundid[j]+","+foundname[j]));
                     return;
                
            }
           
            }
        }
        
        if(flag==0)
            d.add(new JLabel("Record not found"));
       
    }
    static void binarySearch(String search_by,String key) throws FileNotFoundException{
         n=0;
        cmp=0;
        readFile();
      
        int tot = id.length;
        
        int beg=0,end=tot;
        int mid;
        int k,flag=0;
        k = parseInt(key);
        
        String s = key.toString();
        
        if(search_by.equals("Roll no")){
        d2.add(new JLabel("Binary Search:"));
        while(beg<=end){
            mid = (beg+end-1)/2;
            cmp++;
        if(id[mid]==k){
            d2.add(new JLabel("Record found:"+id[mid]+","+name[mid]));
            
            flag = 1;
            return;
        }
        else if(k<id[mid]){
            end = mid-1;
        }
        else if(k>id[mid]){
            beg = mid+1;
        }
     }
        if(flag == 0){
            d2.add(new JLabel("Record not found"));
        }
       
        
    }
        else if(search_by.equals("Name")){
       d2.add(new JLabel("Binary Search:"));
        while(beg<=end){
            mid = (beg+end-1)/2;
            cmp++;
        if(name[mid].equals(s)){
            d2.add(new JLabel("Record found:"+name[mid]+","+id[mid]));
            
            flag = 1;
            return;
        }
        else if((s.compareTo(name[mid]))<0){
            end = mid-1;
        }
        else {
            beg = mid+1;
        }
        
        
        }
        if(flag == 0){
            d2.add(new JLabel("Record not found"));
        }
       
        
    }
        
    }
    static void readFile() throws FileNotFoundException{
         Scanner sc = new Scanner(new File("D:\\stud.txt"));
         String line;
         int counter = 0;
         while(sc.hasNext()){
             line = sc.next();
             counter++;
         }
         sc.close();
         Scanner sc1 = new Scanner(new File("D:\\stud.txt"));
         line = null;
         name=new String[counter];
         id = new int[counter];
         int i=0;
         String[] record;
         while(sc1.hasNext())
         {
             line = sc1.next();
             record = line.split(",");
             name[i] = record[0];
             id[i] = parseInt(record[1]);
             i=i+1;
         }
             }
    
    
}
