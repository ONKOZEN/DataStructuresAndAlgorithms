package com.testFile;

import java.io.File;
import java.util.Objects;

public class DeleteUselessFiles {
    public static void main(String[] args) {
        String path = "H:\\备份 温浩然\\G\\F盘";
        File file = new File(path);
        deleteFiles(file);
    }

    public static void deleteFiles(File file) {
        if (file == null) {
            return;
        }
        File[] files = file.listFiles();
        int deleteFlag = 0;
        for (File f : files) {
            if (f.isDirectory() && Objects.requireNonNull(f.listFiles()).length == 0) {
                deleteFlag+=1;
                System.out.println("删除了名为"+f.getName()+"的第"+deleteFlag+"个文件夹");
                f.delete();
            } else if (getExt(f).equals("torrent")) {
                deleteFlag+=1;
                System.out.println("删除了名为"+f.getName()+"的第"+deleteFlag+"个无用文件");
                f.delete();
            }
        }
        System.out.println("**********************************\n共删除了"+deleteFlag+"个无用文件");
    }

    public static String getExt(File file) {
        if (file == null) {
            return null;
        }
        String[] split = file.getName().split("\\.");
        return split[split.length - 1];
    }
    public static String getExt(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        return split[split.length - 1];
    }
}
