package com.testFile;

import java.io.File;

public class CleanLeft {
    public static void main(String[] args) {
        String path = "H:\\备份 温浩然\\G\\F盘";        //要遍历的路径
        String aimPath = "H:\\备份 温浩然\\G\\F盘";
        File file = new File(path);        //获取其file对象
        func(file);
    }

    public static void func(File file) {
        File[] files = file.listFiles();
        for (File f : files
        ) {
            File[] files1 = f.listFiles();


        }
    }
}
