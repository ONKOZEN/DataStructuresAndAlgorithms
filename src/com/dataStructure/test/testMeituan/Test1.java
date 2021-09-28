package com.dataStructure.test.testMeituan;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(sum(n));

    }
    public static int sum(int n){
        if(n>=0&&n<3){
            if(n == 0){
                return 0;
            }
            if(n == 1){
                return 2;
            }
            if (n == 2){
                return 4;
            }
        }
        if(n >= 3){
            if(n % 2 == 1){
                double sum = Math.pow(2,n)-Math.pow(2,n-2)*((((n-1)/2)-1)*2+1);
                return ((int)sum);
            }
            if(n % 2 == 0){
                double sum = Math.pow(2,n)-Math.pow(2,n-2)*(((n/2)-1)*2);
                return ((int)sum);
            }
        }

        return 0;
    }
}
