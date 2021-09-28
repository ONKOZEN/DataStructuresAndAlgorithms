package com.dataStructure.test.testMeituan;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String ac = in.next();
        char[] c = ac.toCharArray();
        int numc = 0;
        for (int i = 0; i < c.length; i++) {
            if(c[i] == 'c'){
                numc+=1;
            }
        }
        int[] loc = new int[numc];
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            if(c[i] == 'c'){
                loc[j] = i;
                j+=1;
            }
        }
        System.out.println(Arrays.toString(loc));
        int sum = 0;
        for (int i = 0; i < loc.length; i++) {
            sum = sum + loc[i] - i;
        }
        System.out.println(sum);
    }
}
