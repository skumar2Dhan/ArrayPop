/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysorttest;

import static arraysorttest.QuickSort.quickSort;
import java.lang.Math;
import java.util.Arrays;
public class ArraySortTest {

   
    public static void SelectionSort(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            
            int index = i;
            for (int z = i + 1; z < array.length; z++) {
                if (array[z] < array[index]) 
                    index = z;
                
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
    }
    
    public static void BubbleSort(int[] array1) {
        int temp;
        int size = array1.length;
        for (int i = 0; i < size ; i++) {
            
            for (int j =1; j < size; j++) {
                if (array1[j] < array1[j - 1]) {
                    temp = array1[j];
                    array1[j] = array1[j - 1];
                    array1[j - 1] = temp;
                    
                }
            }
        }
    }
    
    
    




    public static void main(String[] args) {
        int[] array1= new int[200000];
        int[] array2= new int[200000];
        int[] array3= new int[200000];
        int x=200000;
        for(int i=0; i<200000 ;i++){
            array1[i]= (int) (Math.random()*100 +0);
            array2[i]= (int) (Math.random()*100 +0);
            array3[i]= x;
            x--;       
        }
       
        
         for (int i=0; i<1; i++){
            System.out.println("The elements of Array1"+ Arrays.toString(array1));
            System.out.println("The elements of Array2"+ Arrays.toString(array2));
            System.out.println("The elements of Array3"+ Arrays.toString(array3));
        }
         
        
        BubbleSort(array1); 
        System.out.println("The elements of Array1 after sorting with bubble sort are: "+ Arrays.toString(array1));
        SelectionSort(array1); 
        System.out.println("The elements of Array1 after sorting with selection sort are: "+ Arrays.toString(array1));
        quickSort(array1);
        System.out.println("The elements of Array1 after sorting with quick sort are: "+ Arrays.toString(array1));
        
        BubbleSort(array2); 
        System.out.println("The elements of Array1 after sorting with bubble sort are: "+ Arrays.toString(array2));
        SelectionSort(array2); 
        System.out.println("The elements of Array1 after sorting with selection sort are: "+ Arrays.toString(array2));
        quickSort(array2);
        System.out.println("The elements of Array1 after sorting with quick sort are: "+ Arrays.toString(array2));
        
        BubbleSort(array3); 
        System.out.println("The elements of Array1 after sorting with bubble sort are: "+ Arrays.toString(array3));
        SelectionSort(array3); 
        System.out.println("The elements of Array1 after sorting with selection sort are: "+ Arrays.toString(array3));
        quickSort(array3);
        System.out.println("The elements of Array1 after sorting with quick sort are: "+ Arrays.toString(array3));
        
        



}

}