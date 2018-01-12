package com.i2f.teach;

import java.io.File;

/**
 * @author ChenWei 2018-01-12 09:55
 **/
public class FileUtil {
  //判断文件是否存在，存在则删除
  public static void isFileExistsAndDelete(File file){
    if(file.exists()){
      file.delete();
    }
  }
  //判断文件是否存在，不存在则报错
  public static void isFileExists(File file){
    if (!file.exists()){
      throw new RuntimeException("文件不存在");
    }
  }
  //判断是否文件夹，并做一定操作
  public static void  isDirectoryExists(File file){
    if (file.exists()){
      if (file.isDirectory()){
        //个人操作处理
        System.out.println("isDirectory");
      }
    }
  }
}
