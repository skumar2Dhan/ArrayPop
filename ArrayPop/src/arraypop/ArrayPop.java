/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraypop;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class ArrayPop {

    public static void main(String[] args) {
        
        Scanner console = new Scanner(System.in);
        
        System.out.print("Please enter a first integer: ");
        int integer1 = console.nextInt();
        System.out.print("Please enter a second integer: ");
        int integer2 = console.nextInt();
        System.out.print("Please enter a third integer: ");
        int integer3 = console.nextInt();
        System.out.print("Please enter a fourth integer: ");
        int integer4 = console.nextInt();
        
        Random rand = new Random();
        int r = rand.nextInt(10);
        
        int [] arrayCustom = {integer1, integer2, integer3, integer4};
        
        int [] random = new int[r];
        for(int i = 0; i<random.length; i++){
            Random filler = new Random();
            random[i] = filler.nextInt(100);     
        }
        
        System.out.println("Here is the user created array " 
                + Arrays.toString(arrayCustom));
        System.out.println("Here is the randomly generated array " 
                + Arrays.toString(random));
  
        printSort1(random);
        System.out.println("Here is the sorted version of the randomly "
                + "generated array " + Arrays.toString(random));
   
        double area = triangleArea(integer1, integer2, integer3);
        System.out.println("The area of the triangle with sides " + integer1 +
                ", " + integer2 + ", and " + integer3 + " is " + area);
        double length = segmentLength(integer1, integer2, integer3, integer4);
        System.out.println("The length of the segments " + integer1 + ", " + 
                integer2 + ", " + integer3 + ", and "
                + integer4 + " is " + length);
       
        for(int i = 0; i<random.length; i++){
            Random filler = new Random();
            random[i] = filler.nextInt(100);
        }
        
        System.out.println("Here is the revised randomly generated array "
                + Arrays.toString(random));
        
        printSort2(random);
        System.out.println("Here is the sorted version of the revised array " 
                + Arrays.toString(random));
        
    
}
    
    public static double triangleArea(int a, int b, int c){
        double s = (a + b + c)*.5;
        double q = (s *(s - a) * (s - b) * (s - c));
        double area = Math.sqrt(q);
        return area;   
    }
    
    public static int segmentLength(int alpha, int beta, int charlie, int delta){
        int length = alpha + beta + charlie + delta;
        return length;
    }
    
    /* This is the Selection Sort for Integer Array, Saahil Kumar, December 7th 2017 */
    public static void printSort1(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println(Arrays.toString(array));
            int index = i;
            for (int z = i + 1; z < array.length; z++) {
                if (array[z] < array[index]) {
                    index = z;
                }
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
    }

    /* This is the Bubble Sort for Integer Array, Saahil Kumar, December 7th 2017 */
    public static void printSort2(int[] array1) {
        int temp;
        int size = array1.length;
        for (int i = 0; i < size ; i++) {
            System.out.println(Arrays.toString(array1));
            for (int j =1; j < size; j++) {
                if (array1[j] < array1[j - 1]) {
                    temp = array1[j];
                    array1[j] = array1[j - 1];
                    array1[j - 1] = temp;
                    System.out.println(Arrays.toString(array1));
                }
            }
        }
    }
}
