package com.testFile;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class cleanDir {
    public static void main(String[] args) {
        String path = "H:\\备份 温浩然\\G\\F盘";
        String aimPath = "H:\\备份 温浩然\\G\\F盘";
        String deletePath = "H:\\备份 温浩然\\G\\F盘\\xfmovie";
        File file = new File(path);
        Map<String, String> extMap = new HashMap<>();
        extMap.put("avi", "avi");
        extMap.put("AVI", "AVI");
        extMap.put("mkv", "mkv");
        extMap.put("MKV", "MKV");
        extMap.put("mp4", "mp4");
        extMap.put("MP4", "MP4");
        extMap.put("wmv", "wmv");
        extMap.put("WMV", "WMV");
        extMap.put("rmvb", "rmvb");
        extMap.put("torrent", "torrent");
        func(file, aimPath, deletePath, extMap);
    }

    private static void func(File file, String aimPath, String deletePath, Map<String, String> extMap) {
        int deleteFlag = 0;
        int moveFlag = 0;
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (f.isDirectory()) {
                if (f.getName().equals("論壇文宣") || f.getName().equals("宣传文本")) {
                    System.out.println("删除了文件：" + f.getName());
                    try {
                        deleteFlag+=1;
                        Files.move(Paths.get(f.getAbsolutePath()), Paths.get(deletePath + "\\" + f.getName()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (getFileNum(f) >= 3) {
                    continue;
                }
                func(f, aimPath, deletePath, extMap);
            }

            if (f.isFile()) {
                if (ifInExtMap(extMap, getExt(f))) {
                    try {
                        System.out.println("移动了文件：" + f.getName());
                        Files.move(Paths.get(f.getAbsolutePath()), Paths.get(aimPath + "\\" + f.getName()), StandardCopyOption.REPLACE_EXISTING);
                        moveFlag += 1;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else if(getExt(f).equals("torrent")){
                    System.out.println("删除了文件：" + f.getName());
                    try {
                        deleteFlag+=1;
                        Files.move(Paths.get(f.getAbsolutePath()), Paths.get(deletePath + "\\" + f.getName()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("本次运行移动了" + moveFlag + "个文件，删除了" + deleteFlag + "个空文件夹");
    }

    private static String getExt(File file) {
        if (file != null) {
            return file.getName().substring(file.getName().lastIndexOf(".") + 1);
        }
        return null;
    }

    private static boolean ifInExtMap(Map<String, String> extMap, String string) {
        if (extMap == null || string == null) {
            return false;
        }
        return extMap.containsKey(string);
    }

    private static boolean findEmptyDir(File file) {
        if (!file.isDirectory()) {
            return false;
        }
        return Objects.requireNonNull(file.listFiles()).length == 0;
    }

    private static int getFileNum(File file) {
        if (!file.isDirectory()) {
            return 0;
        }
        return Objects.requireNonNull(file.listFiles()).length;
    }
}
