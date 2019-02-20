/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static student.Sorting.counter;

/**
 *
 * @author Gurjinder
 */
public class Sorting1 extends JFrame implements Serializable {

   
    int id;
    String name;
    
    static String[] names = null;
    static int[] rolls;
    static int start=0;
    static int end;
    Scanner sc1;
    Sorting1(int id,String name){
        this.id=id;
        this.name=name;
        
    }
    Sorting1(String sortBy,String method) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        
        
        Scanner sc = new Scanner(new File("D:\\stud.txt"));
        sc1 =new Scanner(new File("D:\\stud.txt"));
         String line = null;
         
         while(sc.hasNext()){
             line = sc.next();
             counter++;
         }
         
    
        int[] roll = new int[counter];
        String[] name = new String[counter];
        String[] record=new String[counter];
        end = counter-1;
        int i=0;
        while(sc1.hasNext()){
                line = sc1.next();
                record = line.split(",");
                name[i] = record[0];
                roll[i] = parseInt(record[1]);
                i=i+1;
                
        }
        
        sc1.close();
        Sorting1[] r = new Sorting1[roll.length];
        
        for(int h=0;h<roll.length;h++){
            r[h] = new Sorting1(roll[h],name[h]);
           
           
        }
      
        FileOutputStream fout=new FileOutputStream("D:\\g.txt");  
        ObjectOutputStream out=new ObjectOutputStream(fout);  
  
        for(Sorting1 sort:r){
        out.writeObject(sort);  
        }
      
        out.flush();
  
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("D:\\g.txt"));  
        Sorting1 s=(Sorting1)in.readObject();  
        
        System.out.println(s.name+" "+s.id);
        
        for(Sorting1 sort:r)
            System.out.println(sort.id+" "+sort.name+" "+sort);  
         
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
        
        if(method.equals("Bubble Sort")){
            BubbleSort(r,sortBy,counter);
        }
        else if(method.equals("Selection Sort")){
            SelectionSort(r,sortBy,counter);
        }
        else if(method.equals("Insertion Sort")){
            InsertionSort(r,sortBy,counter);
        }
        else if(method.equals("Merge Sort")){
            mergeSort(r,sortBy,start,end,counter);
        }
        else if(method.equals("Quick Sort")){
            quickSort(r,sortBy,start,end,counter);
        }
        else if(method.equals("Shell Sort")){
            shellSort(r,sortBy,start,end,counter);
        }
        else if(method.equals("Radix Sort")){
            radixSort(r,sortBy,counter);
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\stud.txt"));
        for(int k=0;k<counter;k++){
        writer.write(names[k]+","+rolls[k]);
        writer.newLine();
        }
        writer.close();
        JFrame f = new JFrame("Result");
//        f.setSize(200,200);
//        f.setVisible(false);
        JDialog d = new JDialog(f , "Results", true);  
        d.setLayout( new FlowLayout() );  
        d.add(new JLabel("File sorted successfully"));
        d.add(new JLabel("Number of swaps by "+method+": "+swaps));
        d.add(new JLabel("Number of comparisons: "+cmp));
        JButton close_button = new JButton("Close");
        d.add(close_button);
        close_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               d.setVisible(false);
            }
        });
        d.setSize(300,200);
        d.setVisible(true);
    }
    
    static int swaps=0;
    static int cmp = 0;
    static void BubbleSort(Sorting1[] r, String sortBy,int n){
        int j=0;
        Sorting1 temp;
        if(sortBy.equals("Roll no")){
          
         while(j<r.length-1)
         {
         for(int i=0;i<r.length-(j+1);i++){
             if(r[i].id > r[i+1].id){
              temp = r[i];
              r[i] = r[i+1];
              r[i+1] = temp;
              
              swaps++;
             }
             cmp++;
         }
         j=j+1;
         
         }
        }
        else{
             while(j<r.length-1)
         {
         for(int i=0;i<r.length-(j+1);i++){
             if((r[i].name).compareTo(r[i+1].name)>0){
              temp = r[i];
              r[i] = r[i+1];
              r[i+1] = temp;
              swaps++;
             }
             cmp++;
         }
         j=j+1;
         }
            
        }
       
        int k=0;
        names = new String[counter];
        rolls = new int[counter];
    for(Sorting1 sort:r){
        System.out.println(sort.id+" "+sort.name); 
        names[k] = sort.name;
        rolls[k] = sort.id;
        k++;
        
    }
    }
    
    static void InsertionSort(Sorting1[] r,String sortBy,int counter){
        int i,j;
        int k=0;
        names = new String[counter];
        rolls = new int[counter];
        Sorting1 num,temp;
        if(sortBy.equals("Roll no")){
        for(i=1;i<counter;i++){
            num = r[i];
            for(j=i-1;j>=0;j--){
                if(r[j].id>num.id){
                    temp = r[j];
                    r[j] = r[i];
                    r[i] = temp;
                    swaps++;
                }
                cmp++;
            }
        }
        }
        else {
            for(i=1;i<counter;i++){
                num = r[i];
                for(j=i-1;j>=0;j--){
                    if((r[j].name).compareTo(num.name)>0){
                    temp = r[j];
                    r[j] = r[i];
                    r[i] = temp;
                    swaps++;
                    }
                cmp++;
                }
            }
        }
        for(Sorting1 sort:r){
        System.out.println(sort.id+" "+sort.name); 
        names[k] = sort.name;
        rolls[k] = sort.id;
        k++;
        
    }
    }
    
    static void SelectionSort(Sorting1[] r,String sortBy,int counter){
        int i=0,j,k=0,start;
        int indexOfMin;
        Sorting1 temp;
        names = new String[counter];
        rolls = new int[counter];
        while(i<counter-1){
              start = i;
              indexOfMin = findMin(r,start,counter,sortBy);
              
              temp = r[indexOfMin];
              r[indexOfMin] = r[i];
              r[i] = temp;
              swaps++;
              i++;
              
    }   
        
        for(Sorting1 sort:r){
        System.out.println(sort.id+" "+sort.name); 
        names[k] = sort.name;
        rolls[k] = sort.id;
        k++;
    }
    }
    
    static int findMin(Sorting1[] r,int start,int counter,String sortBy){
         Sorting1 m = r[start];
         int index = start;
         if(sortBy.equals("Roll no")){
      for(int i=start;i<counter;i++){
         if(r[i].id<m.id){
             m = r[i];
             index = i;
         }
         cmp++;
      }
         System.out.println(index);}
        else{
         for(int i=start;i<counter;i++){
         if(r[i].name.compareTo(m.name)>0){
             m = r[i];
             index = i;
         }
         cmp++;
      } 
         }
      return index;
    }
    
    static void mergeSort(Sorting1[] r,String sortBy,int start,int end,int counter){
        if(start<end){
        int mid = (start+end-1)/2;
        
        mergeSort(r,sortBy,start,mid,counter);
        mergeSort(r,sortBy,mid+1,end,counter);
        merge(r,sortBy,start,mid,end,counter);
        }
    }
    static void merge(Sorting1[] r,String sortBy,int start,int mid,int end,int counter){
        int i,j,k;
        int n1 = mid-start+1;
        int n2 = end-mid;
        
        names = new String[counter];
        rolls = new int[counter];
        
        Sorting1[] left = new Sorting1[n1];
        Sorting1[] right = new Sorting1[n2];
        
        for(i=0;i<n1;i++) left[i] = r[start+i];
        for(j=0;j<n2;j++) right[j] = r[mid+1+j];
        
        i=0;
        j=0;
        k=start;
        
        if(sortBy.equals("Roll no")){
        while(i<n1 && j<n2){
            cmp++;
         if(left[i].id <= right[j].id){
             r[k] = left[i];
             i++;
         }   
         else{
             r[k]=right[j];
             j++;
         }
         k++;
        }
        while(i<n1){
            r[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            r[k] = right[j];
            j++;
            k++;
        }
        }
        else{
            while(i<n1 && j<n2){
            cmp++;
         if(left[i].name.compareTo(right[j].name)<=0){
             r[k] = left[i];
             i++;
         }   
         else{
             r[k]=right[j];
             j++;
         }
         k++;
        }
        while(i<n1){
            r[k] = left[i];
            i++;
            k++;
        }
        while(j<n2){
            r[k] = right[j];
            j++;
            k++;
        }
        }
        int l=0;
         for(Sorting1 sort:r){
        System.out.println(sort.id+" "+sort.name); 
        names[l] = sort.name;
        rolls[l] = sort.id;
        l++;
    }
                
    }
    
    static void quickSort(Sorting1[] r,String sortBy,int start,int end,int counter){
//        start = 0;
//        end = counter-1;
        if(start<=end){
            int index = partition(r,sortBy,start,end,counter);
            System.out.println(index);
            quickSort(r,sortBy,start,index-1,counter);
            quickSort(r,sortBy,index+1,end,counter);
        }
        
    }
   static int partition(Sorting1[] r,String sortBy,int start,int end,int counter){
       Sorting1 x; //Pivot element
       Sorting1 temp;
       x = r[end];
       swaps = 0;
       names = new String[counter];
       rolls = new int[counter];
       int i=-1,j;
       if(sortBy.equals("Roll no")){
           for(j=0;j<end;j++){
               cmp++;
              if(r[j].id<=x.id){
                  ++i;
                  temp = r[j];
                  r[j] = r[i];
                  r[i] = temp;
                  swaps++;
                  
              } 
           }
           temp = r[i+1];
           r[i+1] = x;
           x = temp;
       }
       else if(sortBy.equals("Name")){
           for(j=0;j<end;j++){
               cmp++;
               if(r[j].name.compareTo(x.name)<=0){
                   ++i;
                   temp = r[j];
                   r[j] = r[i];
                   r[i] = temp;
                   swaps++;
               }
           }
           temp = r[i+1];
           r[i+1] = r[end];
           r[end] = temp;
           
       }
        int l=0;
        for(Sorting1 sort:r){
        System.out.println(sort.id+" "+sort.name); 
        names[l] = sort.name;
        rolls[l] = sort.id;
        l++;
         }
        
       return (i+1);
   }
   static void shellSort(Sorting1[] r,String sortBy,int start,int end,int counter){
       names = new String[counter];
       rolls = new int[counter];
       int h;
       if(sortBy.equals("Roll no")){
       for(h = counter/2;h>0;h/=2){
       for(int i=h;i<counter;i++){
           Sorting1 temp = r[i];
           int j;
          
           for(j=i;j>=h && r[j-h].id>temp.id;j-=h){
               r[j] = r[j-h];
                cmp++;
                
           }
           r[j] = temp;
           swaps++;
           
       }
       }
       }
       else{
           for(h=counter/2;h>0;h/=2){
               for(int i=h;i<counter;i++){
                   Sorting1 temp = r[i];
                   int j;
                   for(j=i;j>=h&&r[j-h].name.compareTo(temp.name)>0; j-=h){
                       r[j] = r[j-h];
                       cmp++;
                       
                   }
                   r[j] = temp;
                   swaps++;
               }
           }
       }
       int l=0;
        for(Sorting1 sort:r){
        System.out.println(sort.id+" "+sort.name); 
        names[l] = sort.name;
        rolls[l] = sort.id;
        l++;
         }
   }
   static void radixSort(Sorting1[] r,String sortBy,int counter){
       names = new String[counter];
       rolls = new int[counter];
       int mul=1;
       int max = findMax(r,sortBy,counter);
       while(max!=0){
           countSort(r,sortBy,counter,mul);
           mul*=10;
           max/=10;
       }
       int l=0;
        for(Sorting1 sort:r){
        System.out.println(sort.id+" "+sort.name); 
        names[l] = sort.name;
        rolls[l] = sort.id;
        l++;
         }
   }
   static void countSort(Sorting1[] r,String sortBy,int counter,int place){
       int[] freq = new int[10];
       Sorting1[] output = new Sorting1[counter];
       int i;
       for(i=0;i<counter;i++)
           freq[(r[i].id/place)%10]++;
       for(i=1;i<10;i++)
           freq[i]+=freq[i-1];
       for(i=counter-1;i>=0;i--){
           output[freq[(r[i].id/place)%10]-1]= r[i];
           freq[(r[i].id/place)%10]--;
           
       }
       for(i=0;i<counter;i++){
           r[i] = output[i];
       }
   }
   static int findMax(Sorting1[] r,String sortBy,int counter){
       int i;
       int max = r[0].id;
       for(i=1;i<counter;i++){
           if(r[i].id>max){
               max = r[i].id;
           }
       }
       return max;
       
           
   }
}
  
    

