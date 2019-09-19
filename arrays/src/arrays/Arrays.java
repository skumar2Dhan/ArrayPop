/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Arrays {

    public static void main(String[] args) {

        int[][] two = new int[3][3];
        for (int i = 0; i < two.length; i++) {
            for (int x = 0; x < two.length; x++) {
                System.out.println("Pleas input: ");
                Scanner console = new Scanner(System.in);
                two[i][x] = console.nextInt();

            }
        }
        System.out.println();
            for (int a = 0; a < two.length; a++) {
                for (int b = 0; b< two.length; b++) {
                    System.out.println(two[a][b]);

        }

    }




