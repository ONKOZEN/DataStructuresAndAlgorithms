package com.dataStructure.biSearch;

public class TestBigArrBiSearch {
    public static void main(String[] args) {
        Long pre = System.currentTimeMillis();
        int flag = 0;
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                for (int k = 0; k < 2000; k++) {
                    flag  = flag >> 1;
                }
            }
        }
        System.out.println("flag = "+flag);
        Long after = System.currentTimeMillis();
        System.out.println(pre);
        System.out.println(after);
        System.out.println("time = "+(after-pre));
    }
}
