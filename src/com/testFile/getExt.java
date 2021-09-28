package com.testFile;

import java.io.File;


public class getExt {
    public static void main(String[] args) {
        String path = "H:\\备份 温浩然\\G\\F盘";        //要遍历的路径
        String aimPath = "H:\\备份 温浩然\\G\\F盘";
        File file = new File(path);        //获取其file对象
        func(file);
    }

    private static void func(File file) {
        int flag = 0;
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory() && getFileNum(f) == 0){
                System.out.println("删除名为"+f.getName()+"的空文件夹");
                f.delete();
                flag+=1;
            }

        }
        System.out.println("本次整理删除了"+flag+"个空文件夹");
    }
    private static int getFileNum(File file) {
        if (!file.isDirectory()) {
            return -1;
        }
        return file.listFiles().length;
    }

}
