package com.wangxiaolin.materials.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wangxiaolin
 * @date 2019/12/27 - 16:29
 */
public class FileUtils {
    public static Boolean uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        FileOutputStream out = null;
        try {
            File targetFile = new File(filePath);
            //如果目录不存在，创建目录
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            out = new FileOutputStream(filePath+fileName);
            out.write(file);
            out.flush();
            //写入成功
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            //写入失败
            return false;
        } finally {
            out.close();
        }
    }
}